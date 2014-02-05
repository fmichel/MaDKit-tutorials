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
package logging.ex01b_levels;

import madkit.kernel.Agent;

/**
 * The main advantage of using the Logger class is that all messages
 * are associated with a level. Indeed, depending on the logging method used,
 * a message will have a particular level. 
 * This level will have an impact on how the message is displayed.
 * 
 * In this example, we will log two messages with different levels. You will
 * observe that the messages are preceded by their own log level. 
 * 
 * #jws logging.ex01b_levels.LevelMessage jws#
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class LevelMessage extends Agent {

	@Override
	protected void live() {
		pause(2000);
		logger.info("This is a message which has a level 'info'.");
		pause(3000);
		logger.warning("This is a message which has a level 'warning'.");
		pause(5000);
	}

	public static void main(String[] args) {
		executeThisAgent();
	}
}
