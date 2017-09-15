package gui.ex02_overridingDefaultsettings;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to override the default frame settings of the default GUI. #jws
 * gui.ex02_overridingDefaultsettings.OverridingDefaultSettings jws#
 * 
 * When an agent is launched with a GUI, the setupFrame method is automatically called before activate. This method is
 * the opportunity for the agent to modify the default settings of the frame.
 */

public class OverridingDefaultSettings extends Agent {

    @Override
    public void setupFrame(AgentFrame frame) {
	// adds the default output panel
	super.setupFrame(frame);

	// Overriding default settings
	frame.setTitle("Overriding Default Frame Behavior");
	frame.setLocation(200, 200);
	frame.setSize(500, 500);
    }

    @Override
    protected void live() {
	getLogger().info("\n\tDo you see I changed my frame settings ?");
	pause(5000);
    }

    /**
     * @param args
     */
    public static void main(String[] argss) {
	String[] args = { "--launchAgents", OverridingDefaultSettings.class.getName() + ",true" };
	Madkit.main(args);
    }

}
