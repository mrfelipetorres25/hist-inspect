package br.pucrio.dslmetrics.core.domain;

import java.util.List;
import java.util.Set;

import br.pucrio.dslmetrics.core.domain.metrics.AccumulatedLOC;
import br.pucrio.dslmetrics.core.domain.metrics.NonCalculatedMetric;

public class ProjectReader {

	private ProjectBuilder builder;

	private NonCalculatedMetric [] metrics;

	public ProjectReader(ProjectBuilder builder) {
		this.builder = builder;

		metrics = createMetrics();

	}

	private NonCalculatedMetric [] createMetrics() {
		return new NonCalculatedMetric [] { new AccumulatedLOC() };
	}

	private void applyMetrics(Entity entity) {
		for (NonCalculatedMetric metric : metrics)
			metric.calculateMetricValue(entity);
	}

	public Project readProject() throws ProjectBuilderException {

		Project project = builder.buildProject();

		buildClasses(project.getClassesOfAllVersions());
		buildPackages(project.getPackagesOfAllVersions());

		applyMetrics(project);
		
		project.setAlltEntities(builder.getIdentityMap());

		return project;
	}

	private void buildClasses(Set<Class> allClasses)
			throws ProjectBuilderException {

		for (Class c : allClasses) {
			builder.buildClass(c);

			buildClasses(c.getClassesOfAllVersions());
			buildMethods(c.getMethodsOfAllVersions());

			applyMetrics(c);
		}
	}

	private void buildMethods(Set<Method> allMethods)
			throws ProjectBuilderException {

		for (Method method : allMethods) {

			builder.buildMethod(method);
			applyMetrics(method);
		}
	}

	private void buildPackages(Set<Package> allPackages)
			throws ProjectBuilderException {

		for (Package p : allPackages) {

			builder.buildPackage(p);

			buildClasses(p.getClassesOfAllVersions());
			buildPackages(p.getPackagesOfAllVersions());

			applyMetrics(p);
		}
	}

}
