package br.pucrio.dslmetrics.core.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Entity {

	private String name;

	private Map<Version, Map<String, Double>> versionMetricMap = new HashMap<Version, Map<String, Double>>();

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
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

	public Set<Entry<Version, Map<String, Double>>> metricEvolution() {
		return Collections.unmodifiableSet(versionMetricMap.entrySet());
	}

	public Map<String, Double> getMetricValues(Version version) {
		return versionMetricMap.get(version);
	}

	public Map<String, Double> setMetrics(Version version,
			Map<String, Double> metricsMap) {
		return versionMetricMap.put(version, metricsMap);
	}
	
	public SortedSet<String> getMetricNames() {
		SortedSet<String> metricNames = new TreeSet<String>();
		
		Set<Entry<Version, Map<String, Double>>> entrySet = versionMetricMap.entrySet();
		
		for (Entry<Version, Map<String, Double>> entry : entrySet)
			metricNames.addAll(entry.getValue().keySet());
		
		return metricNames;
	}
	
	public void addMetricValue(Version version, String metricName, Double value) {
		Map<String, Double> map = versionMetricMap.get(version);

		if (map != null)
			map.put(metricName, value);
	}

	public Double getMetricValue(Version version, String metric) {
		Map<String, Double> metricValueMap = versionMetricMap.get(version);
		if (metricValueMap != null)
			return metricValueMap.get(metric);
		else
			return null;
	}

	protected <T extends Entity> Set<T> getEntitiesOfAllVersions(
			Map<Version, List<T>> entities) {
		Set<T> allEntities = new HashSet<T>();

		for (List<T> list : entities.values())
			allEntities.addAll(list);

		return Collections.unmodifiableSet(allEntities);
	}
}
