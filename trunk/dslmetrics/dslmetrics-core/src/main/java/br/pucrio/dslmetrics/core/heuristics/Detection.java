package br.pucrio.dslmetrics.core.heuristics;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;

public class Detection {

	private Version version;

	private Entity entity;

	private Rule rule;

	public Detection(Version version, Entity entity, Rule rule) {
		this.version = version;
		this.entity = entity;
		this.rule = rule;
	}

	public Version getVersion() {
		return version;
	}

	public Entity getEntity() {
		return entity;
	}

	public Rule getHeuristic() {
		return rule;
	}

}
