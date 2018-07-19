package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This example is about the level option AgentLogLevel.
 * This option allows the specifications of MaDKit agents'
 * log level.
 *
 * #jws# madkitoptions.ex2_LevelOptions._2_AgentLogLevel #jws#
 * #args# #args#
 */

public class _2_AgentLogLevel {
	
	public static void main(String[] args) {
	
		/* Displays everything */
		new Madkit(Madkit.LevelOption.agentLogLevel.toString(),Level.ALL.toString(), Madkit.Option.launchAgents.toString(), madkitoptions.util.TutorialAgent.class.getName() + ",true,1;");
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.agentLogLevel.toString(),Level.INFO.toString(), Madkit.Option.launchAgents.toString(), Agent.class.getName() + ",true,1;");
	}
}
