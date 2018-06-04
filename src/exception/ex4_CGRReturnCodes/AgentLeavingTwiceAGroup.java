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
 * #jws exception.ex4_CGRReturnCodes.AgentLeavingTwiceAGroup jws#
 */

package exception.ex4_CGRReturnCodes;

import madkit.kernel.Agent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.NOT_IN_GROUP. This code indicates that an agent is not in a group.
 */
public class AgentLeavingTwiceAGroup extends Agent {

	/**
	 *  We are initializing our exception.ex4_CGRReturnCodes.AgentLeavingTwiceAGroup 
	 *  in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(1500);
	}
	
	/**
	 * The exception.ex4_CGRReturnCodes.AgentLeavingTwiceAGroup while deliberately leave the
	 * same group twice. At the first call of the method he will leave the group. At the second
	 * the method failed as he is not in this group and a warning is displayed.
	 * 
	 * While checking the returnCode we have decided to display a message explaining why the
	 * method had failed.A message informing that the sendMessage() has failed will also be
	 * displayed as a warning.
	 */
	@Override
	protected void live() {
		ReturnCode returnLeave;
		leaveGroup("myCommunity", "myGroup");
		returnLeave = leaveGroup("myCommunity", "myGroup");
		if(returnLeave == ReturnCode.NOT_IN_GROUP) {
			getLogger().info("\n\t I already have left this group, I can not leave a group twice. \t\n");
			/* Do what you need to do in this case */
		}
		/* Then you can keep doing you want with this agent */
	}
		

/**
 * Launch an exception.ex4_CGRReturnCodes.AgentLeavingTwiceAGroup.
 * @param argss
 */
    public static void main(String[] argss) {
    	executeThisAgent(10,false);
    }
}