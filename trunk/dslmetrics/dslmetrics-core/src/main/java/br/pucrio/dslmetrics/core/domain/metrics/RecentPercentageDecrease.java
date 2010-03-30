package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;

public class RecentPercentageDecrease extends ChangeHistorySensitiveMetric {

private final String GENERAL_NAME = "rpd";
	
	public RecentPercentageDecrease() {
	}
	
	private RecentPercentageDecrease (Metric conventionalMetricParameter) {
		super(conventionalMetricParameter);
	}
	
	@Override
	public void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric) {
		SortedSet<Version> versions = entity.getVersions();
		
		Version previousVersion = null;
		if(!versions.isEmpty() && versions!=null){
			previousVersion = versions.first();
		}

		for (Version version : versions) {
			
			Double previousMetricValue = entity.getMetricValue(previousVersion, conventionalMetric);
			Double actualMetricValue = entity.getMetricValue(version, conventionalMetric);
			
			Double diff = actualMetricValue - previousMetricValue;
			
			if(diff < 0){
				
				diff = diff * (-1);
				
				Metric histMetric = new RecentPercentageDecrease(conventionalMetric);
				
				Double returnValue = (diff / previousMetricValue) * 100;
				
				entity.addMetricValue(version, histMetric, returnValue);
				
				previousVersion = version;
			}
			
		}

	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

	@Override
	public String getMetricName() {
		return GENERAL_NAME + getConventionalMetric().getMetricName();
	}

}
