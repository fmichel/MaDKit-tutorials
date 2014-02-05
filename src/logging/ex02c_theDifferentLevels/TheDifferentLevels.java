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
package logging.ex02c_theDifferentLevels;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.AgentLogger;

/**
 * 		The java.util.logging.Level class of the Java SE defines a set of standard logging levels that can be
 * used to control logging outputs: Here they are in
 * descending order :
 * 						- severe
 * 						- warning
 * 						- info
 * 						- config
 * 						- fine
 *	                    - finer
 * 						- finest
 * 
 * In addition there is a level OFF that can be used to turn off logging, and
 * a level ALL that can be used to enable the logging of all messages.
 * In MaDKit, the {@link AgentLogger#talk(String)} method is added to 
 * define an additional level which is used log a talk message.
 * 
 * 		This is an example which recaps how to set and get the log level and
 * how we display or not messages according to their level. All the levels are used here.
 * 
 * 			#jws logging.ex02c_theDifferentLevels.TheDifferentLevels jws#
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class TheDifferentLevels extends Agent {
	
	private static List<Level> levels = Arrays.asList(
			Level.ALL , 
			Level.FINEST , 
			Level.FINER , 
			Level.FINE , 
			Level.CONFIG ,
			Level.INFO , 
			Level.WARNING , 
			Level.SEVERE , 
			Level.OFF);

	protected void activate() {
		pause(2000);
	}
	
	protected void live() {
		logger.talk("\n\t************************************\n" + 
						"\t   The different levels of display\n" +
						"\t************************************\n\n");
		pause(1000);
		if (logger != null){
			logger.talk("\n\nLog level = " + logger.getLevel() + " (default Level)\n");
			logger.severe("Default log level = " + logger.getLevel());
			logger.warning("Default log level = " + logger.getLevel());
			logger.info("Default log level = " + logger.getLevel());
			logger.config("Default log level = " + logger.getLevel());
			logger.fine("Default log level = " + logger.getLevel());
			logger.finer("Default log level = " + logger.getLevel());
			logger.finest("Default log level = " + logger.getLevel());
		}
		pause(2000);
		int i = 10;
		for (Level l : levels) {
			logger.talk("\n\nLog level --> " + l + "\n");
			setLogLevel(l);
			if (logger != null){
				logger.severe("severe message");
				logger.warning("warning message");
				logger.info("info message");
				logger.config("config message");
				logger.fine("fine message");
				logger.finer("finer message");
				logger.finest("finest message");
				pause(1000 * (i--));
			}
			else {
				System.out.println("This message is displayed thanks to System.out.println()\n" +
									"In fact with the log level OFF neither is displayed.\n");
				pause(2000);
			}
		}
		setLogLevel(Level.INFO);
		if (logger != null){
			logger.talk("\nThe loggger is set back to " + logger.getLevel() + "\n\n\n");
		}
		pause(1000);
	}
		
	protected void end() {
		if (logger != null)
			logger.info("Bye bye !");
		pause(5000);
	}

	public static void main(String[] args){
		executeThisAgent();
	}
}