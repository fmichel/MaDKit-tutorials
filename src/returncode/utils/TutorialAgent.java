package returncode.utils;

import madkit.kernel.Agent;

/**
 * We create a new agent for this tutorial. 
 */

public class TutorialAgent extends Agent{

	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(200);
	}

	@Override
	protected void live() {}

	@Override
	protected void end() {
		pause(5000);
	}

}
