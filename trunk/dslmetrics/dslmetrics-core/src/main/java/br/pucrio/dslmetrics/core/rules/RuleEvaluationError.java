package br.pucrio.dslmetrics.core.rules;

import javax.script.ScriptException;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;

public class RuleEvaluationError {

	private final ScriptException scriptException;
	private final Version version;
	private final Entity entity;
	private final Rule heuristic;

	public RuleEvaluationError(Version version, Entity entity, Rule rule,
			ScriptException e) {

		this.version = version;
		this.entity = entity;
		this.heuristic = rule;
		this.scriptException = e;
	}

	public ScriptException getScriptException() {
		return scriptException;
	}

	public Version getVersion() {
		return version;
	}

	public Entity getEntity() {
		return entity;
	}

	public Rule getRule() {
		return heuristic;
	}

}
