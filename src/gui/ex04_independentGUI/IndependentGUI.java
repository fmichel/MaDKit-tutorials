package gui.ex04_independentGUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import gui.ex03_customPanel.CustomPanel;
import madkit.gui.OutputPanel;
import madkit.gui.menu.AgentLogLevelMenu;
import madkit.gui.menu.AgentMenu;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to build a totally independent GUI for an agent.
 * 
 * #jws gui.ex04_independentGUI.IndependentGUI jws#
 * 
 * Not using the default GUI mechanism of course makes the source code much more longer without any real benefits here.
 * So, it is safe to say that the default mechanism should be used almost always. This because: (1) the default
 * mechanism does not prevent a full control over the created frame. (2) the life cycle of the agent is automatically
 * related with the frame's, so that nothing has to be added. Still, there are of course cases where it could be a
 * convenient solution. Especially, it could be interesting to use both the default mechanism and an independent GUI for
 * developing/debugging purposes like in the next example.
 */

public class IndependentGUI extends Agent {

    private JFrame myFrame;

    /**
     * building my own GUI here
     */
    @Override
    protected void activate() {
	myFrame = new JFrame("My own title");

	JPanel p = new JPanel(new BorderLayout());

	JPanel talkPanel = new OutputPanel(this);
	talkPanel.setBackground(Color.LIGHT_GRAY);
	p.add(talkPanel, BorderLayout.CENTER);

	p.add(new JLabel(new ImageIcon(CustomPanel.class.getResource("agent.png"))), BorderLayout.NORTH);

	myFrame.add(p);
	// but still getting some help from madkit.gui components
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(new AgentMenu(this));
	menuBar.add(new AgentLogLevelMenu(this));
	myFrame.setJMenuBar(menuBar);

	myFrame.setSize(400, 500);
	myFrame.setLocationRelativeTo(null);// centered

	// Beware that end will not be called
	// if the frame is closed by the user...
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	myFrame.setVisible(true);
    }

    @Override
    protected void live() {
	getLogger().info("\n\tI have defined my own frame,\n\twith some predefined menus, though");
	pause(5000);
    }

    /**
     * I have to close the frame myself because its life cycle is not managed by the MaDKit kernel.
     */
    @Override
    protected void end() {
	myFrame.dispose();

	System.exit(0);
    }

    /**
     * @param argss
     *            unused here
     */
    public static void main(String[] argss) {
	String[] args = { "--launchAgents", IndependentGUI.class.getName() };
	// + ",false" }; would not change anything as it is the default setting
	Madkit.main(args);
    }

}
