package br.pucrio.dslmetrics.ui.console;

import java.util.Set;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.metrics.Metric;
import br.pucrio.dslmetrics.core.domain.walker.ProjectVisitorAdapter;

public class DomainConsolePrinter extends ProjectVisitorAdapter {

	@Override
	public void acceptEntity(Entity entity, int level) {
		for (int i = 0; i < level; i++)
			System.out.print("  ");

		System.out.println(entity.getName());
		Set<Metric> metrics = entity.getMetrics();
		for (Metric metric : metrics) {
			System.out.println(metric.getName()+" ("+metric.getNickname()+")");
		}
		
	}
}
