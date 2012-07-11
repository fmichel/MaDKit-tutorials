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

import madkit.kernel.AbstractAgent;

/**
 * @author Fabien Michel
 *
 * @version 0.9
 * 
 */
@SuppressWarnings("serial")
public class SimulatedAgent extends AbstractAgent {

	@Override
	protected void activate() {
		requestRole(SimulationModel.MY_COMMUNITY, SimulationModel.SIMU_GROUP, SimulationModel.ROLE);
	}
	
	@SuppressWarnings("unused")
	private void doIt() {
		if(logger != null)
			logger.info("I am doing it");
	}

}
