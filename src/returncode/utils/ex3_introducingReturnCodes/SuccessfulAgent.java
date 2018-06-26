package returncode.utils.ex3_introducingReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * In this example we will show you how you can ensure your programs with methods' return code.
 * In MaDKit AbstractAgent.ReturnCode is an enumeration of codes which are returned by some methods of the API classes.
 * You can find the different constants in the documentation (http://www.madkit.net/madkit/repository/MaDKit-5.2/docs/api/)
 * 
 * In further exercises we will present you these codes : what they mean and example of how you can use them.
 * We can class them into three categories:
 *    ReturnCode for launch ; 
 *    ReturnCode for Community-Group-Role (CGR) ; 
 *    ReturnCode for communication.
 *  
 * In this example we will show you how you can use these codes by starting with the easiest:
 * AbstractCode.ReturnCode.SUCCESS. As you could have guessed, this code means that the called method
 * has not encountered any problem.
 * 
 * 
 * #jws exception.ex2_introducingReturnCodes.SuccessfulAgent jws#
 * 
 */

public class SuccessfulAgent extends TutorialAgent {
	
	/** We will call createGroup(...) and check if something went wrong thanks to
	 *  the ReturnCode.SUCCESS.
	 */
	@Override
	protected void activate() {
		ReturnCode createFeedback;
		createFeedback = createGroup("mySuccessfulCommunity", "mySuccessfulGroup");
		getLogger().info("\n\t The ReturnCode is: \"" + createFeedback.toString() +"\" .\n\tIt means that the method ended successfully.\t\n");
		
	}
	/**
	 * Launch a SuccessfulAgent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
