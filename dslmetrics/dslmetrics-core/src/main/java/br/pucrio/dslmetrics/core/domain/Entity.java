package br.pucrio.dslmetrics.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class Entity {

	private String name;
	
	private String fullQualifiedName;

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
	
	public SortedSet<String> getMetricNames() {
		SortedSet<String> metricNames = new TreeSet<String>();
		
		Set<Entry<Version, Map<Metric, Double>>> entrySet = versionMetricMap.entrySet();
		
		for (Entry<Version, Map<Metric, Double>> entry : entrySet){
			
			Set<Metric> keySet = entry.getValue().keySet();
			
			for (Metric metric : keySet) {
				metricNames.add(metric.getMetricName());;
			}
		}
			
			
		
		return metricNames;
	}
	
	public List<Metric> getMetrics() {
		
		List<Metric> metricList = new ArrayList<Metric>();
		
		Set<Entry<Version, Map<Metric, Double>>> entrySet = versionMetricMap.entrySet();
		
		for (Entry<Version, Map<Metric, Double>> entry : entrySet) {
			
			Map<Metric, Double> valueMap = entry.getValue();
			
			metricList.addAll(valueMap.keySet());

		}
		
		Collections.sort(metricList, new Comparator<Metric>(){

			@Override
			public int compare(Metric m1, Metric m2) {
				
		       return (m1.getMetricName().compareTo(m2.getMetricName()));
			}
			
		
		
		});
		
		return metricList;
	}
	
	
	public List<Metric> getConventionalMetrics() {		
		
		List<Metric> conventionaMetricList = new ArrayList<Metric>();
		
		List<Metric> metrics = getMetrics();
		
		for (Metric metric : metrics) {
			if(metric instanceof CalculatedMetric){
				conventionaMetricList.add(metric);
			}
			
		}
		return conventionaMetricList;
	}
	
	//public void addMetricValue(Version version, String metricName, Double value) {
	public void addMetricValue(Version version, Metric metric, Double value) {
		Map<Metric, Double> map = versionMetricMap.get(version);

		if (map != null)
			map.put(metric, value);
	}

	//public Double getMetricValue(Version version, String metric) {
	public Double getMetricValue(Version version, Metric metric) {
		//Map<String, Double> metricValueMap = versionMetricMap.get(version);
		Map<Metric, Double> metricValueMap = versionMetricMap.get(version);
		
		if (metricValueMap != null){
			Set<Entry<Metric, Double>> metricValueEntrySet = metricValueMap.entrySet();
			for (Entry<Metric, Double> metricValue : metricValueEntrySet) {
				if(metricValue.getKey().getMetricName().compareTo(metric.getMetricName()) == 0){
					return metricValue.getValue();
				}
				
			}
		}

		return null;
	}
	
	//
	public Double getMetricValueByName(Version version, String metricName) {
		Map<Metric, Double> metricValueMap = versionMetricMap.get(version);
		
		if (metricValueMap != null){
			Set<Entry<Metric, Double>> metricValueEntrySet = metricValueMap.entrySet();
			for (Entry<Metric, Double> metricValue : metricValueEntrySet) {
				if(metricValue.getKey().getMetricName().compareTo(metricName) == 0){
					return metricValue.getValue();
				}
				
			}
		}
			
		return null;
	}
	//
	
	

	protected <T extends Entity> Set<T> getEntitiesOfAllVersions(
			Map<Version, List<T>> entities) {
		Set<T> allEntities = new HashSet<T>();

		for (List<T> list : entities.values())
			allEntities.addAll(list);

		return Collections.unmodifiableSet(allEntities);
	}


}
