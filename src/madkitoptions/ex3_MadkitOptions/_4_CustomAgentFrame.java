package madkitoptions.ex3_MadkitOptions;

import java.awt.Color;

import madkit.gui.AgentFrame;
import madkit.kernel.AbstractAgent;

/**
 * 
 * This class represent a customized agent frame with a 
 * green background.
 * This class will be used in _4_AgentFrameClass.
 *
 */

public class _4_CustomAgentFrame extends AgentFrame{

	public _4_CustomAgentFrame(AbstractAgent agent) {
		super(agent);
		setBackground(Color.GREEN);
	}
	
}
