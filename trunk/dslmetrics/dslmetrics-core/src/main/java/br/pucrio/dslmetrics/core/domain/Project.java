package br.pucrio.dslmetrics.core.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


public class Project extends Package {
	
	private Map<String,Entity> allProjectEntitiesMap;
	
	public Project(String name) {
		super(name);
	}
	
	void setAlltEntities(Map<String,Entity> allProjectEntities) {
		this.allProjectEntitiesMap = allProjectEntities;
	}
	
	public Entity getEntity(String id) {
		return allProjectEntitiesMap.get(id);
	}
	
	public Collection<Entity> getAllEntities() {
		return Collections.unmodifiableCollection(allProjectEntitiesMap.values());
	}
}
