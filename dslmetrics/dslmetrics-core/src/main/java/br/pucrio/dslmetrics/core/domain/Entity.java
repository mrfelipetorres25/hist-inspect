package br.pucrio.dslmetrics.core.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import br.pucrio.dslmetrics.core.domain.metrics.Metric;

public class Entity {

	private String name;
	
	private String fullQualifiedName;
	
	private Entity parent = null;

	private Map<Version, Map<Metric, Double>> versionMetricMap = new HashMap<Version, Map<Metric, Double>>();
	

	public Entity(String name, String fullQualifiedName) {
		setName(name);
		setFullQualifiedName(fullQualifiedName);
	}
		
	
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setFullQualifiedName(String fullQualifiedName) {
		this.fullQualifiedName = fullQualifiedName;
	}

	public String getFullQualifiedName() {
		return fullQualifiedName;
	}
	
	protected void setParent(Entity parent) {
		this.parent = parent;
	}

	public Entity getParent() {
		return parent;
	}
	
	public SortedSet<Version> getVersions() {
		SortedSet<Version> ret = new TreeSet<Version>();
		ret.addAll(versionMetricMap.keySet());
		return ret;
	}
	
	public Version getVersionByNumber(int number) {
		Set<Version> versions = versionMetricMap.keySet();
		
		for (Version version : versions) {
			if(version.getNumber() == number)
				return version;
		}
		return null;
	}

	public Set<Entry<Version, Map<Metric, Double>>> metricEvolution() {
		return Collections.unmodifiableSet(versionMetricMap.entrySet());
	}

	public Map<Metric, Double> getMetricValues(Version version) {
		return versionMetricMap.get(version);
	}

	public Map<Metric, Double> setMetrics(Version version,
			Map<Metric, Double> metricsMap) {
		return versionMetricMap.put(version, metricsMap);
	}
	
	public Set<Metric> getMetrics() {
		
		Set<Metric> metrics = new HashSet<Metric>();
		
		Collection<Map<Metric, Double>> values = versionMetricMap.values();
		
		for (Map<Metric, Double> map : values)
			metrics.addAll(map.keySet());
	
		return metrics;
	}
	
	public void addMetricValue(Version version, Metric metric, Double value) {
		Map<Metric, Double> map = versionMetricMap.get(version);

		if (map != null)
			map.put(metric, value);
	}

	public Double getMetricValue(Version version, Metric metric) {
		Map<Metric, Double> metricValueMap = versionMetricMap.get(version);
		
		if (metricValueMap != null)
			return metricValueMap.get(metric);
		else
			return null;
	}
	
//	public Double getMetricValueByName(Version version, String metricName) {
//		Map<Metric, Double> metricValueMap = versionMetricMap.get(version);
//		
//		if (metricValueMap != null){
//			Set<Metric> metrics = metricValueMap.keySet();
//			for (Metric metric : metrics) 
//				if(metric.getName().equals(metricName))
//					return metricValueMap.get(metric);
//			
//		}
//			
//		return null;
//	}

	protected <T extends Entity> Set<T> getEntitiesOfAllVersions(
			Map<Version, List<T>> entities) {
		Set<T> allEntities = new HashSet<T>();

		for (List<T> list : entities.values())
			allEntities.addAll(list);

		return Collections.unmodifiableSet(allEntities);
	}
}
