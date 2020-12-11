package simulation.ex06;

import madkit.kernel.AbstractAgent;

/**
 * In this example, we create a simulated agent extended from the AbstractAgent class
 * to set a role to this agent. We also give him a name so that the spy can probe his name.
 */

public class SimulatedAgent06 extends AbstractAgent {

    protected String name = "SimulatedAgent06";

    @Override
    protected void activate() {
        requestRole(MySimulationModel06.MY_COMMUNITY, MySimulationModel06.SIMU_GROUP, MySimulationModel06.AGENT_ROLE);
    }

    private void doIt() {
        getLogger().info("I am doing it");
    }
}
