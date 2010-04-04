package br.pucrio.dslmetrics.core.domain.metrics;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import br.pucrio.dslmetrics.core.mtbl.CalculatedMetric;

public class InMemoryMetricRepository extends MetricsRepository {

	private Map<String, Metric> identityMap = new HashMap<String, Metric>();
	private Collection<HistorySensitiveMetric> historySensitiveMetrics = new LinkedList<HistorySensitiveMetric>();
	private Collection<CalculatedMetric> calculatedMetrics = new LinkedList<CalculatedMetric>();

	protected InMemoryMetricRepository() {
		createCalculatedMetrics();
		createNonCalculatedMetrics();
	}

	@Override
	public void add(Metric metric) {

		if (!exists(metric)) {

			identityMap.put(metric.getNickname(), metric);

			if (metric instanceof HistorySensitiveMetric)
				historySensitiveMetrics.add((HistorySensitiveMetric) metric);
			else if (metric instanceof CalculatedMetric)
				calculatedMetrics.add((CalculatedMetric) metric);

		} else if (isDuplicate(metric))
			throw new AssertionError(MessageFormat.format(
					"Duplicate metric object \"{0}\"", metric.getNickname()));
	}

	private boolean exists(Metric metric) {
		Metric savedMetric = identityMap.get(metric.getNickname());
		return savedMetric != null;
	}

	private boolean isDuplicate(Metric metric) {
		Metric savedMetric = identityMap.get(metric.getNickname());
		return savedMetric != null && savedMetric != metric;
	}

	@Override
	public Metric getMetricByNickname(String nickname) {
		return identityMap.get(nickname);
	}

	@Override
	public Collection<Metric> listAllMetrics() {
		return Collections.unmodifiableCollection(identityMap.values());
	}

	@Override
	public Collection<CalculatedMetric> listCalculatedMetrics() {
		return Collections.unmodifiableCollection(calculatedMetrics);
	}

	@Override
	public Collection<HistorySensitiveMetric> listHistorySensitiveMetrics() {
		return Collections.unmodifiableCollection(historySensitiveMetrics);
	}

