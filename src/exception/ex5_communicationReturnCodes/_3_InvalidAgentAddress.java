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
 * #jws exception.ex5_communicationReturnCodes.AgentChangingHisAddress jws#
 */

package exception.ex5_communicationReturnCodes;

import exception.TutorialAgent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Message;

/**
 * In this example we will see the AbstractAgent.ReturnCode.INVALID_AGENT_ADDRESS. This code is returned by send primitives when the targeted
 * agent address does not exist anymore, i.e. the related agent has leaved the corresponding role.
 */
public class _3_InvalidAgentAddress extends TutorialAgent{
	
	/**
	 *  We are initializing our exception.ex5_communicationReturnCodes.AgentChangingHisAddress
	 *  in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(1500);
	}
	
	/**
	 * During his life, the agent will look for the address of another agent in his group. Then he will change his role
	 * (so that means that the previous address is no more accurate). Using the previous address,
	 * the agent will try to send a Message to his interlocutor.
	 * 
	 * Thus the AbstractAgent#sendMessage(AgentAddress, Message) will fail, an error message will be displayed as a warning. 
	 */
	@Override
	protected void live() {
		// get a AgentAddress to exchange messages with.
		AgentAddress interlocutor = getAgentAddressIn("myCommunity", "myGroup", "myRole") ;
		
		// leave the role so the address other interlocutors obtained is now wrong.
		leaveRole("myCommunity", "myGroup", "myRole");		
		
		// try to send a message with the wrong obtained address.
		ReturnCode returnSend;
		returnSend = sendMessage(interlocutor, new Message());
		if(returnSend == ReturnCode.INVALID_AGENT_ADDRESS) {	/* if the address is wrong */
			getLogger().warning("\n\t The given address does not match with anyone. I can not communicate. :( \t\n");
			/* Do what you need to do in this case */
		}
		/* Then you can keep doing you want with this agent */
	}
		

/**
 * Launch two exception.ex5_communicationReturnCodes.AgentChangingHisAddress so that they can communicate.
 * @param argss
 */
    public static void main(String[] argss) {
    	executeThisAgent(2,false);
    }

}
