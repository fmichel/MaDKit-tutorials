package logging.ex03b_debugMode;

import madkit.kernel.Agent;


public class LaunchAfter extends Agent{
	
	protected void live(){
		getLogger().info("Log level = " + getLogger().getLevel() + "\n");
		getLogger().info("The debug mode apply only to agents already launched !");
		pause(5000);
	}
	
}
