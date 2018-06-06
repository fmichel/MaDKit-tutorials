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
 * This set of examples is about launch's return codes.
 * 
 *  #jws exception.ex3_launchReturnCodes.AgentLaunchingTwice jws#
 */

package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;
/**
 * In this example we will see the AbstractAgent.ReturnCode.ALREADY_LAUNCHED. This code is returned
 * when we try to launch an agent which is already launched.
 */
public class _2_AlreadyLaunched extends TutorialAgent{

	/**
	 * On activation, the agent will try to launched himself whereas.... He is already launched.. 
	 * Thus a message saying that the AbstractAgent.launchAgent() has failed will be displayed.
	 */
	@Override
	protected void activate() {
		ReturnCode returnLaunch;
		returnLaunch = launchAgent(this);
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnLaunch.toString() + "\" .\n\tIt means that I have already been launched : I can not be launched twice \n\t");
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * We launch an exception.ex3_launchReturnCodes.AgentLaunchingTwice.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
