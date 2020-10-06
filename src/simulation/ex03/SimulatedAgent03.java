package simulation.ex03;

import madkit.kernel.AbstractAgent;
import simulation.ex02.SimulationModel;

public class SimulatedAgent03 extends AbstractAgent {

    @Override
    protected void activate() {
	requestRole(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE);
    }

    @SuppressWarnings("unused")
    private void doIt() {
	getLogger().info("I am doing it, but my way");
    }

}
