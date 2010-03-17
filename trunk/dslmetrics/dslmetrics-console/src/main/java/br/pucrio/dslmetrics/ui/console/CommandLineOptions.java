package br.pucrio.dslmetrics.ui.console;

import uk.co.flamingpenguin.jewel.cli.Option;

public interface CommandLineOptions {

	@Option(longName = "anomaly-file", shortName = "a", description = "(Optional) Path to an alternate file with possible anomalies of the system. The default file is \"conf/Anomalies.xml\".", defaultValue = "conf/Anomalies.xml")
	String getAnomalyFile();

	@Option(longName = "rules-file", shortName = "u", description = "(Optional) Path to an alternate file with anomalies detection rules. The default file is \"conf/Rules.xml\".", defaultValue = "conf/Rules.xml")
	String getRulesFile();

	@Option(longName = "output", shortName = "o", description = "(Mandatory) Path of the generated report.")
	String getOutputPath();

	@Option(longName = "versions-file", shortName = "v", description = "(Mandatory) Path to the file containing the versions of the system.")
	String getVersionsFile();

	@Option(longName = "reference-list", shortName = "r", description = "(Optional) Path to the file containing the reference list. ")
	String getReferenceListFile();

	boolean isReferenceListFile();

	@Option(helpRequest = true, description = "Displays this help.")
	boolean getHelp();
}
