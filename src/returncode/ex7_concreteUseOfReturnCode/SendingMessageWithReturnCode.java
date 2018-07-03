package returncode.ex7_concreteUseOfReturnCode;

import java.util.logging.Level;

import madkit.kernel.Message;
import returncode.utils.TutorialAgent;

/** 
 * Now that we have see ReturnCodes, we will learn to use them
 * in order to correct a method that has failed.
 *
 *
 * #jws# returncode.ex7_concreteUseOfReturnCode.SendingMessageWithReturnCode #jws#
 * #args# --launchAgents returncode.ex7_concreteUseOfReturnCode.SendingMessageWithReturnCode #args#
 *
 */

public class SendingMessageWithReturnCode extends TutorialAgent {

	/**
	 * On activate() the agent allow the most precise's log level in order
	 * to see its life cycle's trace.
	 */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINEST);
		
		pause(3000);
	}
	
	/**
	 * During his lifetime, the agent will try to send a message. At first the method will failed because
	 * of missing criteria but by using ReturnCode we will fulfill one of them before calling this function
	 * again until we have met all the requirements.
	 */
	@Override
	protected void live() {
		ReturnCode sendFeedback;
		do {
			
			sendFeedback = sendMessage("myCommunity", "myGroup", "myRole", new Message());
			/* We display the name of the ReturnCode and its value. */
			getLogger().info("\n\t" + sendFeedback.name() + "\t" + sendFeedback.toString() +"\n\t");
			
			switch(sendFeedback) {
				case SUCCESS:
					getLogger().info("\n\t Message send ! \n\t");
					break;
				case NOT_COMMUNITY:
					getLogger().info("\n\t I should create the community. \n\t");
					createGroupIfAbsent("myCommunity", "myGroup");
					break;
				case NOT_GROUP:
					getLogger().info("\n\t I should create the group. \n\t");
					createGroup("myCommunity", "myGroup");
					break;
				case NOT_ROLE:
					getLogger().info("\n\t I should demand my role. \t\n");
					requestRole("myCommunity", "myGroup", "myRole");
					break;
				case NOT_IN_GROUP:
					getLogger().info("\n\t I am not in the group. This implies that the group exists. \n\t I will ask to join it. \t\n");
					requestRole("myCommunity", "myGroup", "myRole");
					break;
				case NO_RECIPIENT_FOUND:
					getLogger().info("\n\tI am alone, thus I can not find someone to send a message.\t\n");
					getLogger().info("\n\tI should launch another instance of myself\t\n");
					launchAgent(new SendingMessageWithReturnCode(),true);
					break;
				default:
					getLogger().info("\n\t Mmh. Something went wrong. Better quit this place. \n\t");
					killAgent(this);
					break;
			}
			
		}while(sendFeedback != ReturnCode.SUCCESS);
	}
	
	/**
	 * Before dying the agent will pause a long time so that you can have the time to read his message.
	 */
	@Override
	protected void end() {
		getLogger().info("\n\t My mission is over ! See you next time. \n\t");
		pause(35000);
	}
	
	/**
	 * We launch three agents.
	 * 
	 * The first agent that will be launch will have to create the group as it does not exist.
	 * Then for the next agents, the group will exist but as they are not part of it, they will have to ask to join it by requesting a role.
	 * They all have to request the role.
	 */
	public static void main(String[] argss) {
		executeThisAgent(3, true);
	}
	
}
