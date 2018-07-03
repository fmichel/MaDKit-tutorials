package returncode.ex4_launchReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: NOT_YET_LAUNCHED. This ReturnCode is returned by
 * kill primitives when the targeted agent has not been launched priorly.
 * 
 * 
 * #jws exception.ex3_launchReturnCodes.AgentKillingNotLaunchedAgent jws#
 * 
 */

public class _1_NotYetLaunched extends TutorialAgent {

	/**
	 * During his life, the agent will try to kill a TutorialAgent that is not launched. 
	 * Thus a WARNING message saying that killAgent() has failed will be displayed.
	 */
	@Override
	protected void live() {
		ReturnCode killFeedback;
		killFeedback = killAgent(new TutorialAgent()); /* we kill a new TutorialAgent otherwise an agent who has not been launched */
		getLogger().info("\n\tThe ReturnCode is: \"" + killFeedback.toString() + "\" .\n\tIt means that I can not kill another agent if he is not launched. \t\n");
	}
	
	/**
	 * We launch a _1_NotYetLaunched agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
