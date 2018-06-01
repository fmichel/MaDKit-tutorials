/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what MadKit provides to improve our programs' reliability : AbstractAgent.ReturnCode
 * Now that you know what a AbstractAgent.ReturnCode is (see tutorial exception.ex2_usingReturnCodes), we will
 * see that we can divide them into three main parts
 *    ReturnCode for launch ; 
 *    ReturnCode for CGR ; 
 *    ReturnCode for communication.
 *    
 * This set of examples is about CGR's return codes.
 * 
 * #jws exception.ex4_CGRReturnCodes.AgentInNilCommunity jws#
 */

package exception.ex4_CGRReturnCodes;

import madkit.kernel.Agent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.NOT_COMMUNITY. This code indicates that a community does not exist.
 */
public class AgentInNilCommunity extends Agent{

	/**
	 * When activate, the exception.ex4_CGRReturnCodes.AgentInNilCommunity will request a role while he has not create any group.
	 * Thus the community is not set and does not exist for MaDKit. Our agent will display a message explaining why the method
	 * has failed.
	 * 
	 * A message informing that the requestRole() has failed will also be displayed as a warning.
	 */
	@Override	
	protected void activate() {
		ReturnCode returnRequest;
		returnRequest = requestRole("myCommunity", "myGroup", "myRole");
		if(returnRequest == ReturnCode.NOT_COMMUNITY) { /* If the community does not exist */
			getLogger().info("\n\t The requestRole() has failed : you can not request a role in a community that does not exist. \t\n");
			/* Do what you need to do in this case */
		}
			
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex4_CGRReturnCodes.AgentInNilCommunity.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
