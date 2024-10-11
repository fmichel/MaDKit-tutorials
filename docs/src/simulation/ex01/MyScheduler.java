package simulation.ex01;

import java.util.logging.Level;

import madkit.gui.ConsoleAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;

/**
 * 
 *
 *
 * The madkit.kernel.Scheduler class defines a generic threaded scheduler agent.
 * It holds a collection of activators. The default state of a scheduler is Scheduler.SimulationState.PAUSED
 *
 * Let us illustrate some basic features of a scheduler
 */

public class MyScheduler extends Scheduler {

    @Override
    protected void activate() {
	// This makes a pause of 300 ms between two simulation steps and can be modified later in the code or
	// using the scheduler GUI.
	setDelay(300);

	// Let us also display more information:
	// the FINER log level of the Scheduler displays activation information
	getLogger().setLevel(Level.FINER);

	// The simulation will run until getGVT() >= 10 and then automatically quit
	setSimulationDuration(10);

	super.activate();
    }

    /**
     * A simple way of launching this scheduler
     * 
     * @param
     */
    public static void main(String[] args) {
	new Madkit("--launchAgents", MyScheduler.class.getName() + ",true;" + ConsoleAgent.class.getName());
    }

}
