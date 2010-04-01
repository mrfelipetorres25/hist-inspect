package br.pucrio.dslmetrics.core.mtbl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.ProjectBuilder;
import br.pucrio.dslmetrics.core.domain.ProjectBuilderException;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType;
import br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsDocument;
import br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType;
import br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType;
import br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType;
import br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.VersionsDocument;

public class XmlMtblDomainBuilder implements ProjectBuilder {

	public interface DocumentCreator<T extends XmlObject> {
		T parse(File file, XmlOptions xmlOptions) throws XmlException,
				IOException;
	}

	public class VersionsDocumentCreator implements
			DocumentCreator<VersionsDocument> {

		@Override
		public VersionsDocument parse(File file, XmlOptions xmlOptions)
				throws XmlException, IOException {
			
			Map<String,String> map = new HashMap<String, String>();
			map.put("", "MtblVersionsFile");
			xmlOptions.setLoadSubstituteNamespaces(map);
			
			return VersionsDocument.Factory.parse(file, xmlOptions);
		}
	}

	public class MetricResultsDocumentCreator implements
			DocumentCreator<MetricResultsDocument> {
		
		@Override
		public MetricResultsDocument parse(File file, XmlOptions xmlOptions)
				throws XmlException, IOException {
			
			Map<String,String> map = new HashMap<String, String>();
			map.put("", "TogetherMtbl");
			xmlOptions.setLoadSubstituteNamespaces(map);
			
			return MetricResultsDocument.Factory.parse(file, xmlOptions);
		}

	}

	public interface EntityCreator<T extends Entity> {

		public T newEntity(String name, String fullQualifiedName);

		public boolean isCorrectInstance(Entity entity);

	}

	public interface ChildrenPopulator<T extends Entity> {
		public void populateChildren(MetricDescriptionType[] children,
				T entity, Version version) throws ProjectBuilderException;
	}

	private final class PackageChildrenPopulator implements
			ChildrenPopulator<Package> {
		@Override
		public void populateChildren(MetricDescriptionType[] children,
				Package pack, Version version) throws ProjectBuilderException {

			List<Package> packages = new LinkedList<Package>();
			List<Class> classes = new LinkedList<Class>();

			for (MetricDescriptionType metricDescriptionType : children) {

				if (metricDescriptionType.getKind() == PACKAGE_KIND)
					addPackage(metricDescriptionType, packages, version);
				else if (metricDescriptionType.getKind() == CLASS_KIND)
					addClass(metricDescriptionType, classes, version);
				else
					throwXmlDomainBuilderException(
							"Inconsistent .mtbl file. Children of package or project must have kind equals to \"1\"(package) or \"2\" (class).",
							metricDescriptionType, null, versionFileMap
									.get(version));

			}

			pack.addClasses(version, classes);
			pack.addPackages(version, packages);

		}
	}

	private final class ClassChildrenPopulator implements
			ChildrenPopulator<Class> {
		@Override
		public void populateChildren(MetricDescriptionType[] children,
				Class entity, Version version)
				throws ProjectBuilderException {
	
			LinkedList<Method> methods = new LinkedList<Method>();
			LinkedList<Class> classes = new LinkedList<Class>();
	
			for (MetricDescriptionType child : children) {
				if (child.getKind() == METHOD_KIND)
					addMethod(child, methods, version);
				else if (child.getKind() == CLASS_KIND)
					addClass(child, classes, version);
				else
					throwXmlDomainBuilderException(
							"Inconsistent .mtbl file. Children of package or project must have kind equals to \"2\"(class) or \"3\" (method).",
							child, null, versionFileMap.get(version));
	
			}
	
			entity.setMethods(version, methods);
			entity.setClasses(version, classes);
		}
	}

	private final class EmptyChildrenPopulator implements
			ChildrenPopulator<Method> {
		@Override
		public void populateChildren(MetricDescriptionType[] children,
				Method entity, Version version)
				throws ProjectBuilderException {
		}
	}

	private static final int PROJECT_KIND = 0;

	private static final int PACKAGE_KIND = 1;

	private static final int CLASS_KIND = 2;

	private static final int METHOD_KIND = 3;

	private Map<Version, File> versionFileMap = new HashMap<Version, File>();

	private Map<Entity, Map<Version, MetricDescriptionType>> domainXmlObjectMap = new HashMap<Entity, Map<Version, MetricDescriptionType>>();

	private Project project;

	private Map<String, Entity> identityMap = new HashMap<String, Entity>();

	private VersionsDocument versionsDocument;

	private File versionsFile;

	private URI baseURI;

	private String filename;

	public XmlMtblDomainBuilder(String filename) throws ProjectBuilderException {
		this.filename = filename;

		init();
	}

	@Override
	public Class buildClass(Class clazz) throws ProjectBuilderException {
		return buildEntity(clazz, new ClassChildrenPopulator());
	}

	@Override
	public Method buildMethod(Method method) throws ProjectBuilderException {
		return buildEntity(method, new EmptyChildrenPopulator());
	}

