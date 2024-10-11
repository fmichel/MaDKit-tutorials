package communication.ex05;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 *
 * 
 *
 * 
 * Agent5 is almost like Agent4, the only difference is their roles.
 */

public class Agent5 extends Agent {

    /*
     * Firstly, taking position in the artificial society (having a RoleTest5).
     */
    @Override
    protected void activate() {
	getLogger().setLevel(Level.FINEST);

	createGroup("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest5");
	pause(500);
    }

    /*
     * First getting an Agent address, and then sending him a message.
     */
    @Override
    protected void live()// In this live period, Agent5 is doing exactly the same as Agent4, with a different role (RoleTest5).
    {
	AgentAddress other = null;
	while (other == null) {
	    other = getAgentWithRole("communication", "GroupTest", "RoleTest4");
	    pause(1000);
	}

	getLogger().info("\n\tI found someone !!\n" + other + "\n\n");
	pause(1000);

	sendMessageWithRole(other, new Message(), "RoleTest5");

	while (nextMessage() != null)
	    pause(6000);
    }

    /**
     * @param argss
     *            Launching one Agent4 and one Agent 5.
     */
    public static void main(String[] argss) {
	new Madkit("--launchAgents", Agent4.class.getName() + ",true,1;", Agent5.class.getName() + ",true,1;");
    }

    /*
     * Setting where the agent's window will be for a clear presentation.
     */
    @Override
    public void setupFrame(AgentFrame frame) {
	super.setupFrame(frame);
	frame.setLocation(100, 350 * (hashCode() - 2));
    }
}
