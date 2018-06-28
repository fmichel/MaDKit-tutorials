package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

public class _1_LaunchAgents {

	public static void main(String[] args) {
		//if not precised, launch one agent if the classe with no gui
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName());
		
		//this is equivalent to
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",false,1");
		
		//you can lauch several agent
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",3");
		
		//and precise whether you want a GUI or not
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",true");
		
		//here you launch several agent
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",true,2");
		
		//note that while launching several agent you don't have to precise everything each time
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",2;" + TutorialAgent.class.getName() + ",true,1;");
		
	}
}
