package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;

public class AbsoluteDifferenceOfOverallChange extends
		ChangeHistorySensitiveMetric {
	
	private final String GENERAL_NAME = "adoc";

	public AbsoluteDifferenceOfOverallChange() {
	}
	
	public AbsoluteDifferenceOfOverallChange(Metric conventionalMetricParameter) {
		conventionalMetric = conventionalMetricParameter;
	}

	@Override
	public void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric) {
		
		SortedSet<Version> versions = entity.getVersions();
		
		Version previousVersion = null;
		if(!versions.isEmpty() && versions!=null){
			previousVersion = versions.first();
		}

		Double acumulatedDiff = 0.0;
		for (Version version : versions) {
			
			Double previousMetricValue = entity.getMetricValue(previousVersion, conventionalMetric);
			Double actualMetricValue = entity.getMetricValue(version, conventionalMetric);
			
			Double diff = actualMetricValue - previousMetricValue;
			if(diff < 0)
				diff = diff * (-1);
			
			acumulatedDiff = acumulatedDiff + diff;
			
			Metric histMetric = new AbsoluteDifferenceOfOverallChange(conventionalMetric);
			
			entity.addMetricValue(version, histMetric, acumulatedDiff);
			
			previousVersion = version;
		}

	}

	@Override
	public String getMetricName() {
		return GENERAL_NAME + conventionalMetric.getMetricName();
	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

}
