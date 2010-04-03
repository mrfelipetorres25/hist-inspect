package br.pucrio.dslmetrics.core.mtbl;

import br.pucrio.dslmetrics.core.domain.metrics.Metric;


public class calculatedMetric implements Metric {

	private String nickname;
	private String name;

	public calculatedMetric(String nickname, String name) {
		this.nickname = nickname;
		this.name = name;
	}

	@Override
	public String getNickname() {
		return nickname;
	}

	@Override
	public String getName() {
		return name;
	}

}
