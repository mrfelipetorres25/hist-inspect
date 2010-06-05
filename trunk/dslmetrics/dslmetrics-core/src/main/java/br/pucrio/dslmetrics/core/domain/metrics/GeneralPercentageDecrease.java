package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

/**
 * decaimento percentual de uma dada medida, comparada ao seu valor na versão inicial da entidade
 * @author leandra
 *
 */
public class GeneralPercentageDecrease extends ChangeHistorySensitiveMetric {

	private static final String GENERAL_NAME = "General Percentage Decrease";
	private final String GENERAL_NICKNAME = "gpd";

	public GeneralPercentageDecrease(CalculatedMetric conventionalMetric) {
		super(conventionalMetric);
	}

	@Override
	protected Double calculateMetricValueForOneVersion(Double firstMetricValue,
			Double previousMetricValue, Double currentMetricValue) {

		if (currentMetricValue == null || firstMetricValue == null)
			return null;

		Double diff = currentMetricValue - firstMetricValue;

		if (diff < 0)
			return (Math.abs(diff) / firstMetricValue) * 100.0;
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
