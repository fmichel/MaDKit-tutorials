package exception.ex1_exceptions;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

public class AgentRefused extends Agent{
	
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		ReturnCode returnCode = requestRole("myCommunity", "myGroup", "myRole");
		if(returnCode == ReturnCode.ACCESS_DENIED ) {
			getLogger().info("\n\t I have been refused... :( \n\t");
		}
	}
	
	public static void main(String[] argss) {
		new Madkit("--launchAgents", AgentRefused.class.getName() + ",false,1;", MeanGatekeeper.class.getName() + ",false,1;");
	}
	
}
