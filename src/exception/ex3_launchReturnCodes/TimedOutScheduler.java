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
 *  #jws exception.ex3_launchReturnCodes.TimedOutScheduler jws#
 */

package exception.ex3_launchReturnCodes;

import madkit.kernel.Scheduler;

/**
 * In this example we will see the AbstractAgent.ReturnCode.TIMEOUT. This code is returned by various timed primitives
 * of the Agent class like Agent.sendMessageAndWaitForReply(AgentAddress, Message). Here we will focus on
 * AbstractAgent#launchAgent(AbstractAgent, int, boolean).
 */

public class TimedOutScheduler extends Scheduler {

	/**
	 * This Scheduler will launch a TimedOutAgent and will minute this call with an absurd duration
	 * in order to generate the ReturnCode.TIMEOUT.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myTimedOutCommunity","myTimedOutGroup");
		int timeBeforeTimeOut = 1;	/* an absurd duration */
		ReturnCode returnLaunch;
		
		returnLaunch = launchAgent(new TimedOutAgent(), timeBeforeTimeOut, false); /* while minuting we launch a TimedOutAgent */
		if(returnLaunch == ReturnCode.TIMEOUT) { /* if the time is over */
			getLogger().info("\n\t Time out :( \n\t The duration of TimedOutAgent's activate() method is greater.\t\n");
			/* Do what you need to do in this case */
		}
		/* Then you can keep doing you want with this agent */
	}
	
/**
 * Launch an exception.ex3_launchReturnCodes.TimedOutScheduler
 * @param argss
 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
