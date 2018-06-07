package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;

/**
 * This example is about the ReturnCode concerning agent's CGR : ALREADY_GROUP.
 * This code is returned when using createGroup(String, String, boolean, Gatekeeper)
 * and that a group already exists.
 * 
 * 
 * #jws exception.ex4_CGRReturnCodes._2_AlreadyGroup jws#
 * 
 */

public class _2_AlreadyGroup extends TutorialAgent {

	/**
	 * This _2_AlreadyGroup agent does nothing in particular : he is just creating a group.
	 * What is interesting here is that the agent will display a message saying if the group has
	 * already been created.
	 */
	@Override
	protected void activate() {
		ReturnCode returnCreate ;
		createGroup("myCommunity", "myGroup");
		returnCreate = createGroup("myCommunity", "myGroup");
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnCreate.toString() + "\" .\n\tIt means that the group I wanted to create already exists. \t\n");
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
