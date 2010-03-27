package br.pucrio.dslmetrics.core.mtbl;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Metric;

public class ConventionalMtblMetric implements Metric {

	private String name;	
	
	public ConventionalMtblMetric(String name) {
		this.name = name;
	}

	@Override
	public void calculateMetricValue(Entity entity) {	
		//não atribui nada, pois as métricas estão sendo recuperadas do arquivo
		//em uma versão futura, esssa métricas podem ser calculadas
	}

	@Override
	public Class<?>[] getAppliedEntities() {
		//não atribui nada, pois as métricas estão sendo recuperadas do arquivo
		//em uma versão futura, esssa métricas podem ser calculadas
		return null;
	}

	@Override
	public String getMetricName() {
		return name;
	}

}
