package exception.ex02_enableCGRWarnings;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Message;

/**
 * TODO explain the purpose of this class : show mistakes / exceptions
 * 
 * #jws exception.ex02.Agent1 jws#
 * 
 */

public class Agent1 extends Agent {

	/**
	 * TODO
	 */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.SEVERE); /* we do not want the warning logs to appear */
		
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "roleAgent1");
		pause(500);
	}
	
	/**
	 * This agent will try to get an agent's address which does not exist and send a message to it. Thus an exception will occur.
	 *
	 * Since the "roleAgent3" does not exist, getAgentWithRole(...) will not initialize our address.
	 */
	@Override
	protected void live() {
		getLogger().info("\n\tI try to join an agent with a 'roleAgent3' ...\n\n");
		AgentAddress agentWithRole4 = null;
		agentWithRole4 = getAgentWithRole("myCommunity", "myGroup", "roleAgent3");
		sendMessageWithRole(agentWithRole4, new Message(), "RoleAgent3");
		getLogger().info("\n\tWhy can't I send a message ?\n\n"); /* this log will not appear */
	}

	
	/**
     * @param args
     */
	public static void main(String[] argss) {
		executeThisAgent(1, true);
	}
}
