package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;

/**
 * This example is about the ReturnCode concerning agent's CGR : ROLE_ALREADY_HANDLED.
 * This code is returned when the agent already has the
 * requested role.
 * 
 * 
 * #jws exception.ex4_CGRReturnCodes._6_RoleAlreadyHandled jws#
 * 
 */

public class _6_RoleAlreadyHandled extends TutorialAgent{
	
	/**
	 * Our _6_RoleAlreadyHandled agent will deliberately ask twice the same role : when activate and in his lifetime.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		ReturnCode returnRequest1 = requestRole("myCommunity", "myGroup", "myRole");
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnRequest1.toString() + "\" .\n\tI have the role I wanted !\t\n");
	}
	
	@Override
	protected void live() {
		/**
		 * The _6_RoleAlreadyHandled agent forgets that he already has this role,
		 * so he asks for it again... Thus a message saying that the requestRole()
		 * has failed will be displayed.
		 */
		ReturnCode returnRequest2;
		returnRequest2 = requestRole("myCommunity", "myGroup", "myRole");
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnRequest2.toString() + "\" .\n\tIt means that I already have this role \t\n");
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _6_RoleAlreadyHandled agent.
	 * 
	 * @param argss
	 */
    public static void main(String[] argss) {
    	executeThisAgent();
    }
}
