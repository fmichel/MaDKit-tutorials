package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;
import exception.ex1_exceptions.ex11_javaException.CrashingAgent;

/**
 * This example is about the ReturnCode concerning agent's launching : AGENT_CRASH.
 * This code is returned by launch primitives when the launched agent crashes in activate().
 * 
 * 
 * #jws exception.ex3_launchReturnCodes._3_AgentCrash jws#
 * 
 */

public class _3_AgentCrash extends TutorialAgent{

	/**
	 * On activation the agent will try to launch an agent that systematically crashes.
	 * Thus messages saying that launchAgent() has failed will be displayed before our own message.
	 */
	@Override
	protected void activate() {
		ReturnCode returnLaunch;
		returnLaunch = launchAgent(new CrashingAgent(),true); /* The new CrashingAgent() will crash */ 
		getLogger().info("\n\tThe ReturnCode value is : \"" + returnLaunch.toString() + "\" .\n\tIt means that the agent I wanted to launched has crashed... \n\tTherefore you can notice that I am still alive.\t\n");
		
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