	private void createCalculatedMetrics() {
		add(new CalculatedMetric("CIW", "Class Interface Width"));
		add(new CalculatedMetric("LOC", "Lines Of Code"));
		add(new CalculatedMetric("NOA", "Number Of Attributes"));
		add(new CalculatedMetric("NOC", "Number Of Classes"));
		add(new CalculatedMetric("NOCON", "Number Of Constructors"));
		add(new CalculatedMetric("NOIS", "Number Of Import Statements"));
		add(new CalculatedMetric("NOM", "Number Of Members"));
		add(new CalculatedMetric("NOO", "Number Of Operations"));
		add(new CalculatedMetric("NOP", "Number Of Parameters"));
		add(new CalculatedMetric("NOPA", "Number Of Public Attributes"));
		add(new CalculatedMetric("NAM", "Number of Accessor Methods"));
		add(new CalculatedMetric("PIS", "Package Interface Size"));
		add(new CalculatedMetric("PS", "Package Size"));
		add(new CalculatedMetric("ALD", "Access of Local Data"));
		add(new CalculatedMetric("CL", "Class Locality"));
		add(new CalculatedMetric("LCOM1", "Lack of Cohesion of Methods 1"));
		add(new CalculatedMetric("LCOM2", "Lack of Cohesion Of Methods 2"));
		add(new CalculatedMetric("LCOM3", "Lack Of Cohesion Of Methods 3"));
		add(new CalculatedMetric("PC", "Package Cohesion"));
		add(new CalculatedMetric("TCC", "Tight Class Cohesion"));
		add(new CalculatedMetric("AC", "Attribute Complexity"));
		add(new CalculatedMetric("CC", "Cyclomatic Complexity"));
		add(new CalculatedMetric("EC", "Essential Complexity"));
		add(new CalculatedMetric("MNOB", "Maximum Number Of Branches"));
		add(new CalculatedMetric("MDC", "Module Design Complexity"));
		add(new CalculatedMetric("NOLV", "Number Of Local Variables"));
		add(new CalculatedMetric("NORM", "Number Of Remote Methods"));
		add(new CalculatedMetric("RFC", "Response For Class"));
		add(new CalculatedMetric("WOC", "Weight Of a Class"));
		add(new CalculatedMetric("WMPC1", "Weighted Methods Per Class 1"));
		add(new CalculatedMetric("WMPC2", "Weighted Methods Per Class 2"));
		add(new CalculatedMetric("A", "Abstractness"));
		add(new CalculatedMetric("AOFD", "Access Of Foreign Data"));
		add(new CalculatedMetric("AID", "Access of Import Data"));
		add(new CalculatedMetric("CA", "Afferent Coupling"));
		add(new CalculatedMetric("AUF", "Average Use of Interface"));
		add(new CalculatedMetric("ChC", "Changing Classes"));
		add(new CalculatedMetric("CM", "Changing Methods"));
		add(new CalculatedMetric("COC", "Clients Of Class"));
		add(new CalculatedMetric("CBO", "Coupling Between Objects"));
		add(new CalculatedMetric("CF", "Coupling Factor"));
		add(new CalculatedMetric("DAC", "Data Abstraction Coupling"));
		add(new CalculatedMetric("DD", "Dependency Dispersion"));
		add(new CalculatedMetric("CE", "Efferent Coupling"));
		add(new CalculatedMetric("FO", "FanOut"));
		add(new CalculatedMetric("I", "Instability"));
		add(new CalculatedMetric("MPC", "Message Passing Coupling"));
		add(new CalculatedMetric("MIC", "Method Invocation Coupling"));
		add(new CalculatedMetric("RMD", "Normalized Distance"));
		add(new CalculatedMetric("NOCP", "Number Of Client Packages"));
		add(new CalculatedMetric("NOED", "Number Of External Dependencies"));
		add(new CalculatedMetric("NCC", "Number of Client Classes"));
		add(new CalculatedMetric("NCPC", "Number of Concerns per Component"));
		add(new CalculatedMetric("NIC", "Number of import classes"));
		add(new CalculatedMetric("PUR", "Package Usage Ratio"));
		add(new CalculatedMetric("VOD", "Violations of Demeters Law"));
		add(new CalculatedMetric("WCM", "Weighted Chancging Methods"));
		add(new CalculatedMetric("AHF", "Attribute Hiding Factor"));
		add(new CalculatedMetric("MHF", "Method Hiding Factor"));
		add(new CalculatedMetric("HDiff", "Halstead Difficulty"));
		add(new CalculatedMetric("HEff", "Halstead Effort"));
		add(new CalculatedMetric("HPLen", "Halstead Program Length"));
		add(new CalculatedMetric("HPVoc", "Halstead Program Vocabulary"));
		add(new CalculatedMetric("HPVol", "Halstead Program Volume"));
		add(new CalculatedMetric("NOprnd", "Number of Operands"));
		add(new CalculatedMetric("NOprtr", "Number of Operators"));
		add(new CalculatedMetric("NUOprnd", "Number of Unique Operands"));
		add(new CalculatedMetric("NUOprtr", "Number of Unique Operators"));
		add(new CalculatedMetric("AIF", "Attribute Inheritance Factor"));
		add(new CalculatedMetric("DOIH", "Depth Of Inheritance Hierarchy"));
		add(new CalculatedMetric("MIF", "Method Inheritance Factor"));
		add(new CalculatedMetric("NOCC", "Number Of Child Classes"));
		add(new CalculatedMetric("AIUR", "Average Inheritance Usage Ratio"));
		add(new CalculatedMetric("IUR", "Inheritance Usage Ratio"));
		add(new CalculatedMetric("TRAp", "Total Reuse of Ancestor percentage"));
		add(new CalculatedMetric("TRAu", "Total Reuse of Ancestor unitary"));
		add(new CalculatedMetric("TRDp",
				"Total Reuse in Descendants percentage"));
		add(new CalculatedMetric("TRDu", "Total Reuse in Descendants unitary"));
		add(new CalculatedMetric("MNOL", "Maximum Number Of Levels"));
		add(new CalculatedMetric("MNOP", "Maximum Number Of Parameters"));
		add(new CalculatedMetric("MSOO", "Maximum Size Of Operation"));
		add(new CalculatedMetric("NOAM", "Number Of Added Methods"));
		add(new CalculatedMetric("NOOM", "Number Of Overridden Methods"));
		add(new CalculatedMetric("PF", "Polymorphism Factor"));
		add(new CalculatedMetric("CR", "Comment Ratio"));
		add(new CalculatedMetric("PPkgM", "Percentage of Package Members"));
		add(new CalculatedMetric("PPrivM", "Percentage of Private Members"));
		add(new CalculatedMetric("PProtM", "Percentage of Protected Members"));
		add(new CalculatedMetric("PPubM", "Percentage of Public Members"));
		add(new CalculatedMetric("TCR", "True Comment Ratio"));
		add(new CalculatedMetric("JUC", "JUnit test Coverage"));
	}

	private void createNonCalculatedMetrics() {
		
		add(new TimeLife());
		
		for (CalculatedMetric calculatedMetric : calculatedMetrics) {
            add(new AbsoluteDifferenceOfOverallChange(calculatedMetric));
            add(new AbsoluteDifferenceOfRecentChange(calculatedMetric));
            add(new AbsoluteNumberOfChange(calculatedMetric));
            add(new GeneralPercentageDecrease(calculatedMetric));
            add(new GeneralPercentageIncrease(calculatedMetric));
            add(new RecentPercentageDecrease(calculatedMetric));
            add(new RecentPercentageIncrease(calculatedMetric));
            add(new RelativeDifferenceOfOverallChange(calculatedMetric));
            add(new RelativeNumberOfChange(calculatedMetric));
		}
		
	}
}
