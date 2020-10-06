package simulation.ex06;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;

/**
 * 
 *  #jws# simulation.ex06.MyScheduler06 #jws#
 * 	#args# >--launchAgents simulation.ex06.EnvironmentAgent --agentLogLevel ALL #args# 
 * 
 * Nothing really new here, except that we define an additional Activator which is used to schedule the display.
 * Especially, this is about calling the "observe" method of agents having the role of viewer in the organization
 */

public class MyScheduler06 extends Scheduler {

    protected GenericBehaviorActivator<AbstractAgent> agents;
    protected GenericBehaviorActivator<AbstractAgent> viewers;

    @Override
    protected void activate() {

	// 1 : request my role
	requestRole(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.SCH_ROLE);

	// 3 : initialize the activators
	// by default, they are activated once each in the order they have been added
	agents = new GenericBehaviorActivator<>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.AGENT_ROLE, "doIt");
	addActivator(agents);
	viewers = new GenericBehaviorActivator<>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.VIEWER_ROLE, "observe");
	addActivator(viewers);

//	setDelay(20);

//	 4 : let us start the simulation automatically
	setSimulationState(SimulationState.RUNNING);
    }
}