package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

/**
 * diferença entre a medida da versão atual e da versão anterior 
 * @author leandra
 *
 */
public class AbsoluteDifferenceOfRecentChange extends
		ChangeHistorySensitiveMetric {

	public static final String GENERAL_NAME = "Absolute Difference of Recent Change";
	public static final String GENERAL_NICKNAME = "adrc";

	public AbsoluteDifferenceOfRecentChange(CalculatedMetric conventionalMetric) {
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

		if (previousMetricValue == null || currentMetricValue == null)
			return null;

		return Math.abs(previousMetricValue - currentMetricValue);
	}

}
