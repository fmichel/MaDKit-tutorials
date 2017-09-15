package gui.ex01_defaultGUI;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how the default GUI mechanism works in MaDKit 5
 * 
 */

public class DefaultGUIAgent extends Agent {
	

	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINE);
		//The following log will be both in the console and in the default GUI
		getLogger().info("I am in the activation phase");
		// the level "talk" can be used to print without any formatting whatever the log level
		getLogger().talk("\nI am talking \n\n");
	}
	
	@Override
	protected void live() {
		//setting this log level enables to see all agent default API operations 
		getLogger().setLevel(Level.FINEST);		
		waitNextMessage(1000);//will be logged because of FINEST
	}
	
	@Override
	protected void end() {
		requestRole("test", "test", "test");//should be logged too and also produces a warning
		getLogger().setLevel(Level.INFO);
		getLogger().setWarningLogLevel(Level.FINEST);
		requestRole("test", "test", "test");//no log and no warning
		getLogger().talk("\nI am talking \n\n");
		waitNextMessage(5000);//waiting the kill  just to see the result
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",DefaultGUIAgent.class.getName()+",true"};
		Madkit.main(args);
	}

}
