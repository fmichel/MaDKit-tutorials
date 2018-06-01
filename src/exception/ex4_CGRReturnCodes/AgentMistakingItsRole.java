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
 * #jws exception.ex4_CGRReturnCodes.AgentMistakingItsRole jws#
 */

package exception.ex4_CGRReturnCodes;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * In this example we will see the AbstractAgent.ReturnCode.ROLE_NOT_HANDLED. This code is returned when the agent does not have the role needed
 * if he wants to do a particular action.
 * 
 * The exception.ex4_CGRReturnCodes.AgentMistakingItsRole will send a message to an AgentSendingToUnknownRole while mistaking about the role he claims
 * to have. Thus an error will occur. Here the exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole needs only to exist so that we can send him
 * a message.
 */
public class AgentMistakingItsRole extends Agent{

	/**
	 * We activate the exception.ex4_CGRReturnCodes.AgentMistakingItsRole in the same virtual society than the
	 * exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole. Nevertheless, our agent will have a different role : myDifferentRole.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myDifferentRole");
		pause(500);
	}
	
	/**
	 * The exception.ex4_CGRReturnCodes.AgentMistakingItsRole will try to send a message to an exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole.
	 * However, in the method he uses : sendMessageWithRole(String community, String group, String role, Message message, String senderRole)
	 * our agent makes a mistake and specifies a role that is not his as senderRole.
	 */
	@Override
	protected void live(){
		ReturnCode returnSend;
		returnSend = sendMessageWithRole("myCommunity", "myGroup", "myRole", new Message(), "myRole");
		if(returnSend == ReturnCode.ROLE_NOT_HANDLED) { 
			getLogger().info("\t\n You do not have this role ... \t\n");
			/* Do what you need to do in this case */
		}
			
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex4_CGRReturnCodes.AgentMistakingItsRole and a exception.ex4_CGRReturnCodes.AgentSendingToUnknownRole (as receiver).
	 * @param argss
	 */
    public static void main(String[] argss){
    	new Madkit("--launchAgents", AgentMistakingItsRole.class.getName() + ",false,1;", AgentSendingToUnknownRole.class.getName() + ",false,1;");
    }
}
