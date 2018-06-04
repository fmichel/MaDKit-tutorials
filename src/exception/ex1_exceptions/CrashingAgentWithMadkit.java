package exception.ex1_exceptions;

import madkit.kernel.Agent;
import madkit.kernel.Message;

public class CrashingAgentWithMadkit  extends Agent {
	
	public static void main(String[] argss) {
		Agent launcherAgent = new Agent();
		CrashingAgentWithMadkit agent = new CrashingAgentWithMadkit();
		launcherAgent.launchAgent(agent);
		agent.sendMessage("aCommunity", "aGroup", "aRole", new Message());
	}

}
