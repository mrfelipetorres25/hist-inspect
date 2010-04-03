package br.pucrio.dslmetrics.core.domain.metrics;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import br.pucrio.dslmetrics.core.mtbl.calculatedMetric;

public class InMemoryMetricRepository extends MetricsRepository {

	private Map<String, Metric> identityMap = new HashMap<String, Metric>();
	private Collection<HistorySensitiveMetric> historySensitiveMetrics = new LinkedList<HistorySensitiveMetric>();
	private Collection<calculatedMetric> calculatedMetrics = new LinkedList<calculatedMetric>();

	protected InMemoryMetricRepository() {
		createCalculatedMetrics();
		createNonCalculatedMetrics();
	}

	@Override
	public void add(Metric metric) {

		if (!exists(metric)) {

			identityMap.put(metric.getNickname(), metric);

			if (metric instanceof HistorySensitiveMetric)
				historySensitiveMetrics.add((HistorySensitiveMetric) metric);
			else if (metric instanceof calculatedMetric)
				calculatedMetrics.add((calculatedMetric) metric);

		} else if (isDuplicate(metric))
			throw new AssertionError(MessageFormat.format(
					"Duplicate metric object \"{0}\"", metric.getNickname()));
	}

	private boolean exists(Metric metric) {
		Metric savedMetric = identityMap.get(metric.getNickname());
		return savedMetric != null;
	}

	private boolean isDuplicate(Metric metric) {
		Metric savedMetric = identityMap.get(metric.getNickname());
		return savedMetric != null && savedMetric != metric;
	}

	@Override
	public Metric getMetricByNickname(String nickname) {
		return identityMap.get(nickname);
	}

	@Override
	public Collection<Metric> listAllMetrics() {
		return Collections.unmodifiableCollection(identityMap.values());
	}

	@Override
	public Collection<calculatedMetric> listCalculatedMetrics() {
		return Collections.unmodifiableCollection(calculatedMetrics);
	}

	@Override
	public Collection<HistorySensitiveMetric> listHistorySensitiveMetrics() {
		return Collections.unmodifiableCollection(historySensitiveMetrics);
	}

	private void createCalculatedMetrics() {
		add(new calculatedMetric("LOC", "Lines of Code"));
		add(new calculatedMetric("CBO", "Couple Between Classes"));
		add(new calculatedMetric("NOO", "Number of Operations"));
	}

	private void createNonCalculatedMetrics() {
		for (calculatedMetric calculatedMetric : calculatedMetrics) {
			add(new AbsoluteDifferenceOfRecentChange(calculatedMetric));
			add(new AbsoluteDifferenceOfOverallChange(calculatedMetric));
		}
		add(new TimeLife());
	}
}
