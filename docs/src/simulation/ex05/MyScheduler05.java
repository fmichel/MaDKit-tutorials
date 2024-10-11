package simulation.ex05;

import madkit.gui.ConsoleAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import simulation.ex04.MyScheduler04;

/**
 * 
 * 
 * 
 * Let us define explicitly how a simulation step takes place in order to define our own scheduling policy at will. This
 * is done by overriding {@link Scheduler#doSimulationStep()}.
 */

public class MyScheduler05 extends MyScheduler04 {

    /**
     * Our step consists in activating the first activator one time and the second two times. It could have been anything
     * else. In fact, we could do anything we want here, especially we also define another granularity for the step: 0.5
     */
    @Override
    public void doSimulationStep() {
	activator1.execute();
	activator2.execute();
	activator2.execute();
	setGVT(getGVT() + 0.5);
    }

    /**
     * A simple way of launching this scheduler. It is inherited but this is to make the IDE launch this one properly.
     */
    public static void main(String[] args) {
	new Madkit("--launchAgents", MyScheduler05.class.getName() + ",true;" + ConsoleAgent.class.getName());
    }

}
