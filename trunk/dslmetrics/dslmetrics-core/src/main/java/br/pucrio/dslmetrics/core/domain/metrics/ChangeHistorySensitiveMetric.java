package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.List;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;

public abstract class ChangeHistorySensitiveMetric implements HistorySensitiveMetric {

	private final Metric conventionalMetric;
	
	public ChangeHistorySensitiveMetric() {
		this.conventionalMetric = null;
	}
	
	public ChangeHistorySensitiveMetric(Metric conventionalMetric) {
		this.conventionalMetric = conventionalMetric;
	}
	
	@Override
	public void calculateMetricValue(Entity entity) {
		List<Metric> conventionalMetricList = entity.getConventionalMetrics();
		
		for (Metric conventionalMetric : conventionalMetricList) {
			calculateOneInstanceOfHistoryMetric (entity, conventionalMetric);
		}

	}

	@Override
	public abstract String getMetricName();
	
	public abstract void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric);

	public Metric getConventionalMetric() {
		return conventionalMetric;
	}
	


}
