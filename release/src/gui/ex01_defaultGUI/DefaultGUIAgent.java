package gui.ex01_defaultGUI;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how the default GUI mechanism works in MaDKit 5.
 * 
 * 
 * The only thing to do for obtaining a default GUI for an agent is to launch it with the GUI parameter set to true.
 * This could be done either in the MaDKit arguments or when launching an agent.
 */

public class DefaultGUIAgent extends Agent {

    @Override
    protected void activate() {

	getLogger().info(
		"I have a default GUI which is automatically created for me \n because there was \n " + "--launchAgents " + getClass().getName() + ",true \n on the command line");
	pause(2000);
    }

    @Override
    protected void live() {
	getLogger().info("I now launch two hello world agents:\n one with a GUI and one without");
	pause(1000);
	// the one with no GUI: default argument for launchAgent
	launchAgent(new helloworld.ex01.HelloWorldAgent());
	// the one with a GUI: adding the GUI parameter to launchAgent
	launchAgent(new helloworld.ex01.HelloWorldAgent(), true);
	pause(2000);
    }

    /**
     * @param args
     */
    public static void main(String[] argss) {
	String[] args = { "--launchAgents", DefaultGUIAgent.class.getName() + ",true" };
	Madkit.main(args);
    }

}
