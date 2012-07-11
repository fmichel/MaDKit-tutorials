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
package gui.ex01_defaultGUI;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how the default GUI mechanism works in MaDKit 5.
 * 
 * 		#jws gui.ex01_defaultGUI.DefaultGUIAgent jws#
 * 
 * The only thing to do for obtaining a default GUI for an agent
 * is to launch it with the GUI parameter set to true.
 * This could be done either in the MaDKit arguments or when launching an agent.
 * 
 * @version 0.9
 * @author Fabien Michel
 */
@SuppressWarnings("serial")
public class DefaultGUIAgent extends Agent {

	@Override
	protected void activate() {
		if (logger != null)
			logger.info("I have a default GUI which is automatically created for me \n because there was \n "
					+ "--launchAgents "
					+ getClass().getName()
					+ ",true \n on the command line");
		pause(2000);
	}

	@Override
	protected void live() {
		if (logger != null)
			logger.info("I now launch two hello world agents:\n one with a GUI and one without");
		pause(1000);
		// the one with no GUI: default argument for launchAgent
		launchAgent(new helloworld.ex01.HelloWorldAgent());
		// the one with a GUI: adding the GUI parameter to launchAgent
		launchAgent(new helloworld.ex01.HelloWorldAgent(), true);
		pause(2000);
	}

	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = { "--launchAgents",
				DefaultGUIAgent.class.getName() + ",true" };
		Madkit.main(args);
	}

}
