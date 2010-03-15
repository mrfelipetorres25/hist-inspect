package br.pucrio.dslmetrics.ui.console;

import java.io.IOException;
import java.text.MessageFormat;

import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.ProjectBuilderException;
import br.pucrio.dslmetrics.core.domain.ProjectReader;
import br.pucrio.dslmetrics.core.heuristics.XmlAnomalyRepository;
import br.pucrio.dslmetrics.core.heuristics.XmlRepositoryException;
import br.pucrio.dslmetrics.core.heuristics.XmlRuleRepository;
import br.pucrio.dslmetrics.core.mtbl.XmlDomainBuilderException;
import br.pucrio.dslmetrics.core.mtbl.XmlMtblDomainBuilder;
import br.pucrio.dslmetrics.core.precisionrecall.XmlReferenceListCatalogRepository;

public class Main {
	public static void main(String[] args) throws XmlRepositoryException,
			IOException {

		try {
			ProjectReader factory = new ProjectReader(new XmlMtblDomainBuilder(
					"samples/MobileMedia/MobileMedia.ver.xml"));

			Project project = factory.readProject();

			XmlAnomalyRepository anomalyRepo = new XmlAnomalyRepository(
					"conf/Anomalies.xml");
			XmlRuleRepository ruleRepo = new XmlRuleRepository(
					"conf/Rules.xml", anomalyRepo);
			XmlReferenceListCatalogRepository referenceListCatalogRepository = new XmlReferenceListCatalogRepository(
					"samples/MobileMedia/MobileMedia.reflist.xml", project,
					anomalyRepo);


		} catch (XmlDomainBuilderException e) {
			System.out.println(MessageFormat.format(
					"Error in file {0} line {1} column {2} - {3}", e.getFile()
							.getName(), e.getLine(), e.getColumn(), e
							.getMessage()));
		} catch (ProjectBuilderException e) {
			System.out.println(e.getMessage());

		} catch (XmlRepositoryException e) {
			System.out.println(MessageFormat.format(
					"Error in file {0} line {1} column {2} - {3}", e.getFile()
							.getName(), e.getLine(), e.getColumn(), e
							.getMessage()));
		}

	}
}
