/*
 * Copyright 2011-2017 Fabien Michel
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
package logging.ex02a_introLogLevel;

import java.util.logging.Level;

import madkit.kernel.Agent;

/**
 * In the last example, two messages have not been displayed, not because of a mistake in the code but because of their
 * level. Indeed, messages are displayed according to the current level of the getLogger(). So the logger acts as a
 * filter on the message which are logged: For being logged the message's level has to be higher than the logger's
 * level. The idea is that you can have different setting for the logger so that you can have different output modes for
 * your agent: From quiet (OFF) to verbose (ALL). The logger's level can be modified with the method
 * getLogger().setLevel(). Here, we log a config message and an info message but the first one will not be displayed.
 * Then the logger's level is changed so that 'config' messages will appear.
 * 
 * 
 * 
 * 
 * @author Pascal Wager
 */

public class LogLevel extends Agent {

    @Override
    protected void live() {
	pause(2000);
	getLogger().info("There are two log records but the second will not be displayed.\n");
	getLogger().config("The logger's level is too low to display this message.");
	pause(4000);

	getLogger().setLevel(Level.CONFIG);

	getLogger().info("The logger's level has been set to " + Level.CONFIG);
	pause(3000);
	getLogger().config("So now the config messages can appear\non the screen!");
	pause(8000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}