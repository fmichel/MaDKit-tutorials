package gui.ex02_overridingDefaultsettings;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;


/**
 * Shows how to override the default frame behavior with the default GUI mechanism of MaDKit 5
 * 
 */

public class OverridingDefaultFrameBehaviorAgent extends Agent {
	
	
	@Override
	public void setupFrame(AgentFrame frame) {
		super.setupFrame(frame);
		frame.setTitle("Overring Default Frame Behavior");
		frame.setLocation(0, 0);
		frame.setSize(500, 500);
	}

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
		String[] args = {"--launchAgents",OverridingDefaultFrameBehaviorAgent.class.getName()+",true"};
		Madkit.main(args);
	}

}
