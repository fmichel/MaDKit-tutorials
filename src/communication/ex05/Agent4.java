package communication.ex05;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Madkit.Option;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * #jws communication.ex05.Agent4 jws#
 * 
 * Agent4 will get an agent's address, and then send his message using sendMessageWithRole.
 */

public class Agent4 extends Agent {

    /**
     * Firstly, taking position in the artificial society (having a RoleTest4).
     */
    @Override
    protected void activate() {
	getLogger().setLevel(Level.FINEST);

	createGroup("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest4");
	pause(500);
    }

    @Override
    protected void live() {
	AgentAddress other = null;// other will contain the Agent's address.
	while (other == null)// Until we found an Agent having "("communication","GroupTest","RoleTest4")".
	{
	    other = getAgentWithRole("communication", "GroupTest", "RoleTest4");
	    pause(1000);

	    if (other == null)// Or an Agent having "("communication","GroupTest","RoleTest5")".
	    {
		other = getAgentWithRole("communication", "GroupTest", "RoleTest5");
	    }
	    pause(1000);
	}
	getLogger().info("\n\tI found someone !!\n" + other + "\n\n");// Displaying our Agent properties (the one we founded).
	pause(1000);

	sendMessageWithRole(other, new Message(), "RoleTest4");// Sending the message specifying the sender's role.

	while (nextMessage() != null)
	    pause(6000);
    }

    /**
     * @param argss
     *            Running Agent4 will launch 2 Agent4.
     */
    public static void main(String[] argss)// Launching two Agent4.
    {
	new Madkit(Option.launchAgents.toString(), Agent4.class.getName() + ",true,2;");
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