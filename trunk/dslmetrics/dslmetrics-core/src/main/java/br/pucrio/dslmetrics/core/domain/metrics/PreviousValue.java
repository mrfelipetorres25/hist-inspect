package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class PreviousValue extends
		ChangeHistorySensitiveMetric {

	public static final String GENERAL_NAME = "Previous value";
	public static final String GENERAL_NICKNAME = "p";

	public PreviousValue(CalculatedMetric conventionalMetric) {
		super(conventionalMetric);
	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

	@Override
	public String getGeneralNickname() {
		return GENERAL_NICKNAME;
	}

	@Override
	protected Double calculateMetricValueForOneVersion(
			Double firstVersionMetricValue, Double previousMetricValue,
			Double currentMetricValue) {

		if (currentMetricValue == null || previousMetricValue == null)
			return null;

		Double diff = currentMetricValue - previousMetricValue;

		if (diff < 0.0 || diff > 0.0)
			return previousMetricValue;
		else
			return 0.0;
	}

}
