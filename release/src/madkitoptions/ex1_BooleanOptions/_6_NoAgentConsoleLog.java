package madkitoptions.ex1_BooleanOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;
import madkitoptions.util.TutorialAgent;

/**
 * This class exemplifies the use of noAgentConsoleLog's option.
 * If this boolean option is set to true, there is no log displayed
 * in the default console used by the jvm.
 * The default value is false.
 * 
 *
 */

public class _6_NoAgentConsoleLog {
	
	 public static void main(String[] args) {
	
		 new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,true, 2", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 //new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), Boolean.FALSE.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,true, 2", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
	 }

}
