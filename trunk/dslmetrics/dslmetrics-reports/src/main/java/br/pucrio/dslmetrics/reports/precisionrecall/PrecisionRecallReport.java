package br.pucrio.dslmetrics.reports.precisionrecall;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.velocity.VelocityContext;

import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.walker.ProjectWalker;
import br.pucrio.dslmetrics.core.precisionrecall.PrecisionAndRecall;
import br.pucrio.dslmetrics.core.precisionrecall.ReferenceList;
import br.pucrio.dslmetrics.core.precisionrecall.ReferenceListCatalog;
import br.pucrio.dslmetrics.core.rules.Anomaly;
import br.pucrio.dslmetrics.core.rules.Detection;
import br.pucrio.dslmetrics.core.rules.Rule;
import br.pucrio.dslmetrics.core.rules.RuleEvaluationError;
import br.pucrio.dslmetrics.core.rules.RuleEvaluator;

public class PrecisionRecallReport extends Report {

	private final ReferenceListCatalog catalog;

	public PrecisionRecallReport(Project project, List<Rule> rules,
			ReferenceListCatalog catalog) throws IOException, Exception {
		this.project = project;
		this.rules = rules;
		this.catalog = catalog;
	}

	private final List<Rule> rules;
	private final Project project;
	private Collection<Detection> detections;
	private RuleEvaluator ruleEvaluator = null;
	private Collection<PrecisionAndRecall> precisionsAndRecalls = new LinkedList<PrecisionAndRecall>();

	@Override
	protected void processTemplates() throws IOException, Exception {
		processTemplate("index.vm", "index.html");
		processTemplate("errors.vm", "errors.html");
		processTemplate("precAndRecIndex.vm", "precAndRecIndex.html");
		processDetections();
		processPrecisionsAndRecalls();
	}

	private void processPrecisionsAndRecalls() throws IOException, Exception {

		VelocityContext context = new VelocityContext(getContext());

		for (PrecisionAndRecall precision : precisionsAndRecalls) {
			context.put("precAndRec", precision);
			processTemplate("precAndRec.vm", "precAndRec-"
					+ precision.getDetection().getRule().getId() + ".html",
					context);
		}
	}

	private void processDetections() throws IOException, Exception {

		VelocityContext context = new VelocityContext(getContext());

		for (Detection detection : detections) {
			context.put("detection", detection);
			processTemplate("detections.vm", "detec-"
					+ detection.getRule().getId() + ".html", context);
		}

	}

	@Override
	protected void evaluate() throws ReportException {
		ruleEvaluator = new RuleEvaluator(rules);
		ProjectWalker projectWalker = new ProjectWalker(ruleEvaluator);

		projectWalker.walk(project);

		detections = ruleEvaluator.getDetections();

		for (Detection detection : detections) {

			Anomaly anomaly = detection.getRule().getAnomaly();
			ReferenceList referenceList = catalog
					.getReferenceListForAnomaly(anomaly);

			if (referenceList == null)
				throw new ReportException(MessageFormat.format(
						"ERROR - Reference list for anomaly \"{0}\" does not exist.",
						anomaly.getName()));

			precisionsAndRecalls.add(new PrecisionAndRecall(project, detection,
					referenceList));
		}
	}

	public List<RuleEvaluationError> getErrors() {
		if (ruleEvaluator != null)
			return ruleEvaluator.getErrors();
		else
			return Collections.emptyList();
	}

	public Collection<Detection> getDetections() {
		return detections;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public Project getProject() {
		return project;
	}

	public Collection<PrecisionAndRecall> getPrecisionsAndRecalls() {
		return precisionsAndRecalls;
	}
}
