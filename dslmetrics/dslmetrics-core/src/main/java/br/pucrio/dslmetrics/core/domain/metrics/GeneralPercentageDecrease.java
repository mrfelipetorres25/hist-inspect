package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;

public class GeneralPercentageDecrease extends ChangeHistorySensitiveMetric {

	private final String GENERAL_NAME = "gpd";
	
	public GeneralPercentageDecrease() {
	}
	
	private GeneralPercentageDecrease(Metric conventionalMetricParameter) {
		super(conventionalMetricParameter);
	}
	
	@Override
	public void calculateOneInstanceOfHistoryMetric(Entity entity,
			Metric conventionalMetric) {
		SortedSet<Version> versions = entity.getVersions();
		
		Version firstVersion = null;
		if(!versions.isEmpty() && versions!=null){
			firstVersion = versions.first();
		}

		Double firstMetricValue = entity.getMetricValue(firstVersion, conventionalMetric);
		
		for (Version version : versions) {

			Double actualMetricValue = entity.getMetricValue(version, conventionalMetric);
			
			Double diff = actualMetricValue - firstMetricValue;
			
			if(diff < 0){
				
				diff = diff * (-1);
				
				Metric histMetric = new GeneralPercentageDecrease(conventionalMetric);
				
				Double returnValue = (diff / firstMetricValue) * 100;
				
				entity.addMetricValue(version, histMetric, returnValue);
				
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
