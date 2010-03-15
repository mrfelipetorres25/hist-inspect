package br.pucrio.dslmetrics.core.precisionrecall;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

import br.pucrio.dslmetrics.core.AbstractXmlRepository;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.heuristics.Anomaly;
import br.pucrio.dslmetrics.core.heuristics.AnomalyRepository;
import br.pucrio.dslmetrics.core.heuristics.XmlRepositoryException;
import br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType;
import br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogDocument;
import br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType;

public class XmlReferenceListCatalogRepository
		extends
		AbstractXmlRepository<ReferenceListCatalogDocument, ReferenceListCatalog> {

	private ReferenceListCatalogDocument document;

	private ReferenceListCatalog catalog = null;

	private final Project project;

	private final AnomalyRepository anomalyRepository;

	public XmlReferenceListCatalogRepository(String filename, Project project,
			AnomalyRepository anomalyRepository) throws XmlRepositoryException {
		super(filename);

		this.project = project;
		this.anomalyRepository = anomalyRepository;

		document = createDocument();
		createCatalog();
	}

	public ReferenceListCatalog getReferenceListCatalog() {
		return catalog;
	}

	private void createCatalog() throws XmlRepositoryException {
		AnomalyType[] anomalyArray = document.getReferenceListCatalog()
				.getAnomalyArray();

		Set<ReferenceList> referenceLists = new HashSet<ReferenceList>();

		for (AnomalyType anomalyType : anomalyArray)
			referenceLists.add(readAnomaly(anomalyType));

		catalog = new ReferenceListCatalog(project, referenceLists);
	}

	private ReferenceList readAnomaly(AnomalyType anomalyType)
			throws XmlRepositoryException {
		Anomaly anomaly = anomalyRepository.getAnomalyById(anomalyType.getId());

		if (anomaly == null)
			throw new XmlRepositoryException(MessageFormat.format(
					"Anomaly with id \"{0}\" does not exist.", anomalyType
							.getId()), anomalyType, file);

		ReferenceList referenceList = new ReferenceList(anomaly);

		readVersion(anomalyType, referenceList);

		return referenceList;
	}

	private void readVersion(AnomalyType anomalyType,
			ReferenceList referenceList) throws XmlRepositoryException {

		VersionType[] versionArray = anomalyType.getVersionArray();

		for (VersionType versionType : versionArray) {
			Version version = project.getVersionByNumber(versionType
					.getNumber());

			if (version == null)
				throw new XmlRepositoryException(MessageFormat.format(
						"Version number \"{0}\" does not exist.", versionType
								.getNumber()), versionType, file);

			referenceList.setEntitiesWithAnomaly(version,
					readEntity(versionType));
		}
	}

	private Set<Entity> readEntity(VersionType versionType)
			throws XmlRepositoryException {

		String[] entityArray = versionType.getEntityArray();

		Set<Entity> entities = new HashSet<Entity>();

		for (String entityName : entityArray) {
			Entity entity = project.getEntity(entityName.trim());

			if (entity == null)
				throw new XmlRepositoryException(MessageFormat
						.format("Entity with name \"{0}\" doest not exist.",
								entityName), versionType, file);

			entities.add(entity);
		}

		return entities;
	}

	@Override
	protected ReferenceListCatalogDocument parseFile(XmlOptions options)
			throws XmlException, IOException {
		return ReferenceListCatalogDocument.Factory.parse(file, options);
	}

	@Override
	protected void putNamespaces(Map<String, String> namespaces) {
		namespaces.put("", "ReferenceListFile");
	}

	@Override
	protected boolean validateDocument(ReferenceListCatalogDocument document,
			XmlOptions options) {
		return document.validate(options);
	}

}
