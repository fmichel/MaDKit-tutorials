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
 * #jws exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole jws#
 */

package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;
import madkit.kernel.Message;

/**
 * In this example we will see the AbstractAgent.ReturnCode.NOT_ROLE. This code indicates that a role does not exist.
 */
public class _5_NotRole extends TutorialAgent{
	
	/**
	 *  We are initializing our exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(500);
	}
		
	/**
	 * The AgentSendingToUnknownRole send a message to a role that does not exist. Thus the method sendMessage() fails and a 
	 * warning is displayed.
	 * While checking the returnCode we have decided to display a message explaining why the method had failed.
	 * 
	 * A message informing that the sendMessage() has failed will also be displayed as a warning.
	 */
	@Override
	protected void live(){
		ReturnCode returnSend;
		returnSend = sendMessage("myCommunity", "myGroup", "notExistingRole", new Message()); /* Note that the role is different then "myRole" */
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnSend.toString() + "\" .\n\tIt means that I can not send a message to an agent whose role does not exist. \t\n");
			
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}