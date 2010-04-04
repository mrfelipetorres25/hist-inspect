package br.pucrio.dslmetrics.core.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Package extends Entity {

	private Map<Version, List<Class>> classes = new HashMap<Version, List<Class>>();

	private Map<Version, List<Package>> packages = new HashMap<Version, List<Package>>();

	public Package(String name, String fullQualifiedName) {
		super(name, fullQualifiedName);
	}
	
	public List<Class> getClasses(Version version) {
		List<Class> list = classes.get(version);
		
		if(list == null)
			return Collections.emptyList();
		
		return Collections.unmodifiableList(list);
	}

	public Set<Class> getClassesOfAllVersions() {
		return getEntitiesOfAllVersions(classes);
	}

	public List<Class> addClasses(Version version, List<Class> classes) {
		return this.classes.put(version, classes);
	}

	public List<Package> getPackages(Version version) {
		List<Package> list = packages.get(version);
		
		if(list == null)
			return Collections.emptyList();
		
		return Collections.unmodifiableList(list);
	}

	public List<Package> addPackages(Version version, List<Package> packages) {
		return this.packages.put(version, packages);
	}

	public Set<Package> getPackagesOfAllVersions() {
		return getEntitiesOfAllVersions(packages);
	}

}
