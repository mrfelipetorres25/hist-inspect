package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class RelativeNumberOfDecrease extends ChangeHistorySensitiveMetric {

	private static final String GENERAL_NAME = "Relative Number of Decrease";
	private final String GENERAL_NICKNAME = "rnd";
	private int numberOfDecrease;
	private int timelife;

	public RelativeNumberOfDecrease(CalculatedMetric conventionalMetric) {
		super(conventionalMetric);
	}

	@Override
	protected void onNewEntity(Entity entity) {
		timelife = 0;
		numberOfDecrease = 0;
	}

	protected Double calculateMetricValueForOneVersion(Double firstMetricValue,
			Double previousMetricValue, Double currentMetricValue) {
		//alterei hoje: 14/04
		//timelife++;
		
		if(timelife == 0){
			timelife++;
			return null;
		}
			

		if (currentMetricValue == null || previousMetricValue == null)
			return null;

		if (currentMetricValue.compareTo(previousMetricValue)< 0)
			numberOfDecrease++;
		
		double returnValue = (double) numberOfDecrease / (double) timelife;
		
		//alterei hoje: 14/04
		timelife++;

		//return (double) numberOfChanges / (double) timelife;
		return returnValue;

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
