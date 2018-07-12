package madkitproperties;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;

public class _5_AgentLoadingPropertyFile extends AbstractAgent{

	@Override
	protected void activate() {
		getMadkitProperty("src/madkitproperties/PropertyFile.properties");
	}
	
	public static void main(String[] args) {
		new Madkit(Madkit.Option.launchAgents.toString(), _5_AgentLoadingPropertyFile.class.toString());
	}
	
}
