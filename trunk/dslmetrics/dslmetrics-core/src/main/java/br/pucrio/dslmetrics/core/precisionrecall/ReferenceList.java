package br.pucrio.dslmetrics.core.precisionrecall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.rules.Anomaly;

public class ReferenceList {

	private Anomaly anomaly;

	private Map<Version, Set<Entity>> versionEntitiesMap = new HashMap<Version, Set<Entity>>();

	public ReferenceList(Anomaly anomaly) {
		this.anomaly = anomaly;
	}

	public Anomaly getAnomaly() {
		return anomaly;
	}

	public Set<Entity> getEntitiesForVersion(Version version) {

		Set<Entity> entities = versionEntitiesMap.get(version);

		if (entities == null)
			return Collections.emptySet();
		else
			return entities;
	}

	void setEntitiesWithAnomaly(Version v, Set<Entity> entities) {
		this.versionEntitiesMap.put(v, entities);
	}

	public Set<Entity> getEntities() {

		Collection<Set<Entity>> values = versionEntitiesMap.values();
		Set<Entity> entities = new HashSet<Entity>();

		for (Set<Entity> set : values)
			entities.addAll(set);

		return entities;
	}

	public Set<Entry<Version, Set<Entity>>> getEntityAndVersions() {
		return Collections.unmodifiableSet(versionEntitiesMap.entrySet());
	}

	public Set<Version> getVersions() {
		return Collections.unmodifiableSet(versionEntitiesMap.keySet());
	}
}
