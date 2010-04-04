package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class RelativeDifferenceOfOverallChange extends
		ChangeHistorySensitiveMetric {

	private static final String GENERAL_NAME = "Relative Difference Of Overall Change";

	private final String GENERAL_NICKNAME = "rdoc";
	
	private int timelife = 0;
	private double accumulatedValue = 0.0;

	public RelativeDifferenceOfOverallChange(
			CalculatedMetric conventionalMetricParameter) {
		super(conventionalMetricParameter);
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
		timelife = 0;
		accumulatedValue = 0.0;
	}
	
	@Override
	protected Double calculateMetricValueForOneVersion(Double firstMetricValue,
			Double previousMetricValue, Double currentMetricValue) {

		timelife++;
		
		if (currentMetricValue == null || previousMetricValue == null)
			return null;
		
		Double diff = currentMetricValue - previousMetricValue;
		accumulatedValue += Math.abs(diff);
		return accumulatedValue / (double)timelife;
	}
}