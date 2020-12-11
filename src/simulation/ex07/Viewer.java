package simulation.ex07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import madkit.kernel.Watcher;
import madkit.simulation.probe.PropertyProbe;
import madkit.simulation.probe.SingleAgentProbe;
import madkit.simulation.viewer.SwingViewer;

/**
 * This class will be used to display the simulation. We could have extended the {@link Watcher} class, but there are a
 * lot of things already defined in {@link SwingViewer}. So why not use it.
 */
public class Viewer extends SwingViewer {

    /**
     * environment's size, probed using a {@link SingleAgentProbe}.
     */
    private Dimension envSize;

    /**
     * The probe by which we will get the agents' location
     */
    protected PropertyProbe<SituatedAgent, Dimension> agentsLocationProbe;

    @Override
    protected void activate() {
	// 1 : request my role so that the scheduler can take me into account
	requestRole(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.VIEWER_ROLE);

	// 2 : adding the probes

	// probing the environment using an anonymous inner class
	SingleAgentProbe<EnvironmentAgent, Dimension> envProbe = new SingleAgentProbe<EnvironmentAgent, Dimension>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP,
		MySimulationModel.ENV_ROLE, "dimension") {

	    @Override
	    protected void adding(EnvironmentAgent agent) {
		super.adding(agent);
		envSize = getPropertyValue();
	    }
	};
	addProbe(envProbe);
	
	// probing agents' location
	agentsLocationProbe = new PropertyProbe<SituatedAgent, Dimension>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.AGENT_ROLE, "location");
	addProbe(agentsLocationProbe);

	// 3 : Now that the probes are added,
	// we can setup the frame for the display according to the environment's properties
	getDisplayPane().setPreferredSize(envSize);
	getFrame().pack();

	// 4 (optional) set the synchronous painting mode: The display will be updated
	// for each step of the simulation.
	// Here it is useful because the simulation goes so fast that the agents
	// are almost invisible
	setSynchronousPainting(true);
    }

    /**
     * render is the method where the custom painting has to be done. Here, we just draw red points at the agents' location
     */
    @Override
    protected void render(Graphics g) {
	g.setColor(Color.RED);
	for (SituatedAgent a : agentsLocationProbe.getCurrentAgentsList()) {
	    Dimension location = agentsLocationProbe.getPropertyValue(a);
	    g.drawRect(location.width, location.height, 1, 1);
	}
    }

}
