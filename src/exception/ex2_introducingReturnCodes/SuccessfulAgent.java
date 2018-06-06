/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what MadKit provides to improve our programs' reliability : AbstractAgent.ReturnCode
 */

package exception.ex2_introducingReturnCodes;

import exception.TutorialAgent;

/**
 * In this example we will show you how you can ensure your programs with methods' return code.
 * In MaDKit AbstractAgent.ReturnCode is an enumeration of codes which are returned by some methods of the API classes.
 * You can find the different constants here : http://www.madkit.net/madkit/repository/MaDKit-5.2/docs/api/
 * 
 * In further exercises we will present you these codes : what they mean and example of how you can use them.
 * 
 * 
 *  #jws exception.ex2_introducingReturnCodes.SuccessfulAgent jws#
 * 
 * 
 * In this example we will show you how you can use these codes. We will start with the easiest :
 * AbstractCode.ReturnCode.SUCCESS
 * As you could have guessed, this code mean that the called method has not encountered any problem.
 */

public class SuccessfulAgent extends TutorialAgent {
	
	/** We will call the method Agent#createGroup(...) and check if something went wrong thanks to
	 *  the AbstractAgent.ReturnCode.SUCCESS.
	 */
	@Override
	protected void activate() {
		ReturnCode returnCreate;
		returnCreate = createGroup("mySuccessfulCommunity", "mySuccessfulGroup");
		getLogger().info("\n\t The ReturnCode value is : \"" + returnCreate.toString() +"\" .\n\tIt means that the method ended successfully.\t\n");
		
	}
	/**
	 * Launch one SuccessfulAgent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
