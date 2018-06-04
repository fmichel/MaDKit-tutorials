package exception.ex1_exceptions;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

public class AgentThatLaunchesCrashingAgents extends Agent{


	/**
	 * We can see that the CrashingAgent crashes but not the other Agent : perrrrrrfect.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		new Madkit("--launchAgents", Agent.class.getName() + ",false,3;", CrashingAgentWithJava.class.getName() + ",false,1;");
	}
}
