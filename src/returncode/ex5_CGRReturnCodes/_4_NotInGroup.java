package returncode.ex5_CGRReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: NOT_IN_GROUP.
 * This ReturnCode indicates that an agent is not in a group.
 *
 * 
 * #jws# returncode.ex5_CGRReturnCodes._4_NotInGroup #jws#
 * #args# --launchAgents returncode.ex5_CGRReturnCodes._4_NotInGroup, true #args#
 * 
 */

public class _4_NotInGroup extends TutorialAgent {

	/**
	 *  We are initializing our _4_NotInGroup agent
	 *  in its virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(1500);
	}
	
	/**
	 * The _4_NotInGroup while deliberately leave the same group twice.
	 * At the first call of the method he will leave the group. At the second
	 * the method will fail as he is not in this group and a warning is displayed.
	 * 
	 * While checking the returnCode we have decided to display a message explaining why the
	 * method has failed. A message informing that the sendMessage() has failed will also be
	 * displayed as a warning.
	 */
	@Override
	protected void live() {
		ReturnCode leaveFeedback;
		leaveGroup("myCommunity", "myGroup");
		leaveFeedback = leaveGroup("myCommunity", "myGroup");
		if(leaveFeedback == ReturnCode.NOT_IN_GROUP) {
			getLogger().info("\n\tThe ReturnCode is: \"" + leaveFeedback.toString() + "\" .\n\tIt means that I already have left this group, I can not leave a group twice. \t\n");
		}
		
		/* Then you do what you want with this agent */
	}
		

/**
 * Launch three _4_NotInGroup agents.
 * All the agent's second leaveGroup() call will return a ReturnCode.NOT_IN_GROUP
 * except the last one that will return a ReturnCode.NOT_COMMUNITY.
 * 
 * @param argss
 */
    public static void main(String[] argss) {
    	executeThisAgent(3,true);
    }
}