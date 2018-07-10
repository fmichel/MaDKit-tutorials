package returncode.ex5_CGRReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: NOT_COMMUNITY.
 * This ReturnCode indicates that a community does not exist.
 * 
 * 
 * #jws# returncode.ex5_CGRReturnCodes._1_NotCommunity #jws#
 * #args# --launchAgents returncode.ex5_CGRReturnCodes._1_NotCommunity #args#
 * 
 */

public class _1_NotCommunity extends TutorialAgent{

	/**
	 * When activate, the _1_NotCommunity agent will request a role while he has not create any group.
	 * Thus the community is not set and does not exist for MaDKit. Our agent will display a message explaining why the method
	 * has failed.
	 * 
	 * A message informing that the requestRole() has failed will also be displayed as a warning.
	 */
	@Override	
	protected void activate() {
		ReturnCode requestFeedback;
		requestFeedback = requestRole("myCommunity", "myGroup", "myRole");
		getLogger().info("\n\tThe ReturnCode is: \"" + requestFeedback.toString() + "\" .\n\tIt means that I can not request a role in a community that does not exist. \t\n");
			
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _1_NotCommunity agent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
