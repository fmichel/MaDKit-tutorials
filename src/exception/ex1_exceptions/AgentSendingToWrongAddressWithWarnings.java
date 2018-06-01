package exception.ex1_exceptions;

import static exception.ex1_exceptions.Society.COMMUNITY;
import static exception.ex1_exceptions.Society.GROUP;
import static exception.ex1_exceptions.Society.ROLERECEIVER;
import static exception.ex1_exceptions.Society.ROLESENDER;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Madkit.Option;
import madkit.kernel.Message;

/**
 * The aim of this tutorial is to help you understand the use of the AgentLogger's method : enableCGRWarnings().
 * This method enables the logging of Level.WARNING messages related with failed queries over the artificial society.
 * Thus even if your Log.LEVEL is set to an "higher" level than WARNING, those messages will be displayed.
 * 
 * #jws exception.ex02.AgentSendingToWrongAddressWithWarnings jws#
 * 
 */

public class AgentSendingToWrongAddressWithWarnings extends Agent {
	
	/**
	 * Initialize Agent1's COMMUNITY, GROUP and ROLE in the society. It is in this method that we decide whether or not we want
	 * to enable CGRWarnigs. We advise you to try to execute this example with the disableCGRWarnings() method first.
	 * Then comment the previous method and uncomment the next one to see what happens.
	 * 
	 */
	@Override
	protected void activate() {
		getLogger().enableCGRWarnings();
		
		getLogger().finest("This message shall not appear : its LEVEL is far too low.");
		
		createGroupIfAbsent(COMMUNITY, GROUP);
		requestRole(COMMUNITY, GROUP, ROLESENDER);
		pause(500);
	}
	
	/**
	 * This agent will send two messages. The first one to an Agent2 from whom he will get the address (initialized by getAgentWithRole(...)).
	 * The second message will be send to an address which does not exist, leading to an exception : 
	 * since the "roleAgent3" does not exist, getAgentWithRole(...) will not initialize the second address.
	 * Thus the final log shall not appear.
	 * 
	 */
	@Override
	protected void live() {
		getLogger().info("\n\tI will try to join an agent with a role of receiver ...\n");
		AgentAddress agentReceiver = null;
		agentReceiver = getAgentWithRole(COMMUNITY, GROUP, ROLERECEIVER);
		getLogger().info("\n\tI am sending a message to an agent receiver...\n");
		sendMessageWithRole(agentReceiver, new Message(), ROLESENDER);
		getLogger().info("\n\tI have sent my message.\n\n");
		
		getLogger().info("\n\tI will try to join an agent with a role that does not exist ...\n");
		AgentAddress nullAgent = null;
		nullAgent = getAgentWithRole(COMMUNITY, GROUP, "unknownRole");
		getLogger().info("\n\tI am sending a message to an agent who does not exist...\n");
		sendMessageWithRole(nullAgent, new Message(), ROLESENDER);
		getLogger().info("\n\tI have sent my message.\n\n"); /* this log will not appear */
	}
	
	
	/**
     * @param args
     */
	public static void main(String[] argss) {
		new Madkit(Option.launchAgents.toString(), AgentSendingToWrongAddressWithWarnings.class.getName() + ",false,1;" + AgentReceiver.class.getName() + ",false,1;" );
	}
}
