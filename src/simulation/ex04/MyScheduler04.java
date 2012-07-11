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
package simulation.ex04;

import madkit.kernel.Scheduler;
import simulation.ex03.MyScheduler03;

/**
 * 
 * Let us define explicitly how a simulation step takes place in order
 * to define our own scheduling policy at will.
 * This is done by overriding {@link Scheduler#doSimulationStep()}.
 * 
 * @author Fabien Michel
 *
 * @version 0.9
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler04 extends MyScheduler03 {
	
	/**
	 * Our step consists in activating the first activator one time
	 * and the second two times. It could have been anything else. 
	 * In fact, we could do anything we want here,
	 * especially we also define another granularity for the step: 0.5
	 */
	@Override
	public void doSimulationStep() {
		triggerActivator(activator1);
		triggerActivator(activator2);
		triggerActivator(activator2);
		setGVT(getGVT()+0.5);
	}
	
	/**
	 * A simple way of launching this scheduler.
	 * It is inherited but this is to make the IDE
	 * launch this one properly.
	 */
	public static void main(String[] args) {
		executeThisAgent(args);
	}

}
