package br.pucrio.dslmetrics.core.heuristics;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

import br.pucrio.dslmetrics.core.AbstractXmlRepository;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomalyCatalogDocument;
import br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomalyType;

public class XmlAnomalyRepository extends
		AbstractXmlRepository<AnomalyCatalogDocument, Anomaly> implements AnomalyRepository {

	public XmlAnomalyRepository(String filename) throws XmlRepositoryException {
		super(filename);
		createAnomalies(createDocument());
	}

	protected void createAnomalies(AnomalyCatalogDocument document)
			throws XmlRepositoryException {
		AnomalyType[] anomalies = document.getAnomalyCatalog()
				.getAnomalyArray();

		for (AnomalyType anomalyType : anomalies) {

			List<Class<? extends Entity>> appliedEntities = createAppliedEntities(anomalyType);
			Anomaly anomaly = new Anomaly(anomalyType.getId(), anomalyType
					.getName(), appliedEntities);

			identityMap.put(anomaly.getId(), anomaly);
		}
	}

	private List<Class<? extends Entity>> createAppliedEntities(
			AnomalyType anomalyType) throws XmlRepositoryException {

		String applyTo = anomalyType.getApplyTo();

		String[] splits = applyTo.split(",");

		List<Class<? extends Entity>> appliedEntities = new LinkedList<Class<? extends Entity>>();
		for (String entityType : splits) {
			if ("class".equalsIgnoreCase(entityType.trim()))
				appliedEntities
						.add(br.pucrio.dslmetrics.core.domain.Class.class);
			else if ("package".equalsIgnoreCase(entityType.trim()))
				appliedEntities.add(Package.class);
			else if ("method".equalsIgnoreCase(entityType.trim()))
				appliedEntities.add(Method.class);
			else if ("project".equalsIgnoreCase(entityType.trim()))
				appliedEntities.add(Project.class);
			else
				throw new XmlRepositoryException(MessageFormat.format(
						"\"{0}\" is not a valid entity type.", entityType),
						anomalyType, file);
		}

		return appliedEntities;
	}

	@Override
	public List<Anomaly> getAnomalies() {
		return new ArrayList<Anomaly>(identityMap.values());
	}

	@Override
	public Anomaly getAnomalyById(String id) {
		return identityMap.get(id);
	}

	@Override
	protected AnomalyCatalogDocument parseFile(XmlOptions options)
			throws XmlException, IOException {
		return AnomalyCatalogDocument.Factory.parse(file,options);
	}

	@Override
	protected void putNamespaces(Map<String, String> namespaces) {
		namespaces.put("", "AnomaliesCatalogFile");
	}

	@Override
	protected boolean validateDocument(AnomalyCatalogDocument document,
			XmlOptions options) {
		return document.validate(options);
	}

}
