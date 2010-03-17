package br.pucrio.dslmetrics.core.precisionrecall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.rules.Anomaly;

public class ReferenceListCatalog {

	private final Project project;

	private Map<Anomaly, ReferenceList> referenceLists = new HashMap<Anomaly, ReferenceList>();

	public ReferenceListCatalog(Project project,
			Collection<ReferenceList> referenceLists) {

		this.project = project;

		for (ReferenceList referenceList : referenceLists)
			this.referenceLists.put(referenceList.getAnomaly(), referenceList);
	}

	public Project getProject() {
		return project;
	}

	public ReferenceList getReferenceListForAnomaly(Anomaly anomaly) {
		return referenceLists.get(anomaly);
	}

	public Set<Entity> getEntitiesWithAnomaly(Anomaly anomaly, Version version) {

		ReferenceList referenceList = referenceLists.get(anomaly);

		if (referenceList != null)
			return referenceList.getEntitiesForVersion(version);
		else
			return null;
	}
	
	public Collection<ReferenceList> getReferenceLists() {
		return Collections.unmodifiableCollection(referenceLists.values());
	}

}
