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
 * #jws exception.ex3_launchReturnCodes.AgentLaunchingCrashingAgent jws#
 */

package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;
import exception.ex1_exceptions.ex11_javaException.CrashingAgent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.AGENT_CRASH. This code is returned by launch primitives
 * when the launched agent crashes in AbstractAgent#activate().
 */
public class _3_AgentCrash extends TutorialAgent{

	/** On activation the agent will try to launch an agent that systematically crashes.. 
	 * Thus messages saying that the AbstractAgent.launchAgent() has failed will be displayed before our own message.
	 */
	@Override
	protected void activate() {
		ReturnCode returnLaunching;
		returnLaunching = launchAgent(new CrashingAgent()); /* The new CrashingAgent() will crash */ 
		
		if(returnLaunching == ReturnCode.AGENT_CRASH) { /* If the agent launched crashes */
			getLogger().info("\n\t The agent I wanted to launched has crashed... \n\t");
			/* Do what you need to do in this case */
		}
		
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex3_launchReturnCodes.AgentLaunchinCrashingAgent.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
