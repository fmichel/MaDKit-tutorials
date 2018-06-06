/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what MadKit provides to improve our programs' reliability : AbstractAgent.ReturnCode
 * Now that you know what a AbstractAgent.ReturnCode is (see tutorial exception.ex2_usingReturnCodes), we will see
 * that we can divide them into three main parts
 *    ReturnCode for launch ; 
 *    ReturnCode for CGR ; 
 *    ReturnCode for communication.
 *    
 * This set of examples is about CGR's return codes.
 * 
 * #jws exception.ex4_CGRReturnCodes.AgentInNilGroup jws#
 */

package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;
import madkit.kernel.Message;


/**
 * In this example we will see the AbstractAgent.ReturnCode.NOT_GROUP. This code indicates that a group does not exist.
 */

public class _3_NotGroup extends TutorialAgent {

	/**
	 *  We are initializing our AgentInNilGroup in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(500);
	}
	
	/**
	 * The AgentInNilGroup send a message to a group that does not exist. Thus the method sendMessage() fails and a 
	 * warning is displayed.
	 * While checking the returnCode we display a message explaining why the method has failed.
	 */
	@Override
	protected void live(){
		ReturnCode returnSend;
		returnSend = sendMessage("myCommunity", "nilGroup", "myRole", new Message()); 
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnSend.toString() + "\" .\n\tIt means that I can not send a message to a group that does not exist. \t\n");
					
		/* Then you can keep doing you want with this agent */
	}
		
	/**
	 * Launch an exception.ex4_CGRReturnCodes.AgentInNilGroup.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
