package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;

public class TimeLife implements HistorySensitiveMetric {

	public static final String NAME = "TL";
	
	public void calculateMetricValue(Entity entity) {

		SortedSet<Version> versions = entity.getVersions();
		
		int countTimeLife =  0;
		
		for (Version version : versions) {
			countTimeLife++;
			Double metricValue = new Double((double)countTimeLife);
			entity.addMetricValue(version, this , metricValue);
		}
		
	}

	public java.lang.Class<?>[] getAppliedEntities() {
		return new java.lang.Class<?>[] { Project.class, Package.class,
				Class.class, Method.class };
	}

	@Override
	public String getMetricName() {
		return NAME;
	}

	
}
