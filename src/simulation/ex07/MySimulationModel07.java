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
package simulation.ex07;

import simulation.ex06.MySimulationModel;
import madkit.kernel.AbstractAgent;

/**
 * 		#jws simulation.ex07.MySimulationModel07 jws#
 * 
 *  It is time to display using an alternative representation
 *  for the agents !!
 *  
 *  See {@link ImageViewer}
 * 
 */
public class MySimulationModel07 extends MySimulationModel{

	@Override
	protected void activate() {
		super.activate();
		
		// create the new viewer
		ImageViewer viewer= new ImageViewer();
		launchAgent(viewer,true);
	}
	
	public static void main(String[] args) {
		executeThisAgent(1,false); //no gui for me
	}
}
