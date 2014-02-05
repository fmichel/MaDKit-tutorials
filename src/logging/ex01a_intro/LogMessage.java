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
package logging.ex01a_intro;

import madkit.kernel.Agent;

/**
 * This tutorial is about the agent's logger attribute which 
 * is an alternative to the method System.out.println(). 
 * In fact the logger can do the same thing as 
 * System.out.println() : displaying message on the screen but it does
 * many other things. The logger is an instance of
 * the AgentLogger class of the MaDKit library
 * which extends the Logger class of the Java SE. 
 * 
 * In this tutorial we will see why and how the logger replaces 
 * the method System.out.println() in MaDKit. In the different examples 
 * of this tutorial we will see : 
 * - how to log a message
 * - the different log levels 
 * - the "finest" level particular features
 * - how to create a log file 
 * - how to choose the log directory
 * 
 * Firstly, we just display a message to the screen with the method
 * AgentLogger#info(String) of the logger. 
 * A simple agent is used, which has a default GUI, lives
 * 10 seconds and quits. During the life of the agent, we show how to log an
 * "info" message. As you will see, by default this message is displayed 
 * in both the output console and the agent's GUI
 * 
 *          #jws logging.ex01a_intro.LogMessage jws#
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class LogMessage extends Agent {

	@Override
	protected void live() {
		pause(2000);
		logger.info("This agent logs an 'info' message.");
		pause(8000);
	}

	public static void main(String[] args) {
		executeThisAgent();
	}
}
