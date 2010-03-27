package br.pucrio.dslmetrics.core.domain;


public interface Metric {

	public void calculateMetricValue(Entity entity);
	
	public java.lang.Class<?>[] getAppliedEntities();
	
	public String getMetricName();


}
