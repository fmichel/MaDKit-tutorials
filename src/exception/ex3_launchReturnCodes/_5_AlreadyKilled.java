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
 * #jws exception.ex3_launchReturnCodes.AgentKillingTwice jws#
 */

package exception.ex3_launchReturnCodes;

import exception.TutorialAgent;

/**
 * In this example we will see the AbstractAgent.ReturnCode.ALREADY_KILLED. This code is returned by
 * kill primitives when the targeted agent is already terminated.
 */
public class _5_AlreadyKilled extends TutorialAgent {
	
	/** During his life, the agent will try to kill twice the same Agent. 
	 * Thus a message saying that the AbstractAgent.killAgent() has failed will be displayed.
	 */
	@Override
	protected void live() {
		TutorialAgent agentToKill = new TutorialAgent();
		launchAgent(agentToKill); /* Otherwise we will get an "NOT_YET_LAUNCHED" returnCode*/
		
		ReturnCode returnKill;
		killAgent(agentToKill);	/* We could have get the AbstractAgent.ReturnCode of this call but it is not what interests us here. */
		
		returnKill= killAgent(agentToKill); /* We store the AbstractAgent.ReturnCode of the second call to Agent#killAgent(Agent) in returnKill. */ 
		//getLogger().info(returnKill.toString());
		if(returnKill == ReturnCode.ALREADY_KILLED) { /* If the agent had been already killed. */
			getLogger().info("\n\t I have already killed this agent. I can not killed the same person twice. \t\n");
			/* Do what you need to do in this case */
		}
		
		/* Then you can keep doing you want with this agent */
	}
	
	/**
	 * Launch an exception.ex3_launchReturnCodes.AgentKillingTwice.
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
