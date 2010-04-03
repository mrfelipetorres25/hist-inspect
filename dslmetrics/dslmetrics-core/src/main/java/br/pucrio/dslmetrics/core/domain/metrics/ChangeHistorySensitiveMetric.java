package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.mtbl.calculatedMetric;

public abstract class ChangeHistorySensitiveMetric implements
		HistorySensitiveMetric {

	private final calculatedMetric conventionalMetric;

	public ChangeHistorySensitiveMetric(calculatedMetric calculatedMetric) {
		this.conventionalMetric = calculatedMetric;
	}

	@Override
	public String getNickname() {
		return getGeneralNickname() + conventionalMetric.getNickname();
	}

	@Override
	public String getName() {
		return getGeneralName() + " of " + conventionalMetric.getNickname();
	}

	@Override
	public void calculateMetricValue(Entity entity) {

		SortedSet<Version> versions = entity.getVersions();

		Version previousVersion = null;
		Double firstVersionMetricValue = null;

		if (!versions.isEmpty()) {
			previousVersion = versions.first();
			firstVersionMetricValue = entity.getMetricValue(versions.first(),
					conventionalMetric);
		}

		onNewEntity(entity);

		for (Version version : versions) {
			Double previousMetricValue = entity.getMetricValue(previousVersion,
					conventionalMetric);
			Double currentMetricValue = entity.getMetricValue(version,
					conventionalMetric);

			Double value = calculateMetricValueForOneVersion(
					firstVersionMetricValue, previousMetricValue,
					currentMetricValue);

			entity.addMetricValue(version, this, value);

			previousVersion = version;
		}

	}

	protected void onNewEntity(Entity entity) {
	};

	public abstract String getGeneralName();

	public abstract String getGeneralNickname();

	protected abstract Double calculateMetricValueForOneVersion(
			Double firstMetricValue, Double previousMetricValue,
			Double currentMetricValue);
}
