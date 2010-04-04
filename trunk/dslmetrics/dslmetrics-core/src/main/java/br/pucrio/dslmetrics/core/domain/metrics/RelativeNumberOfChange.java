package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class RelativeNumberOfChange extends ChangeHistorySensitiveMetric {

	private static final String GENERAL_NAME = "Relative Number of Change";
	private final String GENERAL_NICKNAME = "rnc";
	private int numberOfChanges;
	private int timelife;

	public RelativeNumberOfChange(CalculatedMetric conventionalMetric) {
		super(conventionalMetric);
	}

	@Override
	protected void onNewEntity(Entity entity) {
		timelife = 0;
		numberOfChanges = 0;
	}

	protected Double calculateMetricValueForOneVersion(Double firstMetricValue,
			Double previousMetricValue, Double currentMetricValue) {

		timelife++;

		if (currentMetricValue == null || previousMetricValue == null)
			return null;

		if (!currentMetricValue.equals(previousMetricValue))
			numberOfChanges++;

		return (double) numberOfChanges / (double) timelife;

	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

	@Override
	public String getGeneralNickname() {
		return GENERAL_NICKNAME;
	}

}
