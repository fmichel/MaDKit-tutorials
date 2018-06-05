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

import exception.TutorialAgent;

/**
* We are creating an agent that pause before the end of his activation. We will use him in exception.ex3_launchReturnCodes.TimedOutScheduler.
* 
* #jws exception.ex3_launchReturnCodes.TimedOutScheduler jws#
*/
public class _4_TimeOut extends TutorialAgent {

	/**
	 * We are creating an Agent that only aims to be launch by our TimedOutScheduler.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myTimedOutCommunity", "myTimedOutGroup");
		requestRole("myTimedOutCommunity", "myTimedOutGroup", "myTimedOutRole");
		pause(1000);	
	}
	
	@Override
	protected void live() {
		int timeBeforeTimeOut = 1;	/* an absurd duration */
		ReturnCode returnLaunch;
		returnLaunch = launchAgent(new TutorialAgent(), timeBeforeTimeOut, false); /* while minuting we launch a TimedOutAgent */
		if(returnLaunch == ReturnCode.TIMEOUT) { /* if the time is over */
			getLogger().info("\n\t Time out :( \n\t The duration of TimedOutAgent's activate() method is greater.\t\n");
			/* Do what you need to do in this case */
		}
	}
	
	/**
	 * Launch an exception.ex3_launchReturnCodes.TimedOutScheduler
	 * @param argss
	 */
		public static void main(String[] argss) {
			executeThisAgent(1,true);
		}
}
