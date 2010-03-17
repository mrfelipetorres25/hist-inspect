package br.pucrio.dslmetrics.core.rules;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.pucrio.dslmetrics.core.domain.Entity;

public class Anomaly {

	private String id;

	private String name;

	private List<Class<? extends Entity>> appliedEntities;

	private List<Rule> rules = new LinkedList<Rule>();

	public Anomaly(String id, String name, List<Class<? extends Entity>> appliedEntities) {
		this.id = id;
		this.name = name;
		this.appliedEntities = appliedEntities;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Class<? extends Entity>> getAppliedEntities() {
		return Collections.unmodifiableList(appliedEntities);
	}

	public List<Rule> getRules() {
		return Collections.unmodifiableList(rules);
	}

	boolean addRule(Rule rule) {
		return rules.add(rule);
	}
}
