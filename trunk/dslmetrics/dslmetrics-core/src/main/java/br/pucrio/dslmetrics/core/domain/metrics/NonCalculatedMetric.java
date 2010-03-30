package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;

/*
 * Interface para todas as métricas sensíveis à história
 */
public interface NonCalculatedMetric extends Metric {

	public void calculateMetricValue(Entity entity);

}
