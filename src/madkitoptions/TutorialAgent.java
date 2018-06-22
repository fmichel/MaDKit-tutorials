package madkitoptions;

import madkit.kernel.Agent;

public class TutorialAgent extends Agent{

	@Override
	protected void live() {
		getLogger().info("\n\t Hello ! I am an instance of Tutorial Agent.\t\n");
	}
}
