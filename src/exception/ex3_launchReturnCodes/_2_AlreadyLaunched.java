package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;

/**
 * This example is about the ReturnCode concerning agent's launching : ALREADY_LAUNCHED.
 * This code is returned when we try to launch an agent which is already launched.
 * 
 * 
 * #jws exception.ex3_launchReturnCodes._2_AlreadyLaunched jws#
 * 
 */

public class _2_AlreadyLaunched extends TutorialAgent{

	/**
	 * On activation, the agent will try to launched himself whereas.... He is already launched.. 
	 * Thus a message saying that launchAgent() has failed will be displayed.
	 */
	@Override
	protected void activate() {
		ReturnCode returnLaunch;
		returnLaunch = launchAgent(this);
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnLaunch.toString() + "\" .\n\tIt means that I have already been launched : I can not be launched twice \n\t");
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * We launch a _2_AlreadyLaunched agent.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
