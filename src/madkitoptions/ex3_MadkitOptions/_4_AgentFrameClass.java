package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

public class _4_AgentFrameClass {

	public static void main(String[] args) {
		new Madkit(Madkit.Option.agentFrameClass.toString(), _4_CustomAgentFrame.class.getName(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true");
	}
}
