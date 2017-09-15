package gui.ex03_customPanel;

import java.awt.BorderLayout;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import madkit.gui.OutputPanel;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to set a custom panel with the frame given by the default GUI mechanism of MaDKit 5
 * 
 */

public class CustomPanelAgent extends Agent {
	
	
	@Override
	public void setupFrame(AgentFrame frame) {
		JPanel p = new JPanel(new BorderLayout());
		//customizing but still using the OutputPanel from MaDKit GUI
		p.add(new OutputPanel(this),BorderLayout.CENTER);
		p.add(new JLabel(new ImageIcon(getClass().getResource("agent.png"))),BorderLayout.NORTH);
		p.validate();
		frame.add(p);
		frame.setTitle("Overring Default Frame Behavior");
		frame.setLocation(200, 0);
		frame.setSize(400, 500);
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
		requestRole("test", "test", "test");//should be log too and also produces a warning
		getLogger().setLevel(Level.INFO);
		getLogger().setWarningLogLevel(Level.FINEST);
		requestRole("test", "test", "test");//no log and no warning
		getLogger().talk("\nI am talking \n\n");
		waitNextMessage(10000);//waiting the kill  just to see the result
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",CustomPanelAgent.class.getName()+",true"};
		Madkit.main(args);
	}

}
