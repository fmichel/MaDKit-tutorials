package returncode.ex4_launchReturnCodes;

import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: ALREADY_KILLED.
 * This ReturnCode is returned by kill primitives when the targeted agent is already terminated.
 * 
 * 
 * #jws# returncode.ex4_launchReturnCodes._5_AlreadyKilled #jws#
 * #args# --launchAgents returncode.ex4_launchReturnCodes._5_AlreadyKilled, true #args#
 * 
 */

public class _5_AlreadyKilled extends TutorialAgent {
	
	/** During his life, the agent will try to kill twice the same TutorialAgent. 
	 *  Thus a message saying that killAgent() has failed will be displayed.
	 */
	@Override
	protected void live() {
		TutorialAgent agentToKill = new TutorialAgent();
		launchAgent(agentToKill,true); /* Otherwise we will get an "NOT_YET_LAUNCHED" returnCode*/
		
		ReturnCode killFeedback;
		killFeedback = killAgent(agentToKill);
		getLogger().info("\n\tThe ReturnCode is: \"" + killFeedback.toString() + "\" .\n\t I have successfully killed this agent. \t\n");
		killFeedback = killAgent(agentToKill); 
		getLogger().info("\n\tThe ReturnCode is: \"" + killFeedback.toString() + "\" .\n\tIt means that I have already killed this agent. I can not killed the same person twice. \t\n");		
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _5_AlreadyKilled agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
