package returncode.ex6_communicationReturnCodes;

import returncode.TutorialAgent;
import madkit.kernel.Message;

/**
 * This class exemplifies: CANT_REPLY.
 * This ReturnCode is returned when an agent tries to reply to a message which has not been
 * received from another agent, e.g. newly created or sent directly by an object using
 * AbstractAgent.receiveMessage(Message).
 * 
 * 
 * #jws exception.ex5_communicationReturnCodes._1_CantReply jws#
 * 
 */

public class _1_CantReply extends TutorialAgent{

	/**
	 * During his life, the agent will try to answer to a new message which is not possible as this message
	 * was not sent by any other agent.
	 */
	@Override
	protected void live() {
		ReturnCode sendFeedback;
		sendFeedback = sendReply(new Message(), new Message()); /* the agent try to answer a new message */
		getLogger().info("\n\tThe ReturnCode is: \"" + sendFeedback.toString() + "\" .\n\tIt means that I can not reply to a message that was not send before. \n\t");
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _1_CantReply agent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
