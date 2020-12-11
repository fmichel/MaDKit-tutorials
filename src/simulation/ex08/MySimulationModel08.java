package simulation.ex08;

import simulation.ex07.MySimulationModel;

/**
 *  #jws# simulation.ex08.MySimulationModel08 #jws#
 * 	#args# --launchAgents simulation.ex08.MySimulationModel08 #args#
 * 
 * It is time to display using an alternative representation for the agents !! See {@link ImageViewer}
 */
public class MySimulationModel08 extends MySimulationModel {

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
