package de.tudresden.inf.lat.born.owlapi.multiprocessor;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import de.tudresden.inf.lat.born.core.term.SubApp;
import de.tudresden.inf.lat.born.owlapi.processor.ProcessorSubApp;

/**
 * An object of this class processes an set of OWL ontology files, produces a
 * Problog file, and executes Problog to obtain the result.
 * 
 * @see MultiProcessorCore
 * 
 * @author Julian Mendez
 *
 */
public class MultiProcessorSubApp implements SubApp {

	static final String LOGGING_OPTION = "--log";
	public static final String COMMAND = "experiment";
	public static final URI DEFAULT_PROBLOG_DOWNLOAD_URI = ProcessorSubApp.DEFAULT_PROBLOG_DOWNLOAD_URI;
	public static final String DEFAULT_PROBLOG_DIRECTORY = ProcessorSubApp.DEFAULT_PROBLOG_DIRECTORY;
	static final String HELP = ""
			+ "\nParameters: [--log] <directory of ontologies> <directory of Bayesian networks> <number of queries> <seed> <directory of results> [<ProbLog directory>]"
			+ "\n"
			+ "\n  <directory of ontologies>         : directory of probabilistic ontology files, only '.owl' files are read"
			+ "\n  <directory of Bayesian networks>  : directory of Bayesian network files, the file names must coincide with the ontology files, and only '.pl' files are read"
			+ "\n  <number of queries>               : number of queries to generate"
			+ "\n  <seed>                            : seed used by the pseudorandom number generator"
			+ "\n  <directory of results>            : directory to write the output files, each output file has the ontology name and a '.csv' extension"
			+ "\n  <ProbLog directory>               : (optional) directory where ProbLog is installed" + "\n" + "\n Option:"
			+ "\n   --log                            : shows log" + "\n" + "\nExamples:" + "\n"
			+ "\n Execution without ProbLog installed:"
			+ "\n  java -jar born.jar " + COMMAND + " ontologies/ networks/ 10 127 results/" + "\n"
			+ "\n Execution with ProbLog installed:"
			+ "\n  java -jar born.jar " + COMMAND + " ontologies/ networks/ 10 127 results/ /opt/problog2.1" + "\n"
			+ "\n Execution with ProbLog installed showing log:"
			+ "\n  java -jar born.jar " + COMMAND + " --log ontologies/ networks/ 10 127 results/ /opt/problog2.1" + "\n"
			+ "\nNote: this program requires the following installed:" + "\n - Java 7 or Java 8" + "\n - ProbLog 2.1"
			+ "\n - Python 2.7+ or 3.2+" + "\n" + "\nIf ProbLog is not installed, this program downloads ProbLog from:"
			+ "\n   " + DEFAULT_PROBLOG_DOWNLOAD_URI
			+ "\nPlease note that this option requires an Internet connection and the execution time can be longer."
			+ "\n" //
			+ "\n" //
			+ "\n";

	/**
	 * Constructs a new processor.
	 */
	public MultiProcessorSubApp() {
	}

	@Override
	public boolean isValid(String[] args) {
		return (((args.length == 5) && !args[0].equals(LOGGING_OPTION)) || (args.length == 6)
				|| ((args.length == 7) && args[0].equals(LOGGING_OPTION)));
	}

	@Override
	public String getHelp() {
		return HELP;
	}

	@Override
	public String run(String[] args) {
		long start = System.nanoTime();
		if (isValid(args)) {
			MultiProcessorConfiguration conf = new MultiProcessorConfiguration();

			StringBuffer sbuf = new StringBuffer();
			String[] newArgs = null;
			if (args[0].equals(LOGGING_OPTION)) {
				newArgs = new String[args.length - 1];
				System.arraycopy(args, 1, newArgs, 0, args.length - 1);
				conf.setShowingLog(true);
			} else {
				newArgs = new String[args.length];
				System.arraycopy(args, 0, newArgs, 0, args.length);
				conf.setShowingLog(false);
			}

			conf.setOntologyList(MultiProcessorCore.getOntologyAndNetworkList(newArgs[0], newArgs[1]));
			conf.setNumberOfQueries(Integer.parseInt(newArgs[2]));
			conf.setSeed(Integer.parseInt(newArgs[3]));
			conf.setOutputDirectory(newArgs[4]);
			conf.setProblogDirectory(null);

			if (newArgs.length == 6) {
				conf.setProblogDirectory(newArgs[5]);
				conf.setProblogNeeded(false);
			} else {
				conf.setProblogDirectory(DEFAULT_PROBLOG_DIRECTORY);
				conf.setProblogNeeded(true);
			}

			MultiProcessorCore core = new MultiProcessorCore();
			List<String> result = core.run(conf, start);
			try {
				core.storeResults(conf, result);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			sbuf.append(result);

			return sbuf.toString();
		} else {
			return getHelp();
		}
	}

}