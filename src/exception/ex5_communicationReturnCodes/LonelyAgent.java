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
 * This set of examples is about communication's return codes.
 * 
 * #jws exception.ex5_communicationReturnCodes.LonelyAgent jws#
 */
package exception.ex5_communicationReturnCodes;

import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * In this example we will see the AbstractAgent.ReturnCode.NO_RECIPIENT_FOUND. This code is returned by send primitives
 * when the targeted CGR location does not exist nor contain any agent.
 */
public class LonelyAgent extends Agent {

	/**
	 * Puts the agent in a virtual and lonely society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myLonelyCommunity", "myLonelyGroup");
		requestRole("myLonelyCommunity", "myLonelyGroup", "myLonelyRole");
	}
	
	/**
	 * During his life our agent will try to send a message to another agent of his group. As he is the only member of the group, the Agent#sendMessage()
	 * will failed and an error message will be displayed before our own.
	 */
	@Override
	protected void live() {
		ReturnCode returnSend;
		returnSend = sendMessage("myLonelyCommunity", "myLonelyGroup", "myLonelyRole", new Message());
		if(returnSend == ReturnCode.NO_RECIPIENT_FOUND) { /* If I can not find anyone to send message to */
			getLogger().info("\n\t I am the only agent of the group... \n\t");
			/* Do what you need to do in this case */
		}			
		/* Then you can keep doing you want with this agent */
	}

	/**
	 * Launch an exception.ex5_communicationReturnCodes.LonelyAgent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
