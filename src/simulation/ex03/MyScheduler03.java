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
package simulation.ex03;

import madkit.gui.ConsoleAgent;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;
import simulation.ex01.SimulatedAgent;
import simulation.ex01.SimulationModel;
import simulation.ex02.SimulatedAgent02;

/**
 * 		#jws simulation.ex03.MyScheduler03 jws#
 * 
 * Let us have more fun by adding another activator
 * on another role to execute the other behavior of {@link SimulatedAgent03}
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler03 extends Scheduler {
	
	protected GenericBehaviorActivator<AbstractAgent> activator1;
	protected GenericBehaviorActivator<AbstractAgent> activator2;
	
	@Override
	protected void activate() {

		// 1 : create the simulation group
		createGroup(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP);
		
		// 2 : launch some simulated agents
		for (int i = 0; i < 10; i++) {
			launchAgent(new SimulatedAgent());
			launchAgent(new SimulatedAgent02());
			launchAgent(new SimulatedAgent03());
		}

		
		// 3 : initialize the activators
		// by default, they are activated once each in the order they have been added
		activator1 = new GenericBehaviorActivator<AbstractAgent>(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE, "doIt");
		addActivator(activator1);
		activator2 = new GenericBehaviorActivator<AbstractAgent>(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ANOTHER_ROLE, "anotherBehavior");
		addActivator(activator2);
		
		setDelay(300);

		//4 : let us start the simulation automatically
		setSimulationState(SimulationState.RUNNING);
	}

	/**
	 * A simple way of launching this scheduler
	 * @param 
	 */
	public static void main(String[] args) {
		new Madkit("--launchAgents", MyScheduler03.class.getName()+",true;"+ConsoleAgent.class.getName());
	}

}
