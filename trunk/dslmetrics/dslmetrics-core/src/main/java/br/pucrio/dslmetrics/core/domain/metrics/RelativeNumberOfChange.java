package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;

public class RelativeNumberOfChange extends ChangeHistorySensitiveMetric {

	private final String GENERAL_NAME = "rnc";

	public RelativeNumberOfChange() {
	}
	
	private RelativeNumberOfChange(Metric conventionalMetric) {
		super(conventionalMetric);
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
			
			Double previousMetricValue = entity.getMetricValue(previousVersion, getConventionalMetric());
			Double actualMetricValue = entity.getMetricValue(version, getConventionalMetric());
			
			if (actualMetricValue.compareTo(previousMetricValue)!=0){
				numberOfchange++;
			}
			
			Metric histMetric = new RelativeNumberOfChange(getConventionalMetric());
			
			Double timeLifeValue = entity.getMetricValueByName(version, TimeLife.NAME);
			Double metricValue = (double) numberOfchange / timeLifeValue.doubleValue();
			
			entity.addMetricValue(version, histMetric, metricValue);
			
			previousVersion = version;
		}	

		
	}

	@Override
	public String getMetricName() {
		return GENERAL_NAME + getConventionalMetric().getMetricName();
	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

}
