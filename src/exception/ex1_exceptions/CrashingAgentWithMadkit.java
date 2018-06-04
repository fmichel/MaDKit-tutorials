package exception.ex1_exceptions;

import madkit.kernel.Agent;
import madkit.kernel.Message;

//TODO doc and see / explain Kernel exceptions
public class CrashingAgentWithMadkit  extends Agent {
	
	public static void main(String[] argss) {
		Agent launcherAgent = new Agent();
		CrashingAgentWithMadkit agent = new CrashingAgentWithMadkit();
		launcherAgent.launchAgent(agent);
		agent.sendMessage("myCommunity", "myGroup", "myRole", new Message());
	}

}
