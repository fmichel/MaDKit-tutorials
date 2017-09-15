package gui.ex04_independentGUI;

import java.awt.BorderLayout;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import madkit.gui.menu.AgentLogLevelMenu;
import madkit.gui.menu.AgentMenu;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import gui.ex03_customPanel.CustomPanel;

/**
 * Shows how to build a totally independent GUI for a MaDKit 5 agent
 * 
 */

public class IndependentGUIAgent extends Agent {


	private JFrame myFrame;
	@Override
	protected void activate() {
		//building my own GUI
		buildGUI();

		getLogger().setLevel(Level.FINE);
		//The following log will be both in the console and in the default GUI
		getLogger().info("I am in the activation phase");
		// the level "talk" can be used to print without any formatting whatever the log level
		getLogger().talk("\nI am talking \n\n");
	}

	private void buildGUI() {
		myFrame = new JFrame("My own title");

		//but still getting some help from MaDKit GUI tools
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new AgentMenu(this));
		menuBar.add(new AgentLogLevelMenu(this));
		myFrame.setJMenuBar(menuBar);

		myFrame.add(new JLabel(new ImageIcon(CustomPanelAgent.class.getResource("agent.png"))),BorderLayout.CENTER);

		myFrame.setSize(150, 250);
		myFrame.setLocationRelativeTo(null);//centered
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myFrame.setVisible(true);
	}

	@Override
	protected void live() {
		//setting this log level enables to see all agent default API operations 
		getLogger().setLevel(Level.FINEST);		
		waitNextMessage(3000);//will be logged because of FINEST
	}

	@Override
	protected void end() {
		requestRole("test", "test", "test");//should be logged too and also produces a warning
		getLogger().setLevel(Level.INFO);
		getLogger().setWarningLogLevel(Level.FINEST);
		requestRole("test", "test", "test");//no log and no warning
		getLogger().talk("\nI am talking \n\n");
		pause(2000);
		myFrame.dispose(); //I have to take care of that
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",IndependentGUIAgent.class.getName()+",false"};//Not using the MK 5 default GUI mechanism
		//the following has the same effect
		//String[] args = {"--launchAgents",IndependentGUIAgent.class.getName()};
		Madkit.main(args);
	}

}
