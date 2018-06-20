package returncode.ex5_CGRReturnCodes;

import returncode.TutorialAgent;
import madkit.kernel.Message;

/**
 * This class exemplifies: NOT_GROUP.
 * This Returncode indicates that a group does not exist.
 * 
 * 
 * #jws exception.ex4_CGRReturnCodes._3_NotGroup jws#
 * 
 */

public class _3_NotGroup extends TutorialAgent {

	/**
	 *  We are initializing our _3_NotGroup agent in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(500);
	}
	
	/**
	 * The _3_NotGroup send a message to a group that does not exist. Thus method sendMessage() fails and a 
	 * warning is displayed.
	 * While checking the returnCode we display a message explaining why the method has failed.
	 */
	@Override
	protected void live(){
		ReturnCode sendFeedback;
		sendFeedback = sendMessage("myCommunity", "nilGroup", "myRole", new Message()); 
		getLogger().info("\n\tThe ReturnCode is: \"" + sendFeedback.toString() + "\" .\n\tIt means that I can not send a message to a group that does not exist. \t\n");
					
		/* Then you do what you want with this agent */
	}
		
	/**
	 * Launch an _3_NotGroup agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
