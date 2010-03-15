package br.pucrio.dslmetrics.core.heuristics;

import java.util.List;


public interface AnomalyRepository {

	List<Anomaly> getAnomalies();

	Anomaly getAnomalyById(String id);

}