	@Override
	public Package buildPackage(Package pack) throws ProjectBuilderException {

		return buildEntity(pack, new PackageChildrenPopulator());

	}

	private <T extends Entity> T buildEntity(T entity,
			ChildrenPopulator<T> populator) throws ProjectBuilderException {

		Map<Version, MetricDescriptionType> map = domainXmlObjectMap
				.get(entity);

		Set<Entry<Version, MetricDescriptionType>> entrySet = map.entrySet();

		for (Entry<Version, MetricDescriptionType> entry : entrySet) {

			MetricDescriptionType metricDescriptionType = entry.getValue();
			Version version = entry.getKey();

			populator.populateChildren(metricDescriptionType
					.getMetricDescriptionArray(), entity, version);
			populateMetrics(metricDescriptionType.getMetricArray(), entity,
					version);
		}

		return entity;

	}

	private void addPackage(MetricDescriptionType metricDescriptionType,
			List<Package> packages, Version version)
			throws ProjectBuilderException {
		addEntity(metricDescriptionType, packages, version,
				new EntityCreator<Package>() {

					@Override
					public boolean isCorrectInstance(Entity entity) {
						return entity instanceof Package;
					}

					@Override
					public Package newEntity(String name, String fullQualifiedName) {
						return new Package(name,fullQualifiedName);
					}
				});
	}

	private void addClass(MetricDescriptionType metricDescriptionType,
			List<Class> classes, Version version) throws ProjectBuilderException {

		addEntity(metricDescriptionType, classes, version,
				new EntityCreator<Class>() {

					@Override
					public Class newEntity(String name, String fullQualifiedName) {
						return new Class(name,fullQualifiedName);
					}

					@Override
					public boolean isCorrectInstance(Entity entity) {
						return entity instanceof Class;
					}
				});
	}

	private void addMethod(MetricDescriptionType child,
			LinkedList<Method> methods, Version version)
			throws ProjectBuilderException {

		addEntity(child, methods, version, new EntityCreator<Method>() {
			@Override
			public boolean isCorrectInstance(Entity entity) {
				return entity instanceof Method;
			}

			@Override
			public Method newEntity(String name, String fullQualifiedName) {
				return new Method(name,fullQualifiedName);
			}
		});

	}

	private <T extends Entity> void addEntity(
			MetricDescriptionType metricDescriptionType, List<T> entities,
			Version version, EntityCreator<T> creator)
			throws ProjectBuilderException {

		Entity entity = identityMap.get(metricDescriptionType.getFqname());

		if (entity == null)
			addNewEntity(metricDescriptionType, entities, version, creator);
		else
			addExistentEntity(metricDescriptionType, entities, version,
					creator, entity);
	}

	@SuppressWarnings("unchecked")
	private <T extends Entity> void addExistentEntity(
			MetricDescriptionType metricDescriptionType, List<T> entities,
			Version version, EntityCreator<T> creator, Entity entity)
			throws ProjectBuilderException {

		if (creator.isCorrectInstance(entity)) {

			entities.add((T) entity);
			Map<Version, MetricDescriptionType> map = domainXmlObjectMap
					.get(entity);
			map.put(version, metricDescriptionType);

		} else
			throw new ProjectBuilderException(
					MessageFormat
							.format(
									"Inconsistent .mtbl file. Probably there is more than one element with fqname value equals to \"{0}\"",
									entity.getName()));
	}

	private <T extends Entity> void addNewEntity(
			MetricDescriptionType metricDescriptionType, List<T> entities,
			Version version, EntityCreator<T> creator) {

		T childEntity = creator.newEntity(metricDescriptionType.getName(), metricDescriptionType.getFqname());
		entities.add(childEntity);
		identityMap.put(childEntity.getName(), childEntity);

		HashMap<Version, MetricDescriptionType> versionMetricDescriptionMap = new HashMap<Version, MetricDescriptionType>();
		versionMetricDescriptionMap.put(version, metricDescriptionType);
		domainXmlObjectMap.put(childEntity, versionMetricDescriptionMap);

	}

	private void populateMetrics(MetricType[] mtblMetrics, Entity entity,
			Version version) {

		//Map<String, Double> metricsMap = new HashMap<String, Double>();
		Map<Metric, Double> metricsMap = new HashMap<Metric, Double>();
		//List<Metric> metricList = new ArrayList<Metric>();
		

		for (MetricType metricType : mtblMetrics) {
			String metricName = metricType.getName();
			double metricValue = metricType.getValue();

			String[] split = metricName.split(":");

			if (split.length == 2)
				metricName = split[1];
			
			Metric metric = new CalculatedMetric(metricName);

			metricsMap.put(metric, metricValue);
		}

		entity.setMetrics(version, metricsMap);
	}

