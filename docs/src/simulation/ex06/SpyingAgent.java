package simulation.ex06;

import madkit.kernel.Watcher;
import madkit.simulation.probe.PropertyProbe;

/**
 * This class will be used to catch the name of the SimulatedAgent06 thanks to a probe.
 *
 * The madkit.kernel.Probe class defines a watcher's generic probe. A probe is configured
 * according to a community, a group and a role.
 */

public class SpyingAgent extends Watcher {

    /**
     * The probe by which we will get the agents' name.
     */
    protected PropertyProbe<SimulatedAgent06,String> agentsNameProbe;

    @Override
    protected void activate() {
        // 1 : request my role
        requestRole(MySimulationModel06.MY_COMMUNITY, MySimulationModel06.SIMU_GROUP, MySimulationModel06.SPY_ROLE);

        // 2 initialize the probe
        agentsNameProbe = new PropertyProbe<>(MySimulationModel06.MY_COMMUNITY, MySimulationModel06.SIMU_GROUP, MySimulationModel06.AGENT_ROLE, "name");
        addProbe(agentsNameProbe);
    }

    // this is just a simple method to be activated
    private void spyIt() {
        for (SimulatedAgent06 a: agentsNameProbe.getCurrentAgentsList() ) {
            // We collect the agent's name in a String
            String name = agentsNameProbe.getPropertyValue(a);
            getLogger().info("I am spying on the agent " + name);
        }
    }

}
