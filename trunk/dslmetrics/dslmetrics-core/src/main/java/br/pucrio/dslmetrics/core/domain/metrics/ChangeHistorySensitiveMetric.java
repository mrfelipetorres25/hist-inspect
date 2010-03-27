package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.List;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;

public abstract class ChangeHistorySensitiveMetric implements HistorySensitiveMetric {

	protected Metric conventionalMetric;
	
	@Override
	public void calculateMetricValue(Entity entity) {
		List<Metric> conventionalMetricList = entity.getConventionalMetrics();
		
		for (Metric conventionalMetric : conventionalMetricList) {
			calculateOneInstanceOfHistoryMetric (entity, conventionalMetric);
		}

	}

	@Override
	public Class<?>[] getAppliedEntities() {
		return conventionalMetric.getAppliedEntities();
	}

	@Override
	public abstract String getMetricName();
	
	public abstract void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric);
	
	public abstract String getGeneralName();

}
