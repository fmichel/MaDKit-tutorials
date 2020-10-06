package simulation.ex06;

import madkit.kernel.AbstractAgent;

/**
 * 
 * #jws# simulation.ex06.MySimulationModel #jws# #args# --launchAgents simulation.ex06.MySimulationModel #args#
 * 
 * It is time to display something !! The only purpose of this class is to show an example of what could be a launching
 * sequence. The display work is done in {@link Viewer}
 */
public class MySimulationModel extends AbstractAgent {

    // Organizational constants
    public static final String MY_COMMUNITY = "simu";
    public static final String SIMU_GROUP = "simu";
    public static final String AGENT_ROLE = "agent";
    public static final String ENV_ROLE = "environment";
    public static final String SCH_ROLE = "scheduler";
    public static final String VIEWER_ROLE = "viewer";

    @Override
    protected void activate() {
	// 1 : create the simulation group
	createGroup(MY_COMMUNITY, SIMU_GROUP);

	// 2 : create the environment
	EnvironmentAgent environment = new EnvironmentAgent();
	launchAgent(environment);

	// 4 : launch some simulated agents
	for (int i = 0; i < 10; i++) {
	    launchAgent(new SituatedAgent());
	}

	// 5 : create the scheduler
	MyScheduler06 scheduler = new MyScheduler06();
	launchAgent(scheduler, true);

	// 3 : create the viewer
	Viewer viewer = new Viewer();
	launchAgent(viewer, true);

    }

    public static void main(String[] args) {
	executeThisAgent(1, false); // no gui for me
    }
}
