package br.pucrio.dslmetrics.ui.console;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.ProjectBuilderException;
import br.pucrio.dslmetrics.core.domain.ProjectReader;
import br.pucrio.dslmetrics.core.mtbl.XmlDomainBuilderException;
import br.pucrio.dslmetrics.core.mtbl.XmlMtblDomainBuilder;
import br.pucrio.dslmetrics.core.precisionrecall.ReferenceListCatalog;
import br.pucrio.dslmetrics.core.precisionrecall.ReferenceListCatalogRepository;
import br.pucrio.dslmetrics.core.precisionrecall.XmlReferenceListCatalogRepository;
import br.pucrio.dslmetrics.core.rules.AnomalyRepository;
import br.pucrio.dslmetrics.core.rules.Rule;
import br.pucrio.dslmetrics.core.rules.RuleEvaluationError;
import br.pucrio.dslmetrics.core.rules.RuleEvaluator;
import br.pucrio.dslmetrics.core.rules.RuleRepository;
import br.pucrio.dslmetrics.core.rules.XmlAnomalyRepository;
import br.pucrio.dslmetrics.core.rules.XmlRepositoryException;
import br.pucrio.dslmetrics.core.rules.XmlRuleRepository;
import br.pucrio.dslmetrics.reports.precisionrecall.PrecisionRecallReport;
import br.pucrio.dslmetrics.reports.precisionrecall.Report;
import br.pucrio.dslmetrics.reports.precisionrecall.ReportException;

public class Main {
	public static void main(String[] args) throws XmlRepositoryException,
			IOException {

		try {
			CommandLineOptions options = CliFactory.parseArguments(
					CommandLineOptions.class, args);

			File file = new File(options.getOutputPath());
			// if(file.exists()) {
			// System.out.print(MessageFormat.format("Directory \"{0}\" already exists, files will be overriten. Continue? [y/n]",
			// file.getName()));
			// InputStreamReader reader = new InputStreamReader(System.in);
			// int read = reader.read();
			//				
			// if(read != 'y')
			// System.exit(0);
			// }

			System.out.println("Loading anomalies...");
			AnomalyRepository anomalyRepository = new XmlAnomalyRepository(
					options.getAnomalyFile());

			System.out.println("Loading rules...");
			RuleRepository ruleRepository = new XmlRuleRepository(options
					.getRulesFile(), anomalyRepository);

			List<Rule> rules = ruleRepository.getRules();

			System.out.println("Loading all project versions...");
			ProjectReader projectReader = new ProjectReader(
					new XmlMtblDomainBuilder(options.getVersionsFile()));
			Project project = projectReader.readProject();

			System.out.println("Loading reference lists...");
			ReferenceListCatalogRepository referenceListRepository = new XmlReferenceListCatalogRepository(
					options.getReferenceListFile(), project, anomalyRepository);
			ReferenceListCatalog catalog = referenceListRepository.getCatalog();

			System.out.println("Evaluating entities...");
			Report report = new PrecisionRecallReport(project, rules, catalog);
			report.generateReport(file);

			System.out.println("Finished!");
		} catch (ArgumentValidationException e) {
			System.out
					.println("MINIMAL USAGE: dsl-metrics -v VERSIONS-FILE -o OUTPUT-REPORT");
			System.out.println(e.getValidationErrors());
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
		} catch (ReportException e) {
			System.out.println(e.getMessage());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void displayRulesEvaluatorErrors(RuleEvaluator ruleEvaluator) {
		List<RuleEvaluationError> errors = ruleEvaluator.getErrors();
		for (RuleEvaluationError error : errors) {
			System.err
					.println(MessageFormat
							.format(
									"ERROR in rule \"{0}\" while evaluating entity \"{1}\" version \"{2}\": {3} ",
									error.getRule().getId(), error.getEntity()
											.getName(), error.getVersion()
											.getNumber(), error
											.getScriptException().getMessage()));
		}
	}
}
