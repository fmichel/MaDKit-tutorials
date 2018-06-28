package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

// What is exactly the agent log level ? Info and off display the same stuff : All delete only GUI message
public class _2_AgentLogLevel {
	
	public static void main(String[] args) {
	
		/* Displays everything */
		//new Madkit(Madkit.LevelOption.agentLogLevel.toString(),"ALL", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
		
		/* Displays only the informational messages */
		//new Madkit(Madkit.LevelOption.agentLogLevel.toString(),"INFO", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
		
		/* The logging is turned off */ 
		new Madkit(Madkit.LevelOption.agentLogLevel.toString(),"OFF", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true,1;");
	}
}
