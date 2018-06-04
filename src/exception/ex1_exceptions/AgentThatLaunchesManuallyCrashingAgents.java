package exception.ex1_exceptions;

import madkit.kernel.Agent;

public class AgentThatLaunchesManuallyCrashingAgents extends Agent{
	
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
	 * We can see that the CrashingAgent crashes but not the other Agent : perrrrrrfect.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent(1, false);
	}
}

