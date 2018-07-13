package madkitoptions.ex3_MadkitOptions;

import java.awt.Color;

import madkit.gui.AgentFrame;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * This option allows MaDKit users to modify the display of a category of agent.
 * 
 * Of course, agentFrameClass needs to be associated with an existing 
 * class, here _4_CustomAgentFrame.
 * 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._4_AgentFrameClass #jws#
 * #args# #args#
 * 
 */

public class _4_AgentFrame extends AgentFrame{

	public _4_AgentFrame(AbstractAgent agent) {
		super(agent);
		setBackground(Color.GREEN);
	}

	/**
	 * Now we will launch a TutorialAgent after setting his
	 * agentFrameClass to _4_CustomAgentFrame.
	 */
	public static void main(String[] args) {
		new Madkit(Madkit.Option.agentFrameClass.toString(), _4_AgentFrame.class.getName(), Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName() + ",true");
	}
}
