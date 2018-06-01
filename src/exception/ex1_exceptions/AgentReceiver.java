package exception.ex1_exceptions;

import static exception.ex1_exceptions.Society.COMMUNITY;
import static exception.ex1_exceptions.Society.GROUP;
import static exception.ex1_exceptions.Society.ROLERECEIVER;

import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * The only purpose of this class is to check if a send() from an Agent1 to a non-null address is effective.
 * Agent2 wait until it receives a message and displays it.
 * 
 * #jws exception.ex02.Agent2 jws#
 * 
 */
public class AgentReceiver extends Agent {

	/**
	 * Initialize Agent2's COMMUNITY, GROUP and ROLE in the society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent(COMMUNITY, GROUP);
		requestRole(COMMUNITY, GROUP, ROLERECEIVER);
		pause(500);
	}
	
	@Override
	protected void live() {
		getLogger().info("\n\t I wait a message... \n\t");
		Message m = null;
		while(m == null) {
			m = nextMessage();
		}
		getLogger().info("\n\t I have received : " + m.toString() + "\n\t");
	}

}
