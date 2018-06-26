package madkitoptions.ex1_BooleanOptions;

import exception.TutorialAgent;
import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of createLogFiles' option.
 * If this boolean option is set to true, then file(s) storing
 * the logs of every MaDKit's agent with a log level greater
 * then "ALL" will be created. These file(s) are generated
 * in the logs directory of the root's project.
 * The default value is false.
 * 
 * #jws madkitoptions.ex1_BooleanOptions._5_CreateLogFiles jws#
 *
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
