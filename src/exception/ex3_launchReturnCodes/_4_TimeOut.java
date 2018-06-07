package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;

/**
 * This example is about the ReturnCode concerning agent's launching : TIMEOUT.
 * This code is returned by various timed primitives of the Agent class.
 * 
 * 
 * #jws exception.ex3_launchReturnCodes._4_TimeOut jws#
 * 
 */

public class _4_TimeOut extends TutorialAgent {

	/**
	 * We install our agent in his virtual society.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myTimedOutCommunity", "myTimedOutGroup");
		requestRole("myTimedOutCommunity", "myTimedOutGroup", "myTimedOutRole");
	}
	
	@Override
	protected void live() {
		int timeBeforeTimeOut = 0;	/* an absurd duration */
		
	
		/**
		 * The ReturnCode of the next method will be TIME_OUT if the agent we launch has not ended his activate method.
		 * Here as we are giving him 0 micro second to finish it. Thus it will return this code.
		 */
		
		ReturnCode returnLaunch;
		returnLaunch = launchAgent(new TutorialAgent(), timeBeforeTimeOut, false); /* while minuting we launch a TutorialAgent. */
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnLaunch.toString() + "\" .\n\tIt means that the activate method did not ended in time. \t\n");
	}
	
	/**
	 * Launch a _4_TimeOut agent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent(1,true);
	}
}
