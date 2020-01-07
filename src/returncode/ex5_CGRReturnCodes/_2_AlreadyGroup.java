package returncode.ex5_CGRReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: ALREADY_GROUP.
 * This ReturnCode is returned when using createOrganization(String, String, boolean, Gatekeeper)
 * and that a group already exists.
 * 
 * 
 * #jws# returncode.ex5_CGRReturnCodes._2_AlreadyGroup #jws#
 * #args# --launchAgents returncode.ex5_CGRReturnCodes._2_AlreadyGroup, true #args#
 * 
 */

public class _2_AlreadyGroup extends TutorialAgent {

	/**
	 * This _2_AlreadyGroup agent does nothing in particular: he is just creating a group.
	 * What is interesting here is that the agent will display a message saying if the group has
	 * already been created.
	 */
	@Override
	protected void activate() {
		ReturnCode createFeedback ;
		createGroup("myCommunity", "myGroup");
		createFeedback = createGroup("myCommunity", "myGroup");
		getLogger().info("\n\tThe ReturnCode is: \"" + createFeedback.toString() + "\" .\n\tIt means that the group I wanted to create already exists. \t\n");
		pause(500);
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _2_AlreadyGroup agents.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
