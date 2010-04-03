package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;

public class TimeLife implements HistorySensitiveMetric {

	public static final String NICK_NAME = "TL";
	public static final String NAME = "Time Life";
	
	public void calculateMetricValue(Entity entity) {

		SortedSet<Version> versions = entity.getVersions();
		
		int countTimeLife =  0;
		
		for (Version version : versions) {
			countTimeLife++;
			Double metricValue = new Double((double)countTimeLife);
			entity.addMetricValue(version, this , metricValue);
		}
		
	}

	@Override
	public String getNickname() {
		return NICK_NAME;
	}

	@Override
	public String getName() {
		return NAME;
	}

	
}
