package communication.ex06;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages. As in previous examples, Agent7 is doing the same job as Agent6, having a
 * RoleTest7.
 * 
 * @author Authors ARAGON Joseph and WAGNER Pascal.
 */

public class Agent7 extends Agent {

    @Override
    protected void activate() {
	getLogger().setLevel(Level.FINEST);

	createGroupIfAbsent("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest7");
	pause(500);
    }

    /*
     * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
     */
    @Override
    protected void live() {
	ReturnCode code = null;

	while (code != ReturnCode.SUCCESS) {
	    code = sendMessageWithRole("communication", "GroupTest", "RoleTest6", new Message(), "RoleTest7");
	    pause(2000);
	}
	while (nextMessage() != null)
	    pause(6000);
    }

    @Override
    public void setupFrame(AgentFrame frame) {
	super.setupFrame(frame);
	frame.setLocation(500, 100);
    }
}
