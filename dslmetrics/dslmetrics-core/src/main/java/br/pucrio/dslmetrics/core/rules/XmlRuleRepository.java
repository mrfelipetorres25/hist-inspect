package br.pucrio.dslmetrics.core.rules;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

import br.pucrio.dslmetrics.core.AbstractXmlRepository;
import br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogDocument;
import br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType;

public class XmlRuleRepository extends
		AbstractXmlRepository<RuleCatalogDocument, Rule> implements RuleRepository {

	private final AnomalyRepository anomalyRepository;

	public XmlRuleRepository(String filename,
			AnomalyRepository anomalyRepository) throws XmlRepositoryException {
		super(filename);
		this.anomalyRepository = anomalyRepository;
		createRules(createDocument());
	}

	@Override
	public List<Rule> getRules() {
		return new ArrayList<Rule>(identityMap.values());
	}


	private void createRules(RuleCatalogDocument document)
			throws XmlRepositoryException {
		RuleType[] rules = document.getRuleCatalog().getRuleArray();
	
		for (RuleType ruleType : rules) {
	
			Anomaly anomaly = getAnomaly(ruleType);
	
			Rule rule = new Rule(ruleType.getId(), ruleType.getName(), ruleType
					.getExpression(), anomaly);
			anomaly.addRule(rule);
	
			identityMap.put(rule.getId(), rule);
		}
	}

	private Anomaly getAnomaly(RuleType ruleType) throws XmlRepositoryException {
		Anomaly anomaly = anomalyRepository.getAnomalyById(ruleType
				.getAnomaly());
		if (anomaly == null)
			throw new XmlRepositoryException(MessageFormat
					.format("Anomaly with id \"{0}\" not found.", ruleType
							.getAnomaly()), ruleType, file);
	
		return anomaly;
	}

	@Override
	protected void putNamespaces(Map<String, String> namespaces) {
		namespaces.put("", "RuleCatalogFile");
	}

	@Override
	protected RuleCatalogDocument parseFile(XmlOptions options)
			throws XmlException, IOException {

		return RuleCatalogDocument.Factory.parse(file, options);
	}

	@Override
	protected boolean validateDocument(RuleCatalogDocument document,
			XmlOptions options) {
		return document.validate(options);
	}

}
