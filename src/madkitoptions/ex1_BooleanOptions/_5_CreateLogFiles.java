package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;
import madkitoptions.util.TutorialAgent;

/**
 * This class exemplifies the use of createLogFiles' option.
 * If this boolean option is set to true, then file(s) storing
 * the logs of every MaDKit's agent with a log level greater
 * than the "OFF" level will be created. These file(s) are generated
 * in a "logs" directory which is created in the working directory (the project's root in eclipse by default).
 * The default value is false.
 * 
 * #jws# madkitoptions.ex1_BooleanOptions._5_CreateLogFiles #jws#
 * #args# #args#
 */

public class _5_CreateLogFiles {

	 public static void main(String[] args) {

		 /**
		  * Do not forget to check in the "logs" directory (root of
		  * the imported project) to see the generated file.
		  */
		 new Madkit(Madkit.BooleanOption.createLogFiles.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName());
	 }
}
