package br.pucrio.dslmetrics.core.domain.metrics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class AbsoluteNumberOfChange extends ChangeHistorySensitiveMetric {

	public static final String GENERAL_NICKNAME = "anc";
	public final String GENERAL_NAME = "Absolute Number of Change";
	private int numberOfChange;

	public AbsoluteNumberOfChange(CalculatedMetric conventionalMetric) {
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
	protected void onNewEntity(Entity entity) {
		numberOfChange = 0;
	}
	
	@Override
	protected Double calculateMetricValueForOneVersion(
			Double firstVersionMetricValue, Double previousMetricValue,
			Double currentMetricValue) {

		if (previousMetricValue == null || currentMetricValue == null)
			return null;

		if (!previousMetricValue.equals(currentMetricValue))
			numberOfChange++;

		return (double) numberOfChange;
	}

}
