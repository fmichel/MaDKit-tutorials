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
 *  #jws exception.ex3_launchReturnCodes.AgentKillingNotLaunchedAgent jws#
 */

package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.NOT_YET_LAUNCHED. This code is returned by
 * kill primitives when the targeted agent has not been launched priorly.
 */

public class _1_NotYetLaunched extends TutorialAgent {

	/**
	 * During his life, the agent will try to kill an Agent that is not launched. 
	 * Thus a WARNING message saying that the AbstractAgent.killAgent() has failed will be displayed.
	 */
	@Override
	protected void live() {
		ReturnCode returnKill;
		returnKill = killAgent(new TutorialAgent()); /* we kill a new Agent otherwise an agent who has not been launched */
		if(returnKill == ReturnCode.NOT_YET_LAUNCHED) {
			getLogger().info("\n\t I can not kill another agent if he is not launched \t\n");	/* getLogger() allows a message to be displayed in the console or the frame of an agent. See logging tutorials. */
		}
	}
	
	/**
	 * We launch an exception.ex3_launchReturnCodes.AgentKillingNotLaunchedAgent
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
