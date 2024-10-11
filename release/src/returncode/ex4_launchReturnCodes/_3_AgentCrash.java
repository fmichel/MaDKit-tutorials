package returncode.ex4_launchReturnCodes;

import returncode.ex1_javaException.CrashingAgent;
import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: AGENT_CRASH.
 * This ReturnCode is returned by launch primitives when the launched agent crashes in activate().
 * 
 * 
 * 
 */

public class _3_AgentCrash extends TutorialAgent{

	/**
	 * On activation the agent will try to launch an agent that systematically crashes.
	 * Thus messages saying that launchAgent() has failed will be displayed before our own message.
	 */
	@Override
	protected void activate() {
		ReturnCode launchFeedback;
		launchFeedback = launchAgent(new CrashingAgent(),true); /* The new CrashingAgent() will crash */ 
		getLogger().info("\n\tThe ReturnCode is: \"" + launchFeedback.toString() + "\" .\n\tIt means that the agent I wanted to launched has crashed... \n\tTherefore you can notice that I am still alive.\t\n");
		
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch a _3_AgentCrash agent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
