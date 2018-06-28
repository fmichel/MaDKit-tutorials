package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;
import madkitoptions.ex1_BooleanOptions._2_Agent;
import madkitoptions.ex1_BooleanOptions._2_Agent;

//this is deprecated, if you 
public class _6_WarningLogLevel {
	
	public static void main(String[] args) {
		
		/* Displays everything */
		//new Madkit(Madkit.LevelOption.warningLogLevel.toString(),"ALL", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		
		/* Displays only the informational messages */
		//new Madkit(Madkit.LevelOption.warningLogLevel.toString(),"INFO", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		
		/* The logging is turned off */ 
		new Madkit(Madkit.LevelOption.warningLogLevel.toString(),"OFF", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
	}
}
