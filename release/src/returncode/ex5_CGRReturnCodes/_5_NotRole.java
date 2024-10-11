package returncode.ex5_CGRReturnCodes;

import madkit.kernel.Message;
import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: NOT_ROLE.
 * This ReturnCode indicates that a role does not exist.
 *
 * 
 * 
 */

public class _5_NotRole extends TutorialAgent{
	
	/**
	 *  We are initializing our _5_NotRole agent in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(500);
	}
		
	/**
	 * The _5_NotRole agent send a message to a role that does not exist. Thus the method sendMessage() will fail and a 
	 * warning is displayed.
	 * While checking the returnCode we have decided to display a message explaining why the method has failed.
	 * 
	 * A message informing that the sendMessage() has failed will also be displayed as a warning.
	 */
	@Override
	protected void live(){
		ReturnCode sendFeedback;
		sendFeedback = sendMessage("myCommunity", "myGroup", "notExistingRole", new Message()); /* Note that the role is different then "myRole" */
		getLogger().info("\n\tThe ReturnCode is: \"" + sendFeedback.toString() + "\" .\n\tIt means that I can not send a message to an agent whose role does not exist. \t\n");
			
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _5_NotRole agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}