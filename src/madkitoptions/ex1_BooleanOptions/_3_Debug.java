package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;
import madkitoptions.util.TutorialAgent;

/**
 * This class exemplifies the use of debug's option.
 * If this boolean option is set to true, all the agents' LogLevel are set to "ALL".
 * The default value is false.
 * 
 * #jws# madkitoptions.ex1_BooleanOptions._3_Debug  #jws#
 * #args# #args#
 */

public class _3_Debug {
	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.debug.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. 
		  * You should have less log displayed
		  */
		 // new Madkit(Madkit.BooleanOption.debug.toString(), Boolean.FALSE.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
	 }
}
