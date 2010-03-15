package br.pucrio.dslmetrics.core.heuristics;

public class Rule {

	private String id;

	private String name;

	private String expression;

	private final Anomaly anomaly;

	public Rule(String id, String name, String expression, Anomaly anomaly) {
		this.id = id;
		this.name = name;
		this.expression = expression;
		this.anomaly = anomaly;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getExpression() {
		return expression;
	}

	public Anomaly getAnomaly() {
		return anomaly;
	}

}
