package simulation.ex06;

import java.awt.Dimension;

import madkit.kernel.AbstractAgent;

public class SituatedAgent extends AbstractAgent {

    /**
     * The agent's environment. Here it is just used to know its boundaries. It will be automatically set by the environment
     * agent itself: No need to instantiate anything here.
     */
    protected EnvironmentAgent environment;

    /**
     * agent's position
     */
    protected Dimension location = new Dimension();

    /**
     * initialize my role and fields
     */
    @Override
    protected void activate() {
	requestRole(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.AGENT_ROLE);
	Dimension envDim = environment.getDimension();
	location.width = (int) (Math.random() * envDim.width);
	location.height = (int) (Math.random() * envDim.height);
    }

    /**
     * A non sense behavior, just moving around.
     */
    @SuppressWarnings("unused")
    private void doIt() {
	Dimension envDim = environment.getDimension();
	location.width += Math.random() * 4 - 1;
	location.height += Math.random() * 4 - 1;
	location.width %= envDim.width;
	location.height %= envDim.height;
    }

}
