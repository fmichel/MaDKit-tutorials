package simulation.ex06;

import madkit.gui.ConsoleAgent;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;

import static simulation.ex06.MySimulationModel06.MY_COMMUNITY;
import static simulation.ex06.MySimulationModel06.SIMU_GROUP;

/**
 *
 *
 *  In this example, the goal is only to manage the execution of some new agents. The new classes are the
 *  madkit.kernel.Watcher that manages a madkit.kernel.Probe and a spying agent :
 *  simulation.ex06.SpyingAgent.
 */

public class MyScheduler06 extends Scheduler {

    /**
     * We define here 2 activators, one is used for the agents and the other one
     * is used to activate the spy which probes their name.
     */
    protected GenericBehaviorActivator<AbstractAgent> agents;
    protected GenericBehaviorActivator<AbstractAgent> spy;

    @Override
    protected void activate() {

        // 1 : create the simulation group
        createGroup(MY_COMMUNITY, SIMU_GROUP);

        // 2 : request my role
        requestRole(MY_COMMUNITY, SIMU_GROUP, MySimulationModel06.SCH_ROLE);

        // 3 : launch an simple agent
        launchAgent(new SimulatedAgent06());

        // 4 : launch the spy agent
        launchAgent(new SpyingAgent());

        // 5 : initialize the activators
        // by default, they are activated once each in the order they have been added
        agents = new GenericBehaviorActivator<>(MY_COMMUNITY, SIMU_GROUP, MySimulationModel06.AGENT_ROLE, "doIt");
        addActivator(agents);
        spy = new GenericBehaviorActivator<>(MY_COMMUNITY, SIMU_GROUP, MySimulationModel06.SPY_ROLE, "spyIt");
        addActivator(spy);

        setDelay(300);
    }

    /**
     * A simple way of launching this scheduler
     */
    public static void main(String[] args) {
        new Madkit("--launchAgents", MyScheduler06.class.getName() + ",true;" + ConsoleAgent.class.getName());
    }

}
