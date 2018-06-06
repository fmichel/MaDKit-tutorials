package exception;

import madkit.kernel.Agent;

public class TutorialAgent extends Agent{

	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(500);
	}

	@Override
	protected void live() {
		//getLogger().talk("\n\t Hello ! I am a TutorialAgent. I exist only \n\t for the exception's tutorial. \t\n");
	}

	@Override
	protected void end() {
		pause(5000);
	}

}
