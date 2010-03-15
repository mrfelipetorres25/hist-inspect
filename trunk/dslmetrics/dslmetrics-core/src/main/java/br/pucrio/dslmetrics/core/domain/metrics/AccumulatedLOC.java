package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Metric;
import br.pucrio.dslmetrics.core.domain.Metrics;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;

public class AccumulatedLOC implements Metric {

	private static final String NAME = "accLOC";

	@Override
	public void calculateMetricValue(Entity entity) {
		
		Double accLOC = 0.0;
		
		SortedSet<Version> versions = entity.getVersions();
		
		for (Version version : versions) {
			accLOC += entity.getMetricValue(version, Metrics.LOC);
			entity.addMetricValue(version, NAME , accLOC);
		}
	}

	@Override
	public java.lang.Class<?>[] getAppliedEntities() {
		return new java.lang.Class<?>[] { Project.class, Package.class,
				Class.class, Method.class };
	}
}
