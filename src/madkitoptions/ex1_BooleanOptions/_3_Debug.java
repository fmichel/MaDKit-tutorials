package madkitoptions.ex1_BooleanOptions;

import madkitoptions.TutorialAgent;
import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of debug's option.
 * If this boolean option is set to true, all the agents' LogLevel is set to "ALL".
 * The default value is false.
 * 
 * #jws madkitoptions.ex1_BooleanOptions._3_Debug  jws#
 *
 */

public class _3_Debug {
	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.debug.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
		 
		 /* Check the difference by commenting the previous line and decommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.debug.toString(), "false", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
	 }
}
