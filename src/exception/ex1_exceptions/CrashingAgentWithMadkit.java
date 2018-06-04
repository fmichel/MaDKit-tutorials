package exception.ex1_exceptions;

import static  exception.ex1_exceptions.Society.COMMUNITY;
import static  exception.ex1_exceptions.Society.GROUP;
import static  exception.ex1_exceptions.Society.ROLE_CRASH;

import madkit.kernel.Agent;
import madkit.kernel.Message;

//TODO doc and see / explain Kernel exceptions
public class CrashingAgentWithMadkit  extends Agent {
	
	public static void main(String[] argss) {
		Agent launcherAgent = new Agent();
		CrashingAgentWithMadkit agent = new CrashingAgentWithMadkit();
		launcherAgent.launchAgent(agent);
		agent.sendMessage(COMMUNITY, GROUP, ROLE_CRASH, new Message());
	}

}
