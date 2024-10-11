package returncode.ex6_communicationReturnCodes;

import madkit.kernel.AgentAddress;
import madkit.kernel.Message;
import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: INVALID_AGENT_ADDRESS.
 * This ReturnCode is returned by send primitives when the targeted agent address does not exist anymore, i.e.
 * the related agent has leaved the corresponding role.
 * 
 * 
 * 
 */

public class _3_InvalidAgentAddress extends TutorialAgent{
	
	/**
	 *  We are initializing our _3_InvalidAgentAddress agent.
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
	 * Thus sendMessage(AgentAddress, Message) will fail, an error message will be displayed as a warning. 
	 */
	@Override
	protected void live() {
		// get a AgentAddress to exchange messages with.
		AgentAddress interlocutor = getAgentAddressIn("myCommunity", "myGroup", "myRole") ;
		
		// leave the role so the address other interlocutors obtained is now wrong.
		leaveRole("myCommunity", "myGroup", "myRole");		
		
		// try to send a message with the wrong obtained address.
		ReturnCode sendFeedback;
		sendFeedback = sendMessage(interlocutor, new Message());
		getLogger().warning("\n\tThe ReturnCode is: \"" + sendFeedback.toString() + "\" .\n\tIt means that the given address does not match with anyone. \n\tI can not communicate. :( \t\n");

		/* Then you do what you want with this agent */
	}
		

/**
 * Launch two _3_InvalidAgentAddress agent so that they can communicate.
 * @param argss
 */
    public static void main(String[] argss) {
    	executeThisAgent(2,false);
    }

}
