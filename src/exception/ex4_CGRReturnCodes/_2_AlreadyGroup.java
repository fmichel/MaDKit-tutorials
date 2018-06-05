/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what MadKit provides to improve our programs' reliability : AbstractAgent.ReturnCode
 * Now that you know what a AbstractAgent.ReturnCode is (see tutorial exception.ex2_usingReturnCodes), we will
 * see that we can divide them into three main parts
 *    ReturnCode for launch ; 
 *    ReturnCode for CGR ; 
 *    ReturnCode for communication.
 *    
 * This set of examples is about CGR's return codes.
 * 
 * #jws exception.ex4_CGRReturnCodes.AgentCreatingExistingGroup jws#
 */

package exception.ex4_CGRReturnCodes;

import exception.TutorialAgent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.ALREADY_GROUP. This code is returned when using
 * AbstractAgent.createGroup(String, String, boolean, Gatekeeper) and that a group already exists.
 */
public class _2_AlreadyGroup extends TutorialAgent {

	/**
	 * This exception.ex4_CGRReturnCodes.AgentCreatingExistingGroup does not do anything in particular : he is just creating a group.
	 * What is interesting here is to test if the groupe has already been created. Our AgentCreatingExistingGroup will then display
	 * a message if it is the case.
	 */
	@Override
	protected void activate() {
		ReturnCode returnCreate ;
		returnCreate = createGroup("myCommunity", "myGroup");
		if(returnCreate == ReturnCode.ALREADY_GROUP) {	/* Test whether or not the group already exists. */
			getLogger().info("\n\t This group exists already. \t\n");
			/* Do what you need to do in this case */
		}
		pause(500);
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch two exception.ex4_CGRReturnCodes.AgentCreatingExistingGroup so that the group will be created once and the error's message displayed.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent(2, false);
	}
}
