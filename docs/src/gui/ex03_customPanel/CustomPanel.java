package gui.ex03_customPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import madkit.gui.AgentFrame;
import madkit.gui.OutputPanel;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to set a custom panel to the default frame.
 * 
 * 
 * In this example, we customize the default frame layout. Doing so, we still use the madkit.gui.OutputPanel component
 * to ease the work.
 */

public class CustomPanel extends Agent {

    @Override
    public void setupFrame(AgentFrame frame) {
	JPanel p = new JPanel(new BorderLayout());

	// customizing but still using the madkit.gui.OutputPanel component
	JPanel talkPanel = new OutputPanel(this);
	talkPanel.setBackground(Color.LIGHT_GRAY);
	p.add(talkPanel, BorderLayout.CENTER);

	//Add the image to the frame
	p.add(new JLabel(new ImageIcon(getClass().getResource("agent.png"))), BorderLayout.NORTH);

	frame.add(p);
	frame.setLocation(200, 0);
	frame.setSize(400, 500);
    }

    @Override
    protected void live() {
	getLogger().info("\n\tDo you see my customized panel ?");
	pause(10000);
    }

    /**
     * @param argss
     */
    public static void main(String[] argss) {
		//To display the panel of an agent, before that we always need to set the MadKit kernel online
	String[] args = { "--launchAgents", CustomPanel.class.getName() + ",true" };
	Madkit.main(args);
    }

}
