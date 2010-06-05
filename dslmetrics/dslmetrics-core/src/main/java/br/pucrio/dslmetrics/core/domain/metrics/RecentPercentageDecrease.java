package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

/**
 * decaimento percentual de uma dada medida, comparada ao seu valor na versão anterior
 * @author leandra
 *
 */
public class RecentPercentageDecrease extends ChangeHistorySensitiveMetric {

	private static final String GENERAL_NAME = "Recent Percentage Decrease";
	private final String GENERAL_NICKNAME = "rpd";

	public RecentPercentageDecrease(CalculatedMetric conventionalMetric) {
		super(conventionalMetric);
	}

	@Override
	protected Double calculateMetricValueForOneVersion(Double firstMetricValue,
			Double previousMetricValue, Double currentMetricValue) {

		if (currentMetricValue == null || previousMetricValue == null)
			return null;

		Double diff = currentMetricValue - previousMetricValue;

		if (diff < 0)
			return (Math.abs(diff) / previousMetricValue) * 100.0;
		else
			return 0.0;

	}

	@Override
	public String getGeneralNickname() {
		return GENERAL_NICKNAME;
	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

}
