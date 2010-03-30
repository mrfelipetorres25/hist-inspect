package br.pucrio.dslmetrics.core.mtbl;

import br.pucrio.dslmetrics.core.domain.Metric;

public class CalculatedMetric implements Metric {

	private String name;

	public CalculatedMetric(String name) {
		this.name = name;
	}

	@Override
	public String getMetricName() {
		return name;
	}

}
