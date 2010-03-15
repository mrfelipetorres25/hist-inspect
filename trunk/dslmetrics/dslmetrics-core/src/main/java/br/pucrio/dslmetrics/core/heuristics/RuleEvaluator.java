package br.pucrio.dslmetrics.core.heuristics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.domain.walker.DomainVisitorAdapter;

public class RuleEvaluator extends DomainVisitorAdapter {

	private static final String SCRIPT_LANGUAGE = "JavaScript";

	private Map<java.lang.Class<? extends Entity>, List<Rule>> entityRuleMap = new HashMap<java.lang.Class<? extends Entity>, List<Rule>>();

	private ScriptEngineManager manager = new ScriptEngineManager();
	private ScriptEngine engine = manager.getEngineByName(SCRIPT_LANGUAGE);

	private List<Detection> detections = new LinkedList<Detection>();
	private List<RuleEvaluationError> errors = new LinkedList<RuleEvaluationError>();

	public RuleEvaluator(List<Rule> rules) {
		classifyRules(rules);
	}

	private void classifyRules(List<Rule> rules) {
		for (Rule rule : rules) {

			List<Class<? extends Entity>> appliedEntities = rule.getAnomaly()
					.getAppliedEntities();

			for (java.lang.Class<? extends Entity> c : appliedEntities)
				addToEntityHeuristicMap(c, rule);
		}
	}

	private void addToEntityHeuristicMap(java.lang.Class<? extends Entity> c,
			Rule heuristic) {

		List<Rule> rules = entityRuleMap.get(c);

		if (rules == null) {
			rules = new LinkedList<Rule>();
			entityRuleMap.put(c, rules);
		}

		rules.add(heuristic);
	}

	@Override
	public void acceptEntity(Entity entity, int level) {

		List<Rule> rules = entityRuleMap.get(entity.getClass());

		if (rules != null) {
			
			SortedSet<Version> versions = entity.getVersions();
			
			for (Version version : versions) {
				for (Rule rule : rules) {

					Bindings bindings = createBindings(entity, version);

					try {
						Boolean detected = (Boolean) engine.eval(rule
								.getExpression(), bindings);

						if (detected)
							detections
									.add(new Detection(version, entity, rule));

					} catch (ScriptException e) {
						errors.add(new RuleEvaluationError(version, entity,
								rule, e));
					}
				}
			}
		}
	}

	private Bindings createBindings(Entity entity, Version version) {

		Bindings bindings = engine.createBindings();

		SortedSet<String> metricNames = entity.getMetricNames();

		for (String metricName : metricNames) {
			Double metricValue = entity.getMetricValue(version, metricName);
			bindings.put(metricName, metricValue);
		}

		return bindings;
	}

	public List<Detection> getDetections() {
		return detections;
	}

	public List<RuleEvaluationError> getErrors() {
		return errors;
	}
}
