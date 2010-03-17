package br.pucrio.dslmetrics.core.rules;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Version;

public class Detection {

	private Map<Version, Set<Entity>> versionEntityMap = new HashMap<Version, Set<Entity>>();

	private Rule rule;

	public Detection(Rule rule) {
		this.rule = rule;
	}

	public Rule getRule() {
		return rule;
	}

	void addEntity(Version version, Entity entity) {
		
		Set<Entity> entities = versionEntityMap.get(version);
		
		if(entities == null) {
			entities = new LinkedHashSet<Entity>();
			versionEntityMap.put(version, entities);
		}
		
		entities.add(entity);
			
	}
	
	public Set<Entity> getEntities(Version version) {
		Set<Entity> entities = versionEntityMap.get(version);
		if(entities == null)
			return Collections.emptySet(); 
		else
			return Collections.unmodifiableSet(entities);
	}

	public Set<Version> getVersions() {
		return new TreeSet<Version>(versionEntityMap.keySet()); 
	}
	
	
	
}
