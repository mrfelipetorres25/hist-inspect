package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.mtbl.calculatedMetric;

public class AbsoluteDifferenceOfOverallChange extends
		ChangeHistorySensitiveMetric {

	private final String GENERAL_NICKNAME = "adoc";
	private final String GENERAL_NAME = "Absolute difference of Overall Change";
	private double accumulatedValue;

	public AbsoluteDifferenceOfOverallChange(
			calculatedMetric calculatedMetric) {
		super(calculatedMetric);
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
	protected void onNewEntity(Entity entity) {
		accumulatedValue = 0.0;
	}

	@Override
	protected Double calculateMetricValueForOneVersion(Double firstVersionMetricValue, Double previousMetricValue,
			Double currentMetricValue) {
		
		if(currentMetricValue == null || previousMetricValue == null)
			return null;

		accumulatedValue += Math.abs(currentMetricValue - previousMetricValue);
		return accumulatedValue;

	}

}
