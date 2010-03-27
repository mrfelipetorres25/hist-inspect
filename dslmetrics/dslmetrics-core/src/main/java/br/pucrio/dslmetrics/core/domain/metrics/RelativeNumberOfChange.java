package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;

public class RelativeNumberOfChange extends ChangeHistorySensitiveMetric {

	private final String GENERAL_NAME = "rnc";

	public RelativeNumberOfChange() {
	}
	
	public void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric2) {
		int numberOfchange = 0;
		
		SortedSet<Version> versions = entity.getVersions();
		
		Version previousVersion = null;
		if(!versions.isEmpty() && versions!=null){
			previousVersion = versions.first();
		}

		
		for (Version version : versions) {
			
			Double previousMetricValue = entity.getMetricValue(previousVersion, conventionalMetric);
			Double actualMetricValue = entity.getMetricValue(version, conventionalMetric);
			
			if (actualMetricValue.compareTo(previousMetricValue)!=0){
				numberOfchange++;
			}
			
			Metric histMetric = new RelativeNumberOfChange(conventionalMetric);
			
			Double timeLifeValue = entity.getMetricValueByName(version, TimeLife.NAME);
			Double metricValue = (double) numberOfchange / timeLifeValue.doubleValue();
			
			entity.addMetricValue(version, histMetric, metricValue);
			
			previousVersion = version;
		}	

		
	}

	public RelativeNumberOfChange(Metric conventionalMetric) {
		this.conventionalMetric = conventionalMetric;
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
