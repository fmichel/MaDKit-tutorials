package logging.ex03b_debugMode;

import madkit.kernel.Agent;

@SuppressWarnings("serial")
public class LaunchAfter extends Agent{
	
	protected void live(){
		logger.info("Log level = " + logger.getLevel() + "\n");
		logger.info("The debug mode apply only to agents already launched !");
		pause(5000);
	}
	
}
