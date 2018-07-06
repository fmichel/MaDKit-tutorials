package simulation.ex07;

import simulation.ex06.MySimulationModel;

/**
 *  #jws# simulation.ex07.MySimulationModel07 #jws#
 * 	#args# --launchAgents simulation.ex07.MySimulationModel07 #args# 
 * 
 * It is time to display using an alternative representation for the agents !! See {@link ImageViewer}
 */
public class MySimulationModel07 extends MySimulationModel {

    @Override
    protected void activate() {
	super.activate();

	// adding the new viewer
	ImageViewer viewer = new ImageViewer();
	launchAgent(viewer, true);
    }

    public static void main(String[] args) {
	executeThisAgent(1, false); // no gui for me
    }
}
