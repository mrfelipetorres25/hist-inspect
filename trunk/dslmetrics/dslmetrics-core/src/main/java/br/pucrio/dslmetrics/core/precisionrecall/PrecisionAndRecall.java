package br.pucrio.dslmetrics.core.precisionrecall;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.rules.Detection;
import br.pucrio.dslmetrics.core.rules.Rule;

public class PrecisionAndRecall {

	private Detection detection;

	private ReferenceList referenceList;

	private Map<Version, Double> precisionValue = new LinkedHashMap<Version, Double>();
	private Map<Version, Double> recallValue = new LinkedHashMap<Version, Double>();

	private Map<Version, Set<Entity>> truePositives = new LinkedHashMap<Version, Set<Entity>>();
	private Map<Version, Set<Entity>> falsePositive = new LinkedHashMap<Version, Set<Entity>>();
	private Map<Version, Set<Entity>> falseNegatives = new LinkedHashMap<Version, Set<Entity>>();

	private final Project project;

	public PrecisionAndRecall(Project project, Detection detection,
			ReferenceList referenceList) {
		this.project = project;
		this.detection = detection;
		this.referenceList = referenceList;
		calculate();
	}

	private void calculate() {
		SortedSet<Version> versions = project.getVersions();
		for (Version version : versions) {
			calculateTruePositives(version, detection.getEntities(version),
					referenceList.getEntitiesForVersion(version));
			calculateFalseNegatives(version, detection.getEntities(version),
					referenceList.getEntitiesForVersion(version));
			calculateFalsePositive(version, detection.getEntities(version),
					referenceList.getEntitiesForVersion(version));
			calculatePrecision(version);
			calculateRecall(version);
		}
	}

	private void calculateRecall(Version version) {
		int truePositiveValue = getTruePositives(version).size();
		int falseNegativeValue = getFalseNegatives(version).size();

		int denominator = truePositiveValue + falseNegativeValue;

		if (denominator != 0)
			recallValue.put(version, (double)truePositiveValue / (double) denominator);
	}

	private void calculatePrecision(Version version) {
		int truePositiveValue = getTruePositives(version).size();
		int falsePositiveValue = getFalsePositives(version).size();

		int denominator = truePositiveValue + falsePositiveValue;

		if (denominator != 0) {
			precisionValue.put(version,(double) truePositiveValue
					/ (double) denominator);
		}
	}

	private void calculateTruePositives(Version version,
			Set<Entity> detectedEntities, Set<Entity> referenceEntities) {

		Set<Entity> truePositivesSet = new LinkedHashSet<Entity>();

		for (Entity entity : detectedEntities) {
			if (referenceEntities.contains(entity))
				truePositivesSet.add(entity);
		}

		truePositives.put(version, truePositivesSet);
	}

	private void calculateFalsePositive(Version version,
			Set<Entity> detectedEntities, Set<Entity> referenceEntities) {

		Set<Entity> falsePositiveSet = new LinkedHashSet<Entity>();

		for (Entity entity : detectedEntities) {
			if (!referenceEntities.contains(entity))
				falsePositiveSet.add(entity);
		}

		falsePositive.put(version, falsePositiveSet);
	}

	private void calculateFalseNegatives(Version version,
			Set<Entity> detectedEntities, Set<Entity> referenceEntities) {

		Set<Entity> falseNegativesSet = new LinkedHashSet<Entity>();

		for (Entity entity : referenceEntities) {
			if (!detectedEntities.contains(entity))
				falseNegativesSet.add(entity);
		}

		falseNegatives.put(version, falseNegativesSet);
	}

	public Set<Entity> getTruePositives(Version version) {
		return Collections.unmodifiableSet(truePositives.get(version));
	}

	public Set<Entity> getFalsePositives(Version version) {
		return Collections.unmodifiableSet(falsePositive.get(version));
	}

	public Set<Entity> getFalseNegatives(Version version) {
		return Collections.unmodifiableSet(falseNegatives.get(version));
	}

	public Detection getDetection() {
		return detection;
	}

	public ReferenceList getReferenceList() {
		return referenceList;
	}
	
	public Double getPrecision(Version version) {
		return precisionValue.get(version);
	}
	
	public Double getRecall(Version version) {
		return recallValue.get(version);
	}

	public Rule getRule() {
		return detection.getRule();
	}
	
	public SortedSet<Version> getVersions() {
		return referenceList.getVersions();
	}

}
