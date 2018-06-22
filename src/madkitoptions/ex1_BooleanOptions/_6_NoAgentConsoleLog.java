package madkitoptions.ex1_BooleanOptions;

import madkitoptions.TutorialAgent;
import madkit.kernel.Madkit;

public class _6_NoAgentConsoleLog {
	//false par défaut.
	 public static void main(String[] args) {
		 new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), "true", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,false, 2;");
		 //new Madkit(Madkit.BooleanOption.noAgentConsoleLog.toString(), "false", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + " ,false, 2;");
	 }

}