	private MetricDescriptionType retrieveProjectInMtblFile(File mtblFile,
			MetricResultsType metricResults) throws XmlDomainBuilderException {

		MetricDescriptionType[] metricDescriptionArray = metricResults
				.getMetricDescriptionArray();

		if (metricDescriptionArray.length != 1)
			throwXmlDomainBuilderException(
					"File does not have just one project as root entity. Please, provide a .mtbl file with just one project as root entity.",
					metricResults, null, mtblFile);
		else if (metricDescriptionArray[0].getKind() != PROJECT_KIND)
			throwXmlDomainBuilderException(
					"The root entity of the file is not a project. Please, provide a .mtbl file with just one project as root entity.",
					metricResults, null, mtblFile);

		MetricDescriptionType mtblProject = metricDescriptionArray[0];
		return mtblProject;
	}

	@Override
	public Project buildProject() throws ProjectBuilderException {

		loadVersions();

		Set<Version> versions = versionFileMap.keySet();

		for (Version version : versions) {

			File mtblFile = versionFileMap.get(version);

			MetricResultsType metricResults = createDocument(mtblFile,
					new MetricResultsDocumentCreator()).getMetricResults();

			MetricDescriptionType mtblProject = retrieveProjectInMtblFile(
					mtblFile, metricResults);

			if (project == null)
				project = new Project(mtblProject.getName(),mtblProject.getFqname());

			new PackageChildrenPopulator().populateChildren(mtblProject
					.getMetricDescriptionArray(), project, version);
			populateMetrics(mtblProject.getMetricArray(), project, version);

		}

		return project;
	}

	private void loadVersions() throws ProjectBuilderException {

		MtblVersionType[] mtblVersionArray = versionsDocument.getVersions()
				.getVersionArray();

		for (MtblVersionType mtblVersion : mtblVersionArray) {

			Version version = new Version(mtblVersion.getNumber(), mtblVersion.getName());
			versionFileMap.put(version, new File(
					resolveMtblFilesURL(mtblVersion)));
		}

	}

	private URI resolveMtblFilesURL(MtblVersionType mtblVersion)
			throws ProjectBuilderException {

		URI uri = null;
		try {

			uri = new URI(mtblVersion.getRef());
			uri = baseURI.resolve(uri);

		} catch (URISyntaxException e) {
			throwXmlDomainBuilderException(MessageFormat.format(
					"Error parsing URI \"{0}\".", mtblVersion.getRef()),
					mtblVersion, e, versionsFile);
		}
		return uri;
	}

	private void init() throws ProjectBuilderException {

		versionsFile = new File(filename);
		baseURI = versionsFile.toURI();

		versionsDocument = createDocument(versionsFile,
				new VersionsDocumentCreator());

	}

	private <T extends XmlObject> T createDocument(File file,
			DocumentCreator<T> documentCreator) throws ProjectBuilderException {

		LinkedList<XmlError> xmlErrors = new LinkedList<XmlError>();

		XmlOptions xmlOptions = new XmlOptions().setLoadLineNumbers()
				.setErrorListener(xmlErrors);

		try {
			T document = documentCreator.parse(file, xmlOptions);

			if (!document.validate(xmlOptions))
				throwXmlDomainBuilderException(xmlErrors.getFirst(), file);

			return document;

		} catch (XmlException e) {
			throwXmlDomainBuilderException(e.getError(), file);
		} catch (FileNotFoundException e) {
			throw new ProjectBuilderException(MessageFormat.format(
					"File \"{0}\" was not found.", file.getAbsolutePath()), e);
		} catch (IOException e) {
			throw new ProjectBuilderException(
					MessageFormat
							.format(
									"An error occured while reading file \"{0}\". The file may be corrupted.",
									file.getAbsolutePath()), e);
		}

		return null; // Nunca acontecerá.
	}

	private void throwXmlDomainBuilderException(String message,
			XmlObject xmlObject, Throwable cause, File file)
			throws XmlDomainBuilderException {

		XmlDomainBuilderException xmlDomainBuilderException;

		if (cause == null) {
			xmlDomainBuilderException = new XmlDomainBuilderException(message);
		} else
			xmlDomainBuilderException = new XmlDomainBuilderException(message,
					cause);

		XmlLineNumber lineNumber = (XmlLineNumber) xmlObject.newCursor()
				.getBookmark(XmlLineNumber.class);

		xmlDomainBuilderException.setLine(lineNumber.getLine());
		xmlDomainBuilderException.setColumn(lineNumber.getColumn());
		xmlDomainBuilderException.setFile(file);

		throw xmlDomainBuilderException;
	}

	private void throwXmlDomainBuilderException(XmlError error, File file)
			throws XmlDomainBuilderException {
		XmlDomainBuilderException xmlDomainBuilderException = new XmlDomainBuilderException(
				error.getMessage());

		xmlDomainBuilderException.setLine(error.getLine());
		xmlDomainBuilderException.setColumn(error.getColumn());
		xmlDomainBuilderException.setFile(file);

		throw xmlDomainBuilderException;
	}

	@Override
	public Map<String, Entity> getIdentityMap() {
		return identityMap;		
	}

}
