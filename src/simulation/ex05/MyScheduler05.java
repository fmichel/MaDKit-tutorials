package simulation.ex05;

import java.util.logging.Level;

import madkit.gui.ConsoleAgent;
import madkit.kernel.Madkit;
import simulation.ex04.MyScheduler04;

/**
 * 
 *  #jws# simulation.ex05.MyScheduler05 #jws#
 * 	#args# --launchAgents simulation.ex05.MyScheduler05,true;madkit.gui.ConsoleAgent #args# 
 * 
 * Let us illustrate some other basic features of a scheduler
 */

public class MyScheduler05 extends MyScheduler04 {

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
	new Madkit("--launchAgents", MyScheduler05.class.getName() + ",true;" + ConsoleAgent.class.getName());
    }

}
