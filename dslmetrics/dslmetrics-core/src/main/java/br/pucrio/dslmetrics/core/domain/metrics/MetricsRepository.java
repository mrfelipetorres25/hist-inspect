package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.Collection;

import br.pucrio.dslmetrics.core.mtbl.calculatedMetric;

public abstract class MetricsRepository {

	private static MetricsRepository instance = null;

	public static MetricsRepository getInstance() {

		if (instance == null)
			instance = new InMemoryMetricRepository();

		return instance;
	}

	public abstract Collection<Metric> listAllMetrics();
	
	public abstract Collection<calculatedMetric> listCalculatedMetrics();
	
	public abstract Collection<HistorySensitiveMetric> listHistorySensitiveMetrics();

	public abstract void add(Metric metric);

	public  abstract Metric getMetricByNickname(String nickname);

}
