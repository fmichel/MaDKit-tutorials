package returncode.ex4_launchReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies ALREADY_LAUNCHED.
 * This ReturnCode is returned when we try to launch an agent which is already launched.
 * 
 * 
 * 
 */

public class _2_AlreadyLaunched extends TutorialAgent{

	/**
	 * On activation, the agent will try to launched himself whereas... He is already launched...
	 * Thus a message saying that launchAgent() has failed will be displayed.
	 */
	@Override
	protected void activate() {
		ReturnCode launchFeedback;
		launchFeedback = launchAgent(this);
		getLogger().info("\n\tThe ReturnCode is: \"" + launchFeedback.toString() + "\" .\n\tIt means that I have already been launched : I can not be launched twice \n\t");
		
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
