package simulation.ex01;

import madkit.kernel.AbstractAgent;

public class SimulatedAgent extends AbstractAgent {

    @Override
    protected void activate() {
	requestRole(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE);
    }

    @SuppressWarnings("unused")
    private void doIt() {
	getLogger().info("I am doing it");
    }

}
