package madkitoptions.ex1_BooleanOptions;

import exception.TutorialAgent;
import madkit.kernel.Madkit;

public class _5_CreateLogFiles {
//false par défaut
	 public static void main(String[] args) {
		 //check the "logs" directory" (at the root of the imported project) to see the generated file
		 new Madkit(Madkit.BooleanOption.createLogFiles.toString(), "true", Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName());
	 }

}
