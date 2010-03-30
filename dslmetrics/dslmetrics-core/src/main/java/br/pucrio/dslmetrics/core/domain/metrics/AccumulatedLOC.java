package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.MetricConstants;
import br.pucrio.dslmetrics.core.domain.Version;

public class AccumulatedLOC implements NonCalculatedMetric {

	private final String NAME = "accLOC";

	@Override
	public void calculateMetricValue(Entity entity) {
		
		Double accLOC = 0.0;
		
		SortedSet<Version> versions = entity.getVersions();
		
		for (Version version : versions) {
			accLOC += entity.getMetricValueByName(version, MetricConstants.LOC);
			entity.addMetricValue(version, this , accLOC);
		}
	}

	@Override
	public String getMetricName() {
		return NAME;
	}
}
