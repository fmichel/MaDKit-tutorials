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

import java.awt.Dimension;

import madkit.kernel.AbstractAgent;

public class SituatedAgent extends AbstractAgent {
	
	/**
	 * The agent's environment. 
	 * Here it is just used to know its boundaries. 
	 * It will be automatically set
	 * by the environment agent itself: No need to instantiate anything here.
	 */
	private EnvironmentAgent environment;
	
	/**
	 * agent's position
	 */
	private Dimension location = new Dimension();

	/**
	 * initialize my role and fields
	 */
	@Override
	protected void activate() {
		requestRole(MySimulationModel.MY_COMMUNITY, MySimulationModel.SIMU_GROUP, MySimulationModel.AGENT_ROLE);
		Dimension envDim = environment.getDimension();
		location.width = (int) (Math.random()*envDim.width);
		location.height = (int) (Math.random()*envDim.height);
	}
	
	/**
	 * A non sense behavior, just moving around.
	 */
	@SuppressWarnings("unused")
	private void doIt() {
		Dimension envDim = environment.getDimension();
		location.width += Math.random()*4 - 1;
		location.height += Math.random()*4 - 1;
		location.width %= envDim.width;
		location.height %= envDim.height;
	}

}
