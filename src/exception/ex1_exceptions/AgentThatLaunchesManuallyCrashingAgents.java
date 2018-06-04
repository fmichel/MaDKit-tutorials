/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what kind of exceptions may be encountered while developing
 * an application with MaDKit.
 * 
 * #jws exception.ex1_exceptions.AgentThatLaunchesManuallyCrashingAgents jws#
 */
package exception.ex1_exceptions;

import java.util.logging.Level;

import madkit.kernel.Agent;

/**
 * Good failure's managing is extremely important in multi-agent system.
 * We do not want that because of the crash of one of our agents, the whole
 * society crashes too.
 * 
 * In this example we will see how are other agents impacted if one of them crash.
 * We will see this while using the AbstractAgent#launchAgent(AbstractAgent) method.
 */
public class AgentThatLaunchesManuallyCrashingAgents extends Agent{
	
	/**
	 * On activation we will just set the log level on FINEST so that
	 * the agent's life cycle is traced.
	 * See the logging tutorial for more information.
	 */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINEST);
	}
	
	/**
	 * Launches three Agent and one exception.ex1_exceptions.CrashingAgentWithJava. 
	 */
	@Override
	protected void live() {
		//first launch some Agent
		for(int counter = 0 ; counter < 3 ; counter++) {
			launchAgent(new Agent());
		}
		//then launch a CrashingAgent
		launchAgent(new CrashingAgentWithJava());
	}
	
	/**
	 * Launch a  exception.ex1_exceptions.AgentThatLaunchesManuallyCrashingAgents. As expected, the
	 * exception.ex1_exceptions.CrashingAgentWithJava will crash but without having any impact
	 * on the life of the three other agents. 
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent(1, false);
	}
}

