package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * This option allow MaDKit users to modify the display of a category of agent.
 * 
 * Of course, agentFrameClass need to be associated with an existing 
 * class, here _4_CustomAgentFrame.
 * 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._4_AgentFrameClass #jws#
 * #args# #args#
 * 
 */

public class _4_AgentFrameClass {

	/**
	 * Now we will launch a TutorialAgent after setting his
	 * agentFrameClass to _4_CustomAgentFrame.
	 */
	public static void main(String[] args) {
		new Madkit(Madkit.Option.agentFrameClass.toString(), _4_CustomAgentFrame.class.getName(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true");
	}
}
