/*
 * Copyright 2011-2012 Fabien Michel
 * 
 * This file is part of MaDKit-tutorials.
 * 
 * MaDKit-tutorials is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MaDKit-tutorials is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MaDKit-tutorials. If not, see <http://www.gnu.org/licenses/>.
 */
package simulation.ex06;

import madkit.gui.ConsoleAgent;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;

/**
 * 		#jws simulation.ex06.MySimulationModel jws#
 * 
 *  Nothing really new here, except that we define
 *  an additional Activator which is used to schedule the display.
 *  Especially, this is about calling the "observe" method of
 *  agents having the role of viewer in the organization
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler06 extends Scheduler {
	
	protected GenericBehaviorActivator<AbstractAgent> agents;
	protected GenericBehaviorActivator<AbstractAgent> viewers;
	
	@Override
	protected void activate() {

		// 1 : request my role
		requestRole(MySimulationModel.MY_COMMUNITY,
				MySimulationModel.SIMU_GROUP,
				MySimulationModel.SCH_ROLE); 
		
		// 3 : initialize the activators
		// by default, they are activated once each in the order they have been added
		agents = new GenericBehaviorActivator<AbstractAgent>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.AGENT_ROLE, "doIt");
		addActivator(agents);
		viewers = new GenericBehaviorActivator<AbstractAgent>(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.VIEWER_ROLE, "observe");
		addActivator(viewers);
		
		setDelay(20);

		//4 : let us start the simulation automatically
		setSimulationState(SimulationState.RUNNING);
	}

}
