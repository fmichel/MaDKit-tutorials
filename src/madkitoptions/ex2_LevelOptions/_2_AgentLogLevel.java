package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * This example is about the level option AgentLogLevel.
 * This option allow to specify the log level of agents
 * in MaDKit.
 *
 * #jws# madkitoptions.ex2_LevelOptions._2_AgentLogLevel #jws#
 * #args# #args#
 */

public class _2_AgentLogLevel {
	
	public static void main(String[] args) {
	
		/* Displays everything */
		new Madkit(Madkit.LevelOption.agentLogLevel.toString(),"ALL", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.agentLogLevel.toString(),"INFO", Madkit.Option.launchAgents.toString(), Agent.class.getName() + ",true,1;");
	}
}
