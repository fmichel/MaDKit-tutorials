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
package gui.ex02_overridingDefaultsettings;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;


/**
 * Shows how to override the default frame settings of the default GUI.
 * 
 * 		#jws gui.ex02_overridingDefaultsettings.OverridingDefaultSettings jws#
 * 
 * When an agent is launched with a GUI, the setupFrame method is
 * automatically called before activate. This method is the 
 * opportunity for the agent to modify the default settings of the frame.
 * 
 */
@SuppressWarnings("serial")
public class OverridingDefaultSettings extends Agent {
	
	
	@Override
	public void setupFrame(JFrame frame) {
		//adds the default output panel
		super.setupFrame(frame);
		
		//Overriding default settings
		frame.setTitle("Overriding Default Frame Behavior");
		frame.setLocation(200, 200);
		frame.setSize(500, 500);
	}

	@Override
	protected void live() {
		if(logger != null)
			logger.info("\n\tDo you see I changed my frame settings ?");
		pause(5000);
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",OverridingDefaultSettings.class.getName()+",true"};
		Madkit.main(args);
	}

}
