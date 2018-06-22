package madkitoptions.ex1_BooleanOptions;

import exception.TutorialAgent;
import madkit.kernel.Madkit;

//put all agents' log levels are set to Level.ALL

public class _3_Debug {
	 public static void main(String[] args) {
		 new Madkit(Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName(),Madkit.BooleanOption.debug.toString());
	 }
}
