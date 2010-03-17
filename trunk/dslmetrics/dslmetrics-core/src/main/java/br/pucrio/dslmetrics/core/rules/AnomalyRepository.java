package br.pucrio.dslmetrics.core.rules;

import java.util.List;


public interface AnomalyRepository {

	List<Anomaly> getAnomalies();

	Anomaly getAnomalyById(String id);

}
