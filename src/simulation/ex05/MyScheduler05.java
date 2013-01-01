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
package simulation.ex05;

import java.util.logging.Level;

import madkit.gui.ConsoleAgent;
import madkit.kernel.Madkit;

import simulation.ex04.MyScheduler04;

/**
 * 		#jws simulation.ex05.MyScheduler05 jws#
 * 
 * Let us illustrate some other basic features of a scheduler
 * 
 */
@SuppressWarnings("serial")
public class MyScheduler05 extends MyScheduler04 {
	
	@Override
	protected void activate() {
		// This makes a pause of 300 ms between two simulation steps and can be modified later in the code or
		// using the scheduler GUI.
		setDelay(300);
		
		// Let us also display more information: 
		// the FINER log level of the Scheduler displays activation information 
		setLogLevel(Level.FINER);
		
		// The simulation will run until getGVT() >= 10 and then automatically quit
		setSimulationDuration(10);
		
		super.activate();
	}
	
	/**
	 * A simple way of launching this scheduler
	 * @param 
	 */
	public static void main(String[] args) {
		new Madkit("--launchAgents", MyScheduler05.class.getName()+",true;"+ConsoleAgent.class.getName());
	}


}
