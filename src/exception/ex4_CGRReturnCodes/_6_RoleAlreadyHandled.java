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
 * #jws exception.ex4_CGRReturnCodes.AgentAskingSameRole jws#
 */

package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.ROLE_ALREADY_HANDLED. This code is returned when the agent already has the
 * requested role.
 * */
public class _6_RoleAlreadyHandled extends TutorialAgent{
	
	/**
	 * Our AgentAskingSameRole will deliberately ask twice the same role : when activate and in his lifetime.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
	}
	
	@Override
	protected void live() {
		/**
		 * The AgentAskingSameRole forget that he already has this role, so he asks for it again... Thus a message saying that the requestRole() has
		 * failed will be displayed.
		 */
		ReturnCode returnRequest;
		returnRequest = requestRole("myCommunity", "myGroup", "myRole");
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnRequest.toString() + "\" .\n\tIt means that I already have this role \t\n");
		
			
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex4_CGRReturnCodes.AgentAskingSameRole.
	 * @param argss
	 */
    public static void main(String[] argss) {
    	executeThisAgent();
    }
}
