package exception.ex5_communicationReturnCodes;

import exception.TutorialAgent;
import madkit.kernel.Message;

/**
 * This example is about the ReturnCode concerning agent's communication : NO_RECIPIENT_FOUND.
 * This code is returned by send primitives when the targeted CGR location does not exist nor contain any agent.
 * 
 * 
 * #jws exception.ex5_communicationReturnCodes._2_NoRecipientFound jws#
 * 
 */

public class _2_NoRecipientFound extends TutorialAgent {

	/**
	 * Puts the agent in a virtual and lonely society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myLonelyCommunity", "myLonelyGroup");
		requestRole("myLonelyCommunity", "myLonelyGroup", "myLonelyRole");
	}
	
	/**
	 * During his life our agent will try to send a message to another agent of his group. As he is the only member of the group, sendMessage()
	 * will fail and an error message will be displayed before our own.
	 */
	@Override
	protected void live() {
		ReturnCode returnSend;
		returnSend = sendMessage("myLonelyCommunity", "myLonelyGroup", "myLonelyRole", new Message());
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnSend.toString() + "\" .\n\tIt means that I am the only agent of the group... \n\t");
					
		/* Then you do what you want with this agent */
	}

	/**
	 * Launch a _2_NoRecipientFound agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
