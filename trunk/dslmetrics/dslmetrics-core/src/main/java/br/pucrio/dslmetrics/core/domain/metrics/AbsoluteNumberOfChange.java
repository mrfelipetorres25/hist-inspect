package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Version;


public class AbsoluteNumberOfChange extends ChangeHistorySensitiveMetric {
	
	private final String GENERAL_NAME = "anc";

	public AbsoluteNumberOfChange() {
	}
	
	private AbsoluteNumberOfChange(Metric conventionalMetricParameter) {
		super(conventionalMetricParameter);
	}

	public void calculateOneInstanceOfHistoryMetric(Entity entity, Metric conventionalMetric) {
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
			
			Metric histMetric = new AbsoluteNumberOfChange(conventionalMetric);
			Double metricValue = new Double(((double)numberOfchange));
			
			entity.addMetricValue(version, histMetric, metricValue);
			
			previousVersion = version;
		}
		
	}
	
	public String getMetricName() {
		return GENERAL_NAME + getConventionalMetric().getMetricName();
	}

	@Override
	public String getGeneralName() {
		return GENERAL_NAME;
	}

}
