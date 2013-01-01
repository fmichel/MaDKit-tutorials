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
package simulation.ex01;

import madkit.gui.ConsoleAgent;
import madkit.kernel.AbstractAgent;
import madkit.kernel.Madkit;
import madkit.kernel.Scheduler;
import madkit.simulation.activator.GenericBehaviorActivator;

/**
 * 		#jws simulation.ex01.MyScheduler jws#
 * 
 * In this first example, the goal is only to manage the execution of some
 * agents. Two classes are needed : a madkit.kernel.Scheduler that manages
 * an madkit.kernel.Activator and a simulated agent
 * class: simulation.ex01.SimulatedAgent
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler extends Scheduler {

	private GenericBehaviorActivator<AbstractAgent> activator1;

	@Override
	protected void activate() {

		// 1 : create the simulation group
		createGroup(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP);

		// 2 : launch some simulated agents
		for (int i = 0; i < 10; i++) {
			launchAgent(new SimulatedAgent());
		}

		// 3 : initialize the activator on the correct (1) CGR location and (2) behavior
		activator1 = new GenericBehaviorActivator<AbstractAgent>(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE, "doIt");
		addActivator(activator1);

		// 4 : we are done, because Scheduler already defines a live method
		// calling the execution of the activator. We will override it later.
		// here we just slow down the simulation to not flood the console
		setDelay(300);
	}

	/**
	 * A simple way of launching this scheduler
	 */
	public static void main(String[] args) {
		new Madkit("--launchAgents", MyScheduler.class.getName()+",true;"+ConsoleAgent.class.getName());
	}

}
