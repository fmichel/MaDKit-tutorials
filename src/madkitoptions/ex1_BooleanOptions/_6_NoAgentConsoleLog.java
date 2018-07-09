package madkitoptions.ex1_BooleanOptions;

import madkitoptions.TutorialAgent;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of noAgentConsoleLog's option.
 * If this boolean option is set to true, there is no log displayed
 * in the agents' console.
 * The default value is false.
 * 
 * #jws# madkitoptions.ex1_BooleanOptions._6_NoAgentConsoleLog #jws#
 * #args# #args#
 *
 */

public class _6_NoAgentConsoleLog {
	
	 public static void main(String[] args) {
	
		 new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,true, 2", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 //new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), "false", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,true, 2", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
	 }

}
