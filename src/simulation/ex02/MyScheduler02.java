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
package simulation.ex02;

import madkit.gui.ConsoleAgent;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;
import simulation.ex01.SimulatedAgent;
import simulation.ex01.SimulationModel;

/**
 * 		#jws simulation.ex02.MyScheduler02 jws#
 * 
 * Let us have more fun by adding another simulated agent class
 * with a different result for the doIt method
 * and see what we now need.
 * 
 * We need nothing else and just have to launch this new type of agent: 
 * Activators do not care about the exact type of the activated agents.
 * Only the organizational position matters.
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler02 extends Scheduler {
	
	private GenericBehaviorActivator<AbstractAgent> activator1;
	
	@Override
	protected void activate() {
		// 1 : create the simulation group
		createGroup(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP);
		
		// 2 : launch some simulated agents
		for (int i = 0; i < 20; i++) {
			launchAgent(new SimulatedAgent());
			launchAgent(new SimulatedAgent02());
		}

		
		// 3 : initialize the activator
		activator1 = new GenericBehaviorActivator<AbstractAgent>(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE, "doIt");
		addActivator(activator1);
		
		setDelay(300);
	}

	/**
	 * A simple way of launching this scheduler
	 * @param 
	 */
	public static void main(String[] args) {
		new Madkit("--launchAgents", MyScheduler02.class.getName()+",true;"+ConsoleAgent.class.getName());
	}

}
