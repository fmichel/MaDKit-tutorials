package simulation.ex03;

import madkit.kernel.AbstractAgent;
import simulation.ex01.SimulationModel;

public class SimulatedAgent03 extends AbstractAgent {

    @Override
    protected void activate() {
	requestRole(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE);
	// I use this role to identify me as an agent that know how to do another behavior
	requestRole(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ANOTHER_ROLE);
    }

    @SuppressWarnings("unused")
    private void doIt() {
	getLogger().info("I am doing it, but my way");
    }

    @SuppressWarnings("unused")
    private void anotherBehavior() {
	getLogger().info("I am doing something else");
    }

}
