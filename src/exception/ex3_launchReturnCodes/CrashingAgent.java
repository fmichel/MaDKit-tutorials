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
 */

package exception.ex3_launchReturnCodes;

import madkit.kernel.AbstractAgent;

/**
* We are creating an agent that will systematically crash. We will use him in exception.ex3_launchReturnCodes.AgentLaunchingCrashingAgent.
* 
* #jws exception.ex3_launchReturnCodes.AgentLaunchingCrashingAgent jws#
*/
public class CrashingAgent extends AbstractAgent{

	/* We just want this method to fail.*/
	@Override
	protected void activate() {
		Object o = null;
		o.toString();
	}
}
