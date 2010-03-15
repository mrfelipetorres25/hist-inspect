package br.pucrio.dslmetrics.core.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.pucrio.dslmetrics.core.domain.metrics.AccumulatedLOC;

public class ProjectReader {

	private ProjectBuilder builder;

	private Map<java.lang.Class<?>, List<Metric>> entitiesMetricMap = new HashMap<java.lang.Class<?>, List<Metric>>();

	public ProjectReader(ProjectBuilder builder) {
		this.builder = builder;

		Metric[] metrics = createMetrics();
		classifyMetrics(metrics);
	}

	private Metric[] createMetrics() {
		return new Metric[] { new AccumulatedLOC() };
	}

	private void classifyMetrics(Metric[] metrics) {
		for (Metric metric : metrics) {

			java.lang.Class<?>[] appliedEntities = metric.getAppliedEntities();

			for (java.lang.Class<?> c : appliedEntities) {

				List<Metric> classifiedMetrics = entitiesMetricMap.get(c);

				if (classifiedMetrics == null) {
					classifiedMetrics = new LinkedList<Metric>();
					entitiesMetricMap.put(c, classifiedMetrics);
				}

				classifiedMetrics.add(metric);
			}
		}
	}

	private void applyMetrics(Entity entity) {
		List<Metric> metrics = entitiesMetricMap.get(entity.getClass());

		for (Metric metric : metrics)
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
