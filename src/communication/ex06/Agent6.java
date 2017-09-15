package communication.ex06;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * #jws communication.ex06.Agent6 jws#
 * 
 * Agent6 won't get an agent address, he will send him a message using sendMessageWithRole.
 * 
 * @author Authors ARAGON Joseph and WAGNER Pascal.
 */

public class Agent6 extends Agent {

    /*
     * Firstly, taking position in the artificial society (having a RoleTest6).
     */
    @Override
    protected void activate() {
	getLogger().setLevel(Level.FINEST);

	createGroupIfAbsent("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest6");
	pause(500);
    }

    /**
     * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
     */
    @Override
    protected void live() {
	ReturnCode code = null;
	while (code != ReturnCode.SUCCESS)// Until we succeed sending the message.
	{
	    // Sending a message to an Agent having a RoleTest7 Specifying Agent6's role.
	    code = sendMessageWithRole("communication", "GroupTest", "RoleTest7", new Message(), "RoleTest6");
	    pause(3000);
	}
	while (nextMessage() != null)
	    pause(6000);
    }

    /**
     * @param argss
     *            It will run one Agent6 and one Agent7.
     */
    @SuppressWarnings("unused")
    public static void main(String[] argss)// Launching two agents, Agent6 and Agent7.
    {
	new Madkit("--launchAgents", Agent6.class.getName() + ",true,1;", Agent7.class.getName() + ",true,1;");
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