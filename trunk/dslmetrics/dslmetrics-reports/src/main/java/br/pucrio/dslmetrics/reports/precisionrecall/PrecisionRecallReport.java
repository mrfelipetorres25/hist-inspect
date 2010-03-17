package br.pucrio.dslmetrics.reports.precisionrecall;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.walker.ProjectWalker;
import br.pucrio.dslmetrics.core.rules.Detection;
import br.pucrio.dslmetrics.core.rules.Rule;
import br.pucrio.dslmetrics.core.rules.RuleEvaluationError;
import br.pucrio.dslmetrics.core.rules.RuleEvaluator;

public class PrecisionRecallReport extends Report {

	public PrecisionRecallReport(Project project, List<Rule> rules)
			throws IOException, Exception {
		this.project = project;
		this.rules = rules;
	}

	private final List<Rule> rules;
	private final Project project;
	private Collection<Detection> detections;
	private RuleEvaluator ruleEvaluator = null;

	@Override
	protected void processTemplates() throws IOException, Exception {
		processTemplate("index.vm", "index.html");
	}

	@Override
	protected void evaluate() {
		ruleEvaluator = new RuleEvaluator(rules);
		ProjectWalker projectWalker = new ProjectWalker(ruleEvaluator);

		projectWalker.walk(project);

		detections = ruleEvaluator.getDetections();
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

}
