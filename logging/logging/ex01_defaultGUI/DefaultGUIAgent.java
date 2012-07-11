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

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how the default GUI mechanism works in MaDKit 5
 * 
 * @version 0.9
 * @author Fabien Michel
 */
@SuppressWarnings("serial")
public class DefaultGUIAgent extends Agent {
	

	@Override
	protected void activate() {
		setLogLevel(Level.FINE);
		//The following log will be both in the console and in the default GUI
		if(logger != null)
			logger.info("I am in the activation phase");
		// the level "talk" can be used to print without any formatting whatever the log level
		if(logger != null)
			logger.talk("\nI am talking \n\n");
	}
	
	@Override
	protected void live() {
		//setting this log level enables to see all agent default API operations 
		setLogLevel(Level.FINEST);		
		waitNextMessage(1000);//will be logged because of FINEST
	}
	
	@Override
	protected void end() {
		requestRole("test", "test", "test");//should be logged too and also produces a warning
		setLogLevel(Level.INFO);
		getLogger().setWarningLogLevel(Level.FINEST);
		requestRole("test", "test", "test");//no log and no warning
		if(logger != null)
			logger.talk("\nI am talking \n\n");
		waitNextMessage(5000);//waiting the kill  just to see the result
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",DefaultGUIAgent.class.getName()+",true"};
		Madkit.main(args);
	}

}
