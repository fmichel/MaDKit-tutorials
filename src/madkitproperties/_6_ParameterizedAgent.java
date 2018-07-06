package madkitproperties;

import madkit.kernel.Agent;

public class _6_ParameterizedAgent extends Agent{

	private String message;
	
	@Override
	protected void live() {
		pause(2500);
		getLogger().talk("\n\t" + message + "t\n");
		pause(5000);
	}
}
