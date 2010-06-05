package br.pucrio.dslmetrics.core.domain.metrics;

import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;

/**
 * retorna a idade de cada entidade. Obs: se ela nasceu na versão 1 e permaneceu até a versão 2, sua idade é igual a 1. A idade corresponde a quantidade de versões que ela está presente no sistema menos 1
 * @author leandra
 *
 */
public class TimeLife implements HistorySensitiveMetric {

	public static final String NICK_NAME = "TL";
	public static final String NAME = "Time Life";
	
	public void calculateMetricValue(Entity entity) {

		SortedSet<Version> versions = entity.getVersions();
		
		int countTimeLife =  0;
		
		for (Version version : versions) {	
			Double metricValue = new Double((double)countTimeLife);
			entity.addMetricValue(version, this , metricValue);
			countTimeLife++;
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
