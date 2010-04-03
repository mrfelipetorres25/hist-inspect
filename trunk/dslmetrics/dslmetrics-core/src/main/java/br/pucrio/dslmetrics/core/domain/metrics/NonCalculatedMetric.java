package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;


public interface NonCalculatedMetric extends Metric {

	public void calculateMetricValue(Entity entity);

}
