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
 * #jws exception.ex5_communicationReturnCodes.AgentCantReply jws#
 */

package exception.ex5_communicationReturnCodes;

import exception.TutorialAgent;
import madkit.kernel.Message;

/**
 * In this example we will see the AbstractAgent.ReturnCode.CANT_REPLY. This code is returned when an agent tries to reply to
 * a message which has not been received from another agent, e.g. newly created or sent directly by an object using
 * AbstractAgent.receiveMessage(Message).
 */
public class _1_CantReply extends TutorialAgent{

	/**
	 * During his life, the agent will try to answer to a new message which is not possible as this message
	 * was not sent by any other agent.
	 */
	@Override
	protected void live() {
		ReturnCode returnSend;
		returnSend= sendReply(new Message(), new Message()); /* the agent try to answer a new message */
		
		if(returnSend == ReturnCode.CANT_REPLY) {
			getLogger().info("\n\t I can not reply to nothing \n\t");
			/* Do what you need to do in this case */
		}
		
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex5_communicationReturnCodes.AgentCantReply.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
