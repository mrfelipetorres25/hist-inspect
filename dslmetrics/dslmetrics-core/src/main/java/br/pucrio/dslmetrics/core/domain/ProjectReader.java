package br.pucrio.dslmetrics.core.domain;

import java.util.Set;

import br.pucrio.dslmetrics.core.domain.metrics.NonCalculatedMetric;

public class ProjectReader {

	private ProjectBuilder builder;

	private NonCalculatedMetric [] metrics;

	public ProjectReader(ProjectBuilder builder) {
		this.builder = builder;

		metrics = createMetrics();

	}

	private NonCalculatedMetric [] createMetrics() {
		return new NonCalculatedMetric [] { };
	}

	private void applyMetrics(Entity entity) {
		for (NonCalculatedMetric metric : metrics)
			metric.calculateMetricValue(entity);
	}

	public Project readProject() throws ProjectBuilderException {

		Project project = builder.buildProject();

		buildClasses(project, project.getClassesOfAllVersions());
		buildPackages(project, project.getPackagesOfAllVersions());

		applyMetrics(project);
		
		project.setAlltEntities(builder.getIdentityMap());

		return project;
	}

	private void buildClasses(Entity parent, Set<Class> allClasses)
			throws ProjectBuilderException {

		for (Class c : allClasses) {
			builder.buildClass(c);
			
			c.setParent(parent);

			buildClasses(c,c.getClassesOfAllVersions());
			buildMethods(c,c.getMethodsOfAllVersions());

			applyMetrics(c);
		}
	}

	private void buildMethods(Entity parent, Set<Method> allMethods)
			throws ProjectBuilderException {

		for (Method method : allMethods) {

			method.setParent(parent);
			
			builder.buildMethod(method);
			applyMetrics(method);
		}
	}

	private void buildPackages(Entity parent, Set<Package> allPackages)
			throws ProjectBuilderException {

		for (Package p : allPackages) {

			builder.buildPackage(p);
			
			p.setParent(parent);

			buildClasses(p, p.getClassesOfAllVersions());
			buildPackages(p, p.getPackagesOfAllVersions());

			applyMetrics(p);
		}
	}

}
