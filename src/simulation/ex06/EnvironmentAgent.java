package simulation.ex06;

import java.awt.Dimension;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Watcher;
import madkit.simulation.probe.PropertyProbe;


/**
 * This agent is used to model a quite simple environment.
 * Nothing in it; It just defines its boundaries and uses
 * a {@link PropertyProbe} to set the agents' environment field so 
 * that they can use the environment's methods once they enter
 * the artificial society.
 * 
 */
public class EnvironmentAgent extends Watcher {
	
	/**
	 * environment's boundaries
	 */
	private Dimension	 dimension;
	
	/**
	 * so that the agents can perceive my dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	@Override
	protected void activate() {
		dimension = new Dimension(400, 400);

		// 1 : request my role so that the viewer can probe me 
		requestRole(MySimulationModel.MY_COMMUNITY,
				MySimulationModel.SIMU_GROUP,
				MySimulationModel.ENV_ROLE);
		
		// 2 : this probe is used to initialize the agents' environment field
		addProbe(new AgentsProbe(
					MySimulationModel.MY_COMMUNITY,
					MySimulationModel.SIMU_GROUP,
					MySimulationModel.AGENT_ROLE, 
					"environment"));
	}

	
	class AgentsProbe extends PropertyProbe<AbstractAgent, EnvironmentAgent>{
		
		public AgentsProbe(String community, String group, String role, String fieldName) {
			super(community, group, role, fieldName);
		}

		protected void adding(AbstractAgent agent) {
			super.adding(agent);
			setPropertyValue(agent, EnvironmentAgent.this);
		}
}

}