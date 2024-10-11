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
package logging.ex01c_levels;

import java.util.logging.Level;

import madkit.kernel.Agent;

/**
 * We have seen how to log a message but it exists several ways to do it. So we will see another way to associate
 * different levels to messages and one of messages will not display at the screen. Here we show another method for
 * logging a message: Logger#log(Level, String). During the life of this agent, four messages are logged : two 'info'
 * messages and two 'config' messages. The last two will not be displayed. The next example of this tutorial explains
 * why...
 * 
 * 
 * 
 * 
 * 
 * @author Pascal Wagner
 */

public class MessageWithLevel extends Agent {

    @Override
    protected void live() {
	Level infoLevel = Level.INFO;
	Level configLevel = Level.CONFIG;
	String infoMessage = "This is an info message.";
	String configMessage = "This is a config message.";
	pause(2000);
	getLogger().info(infoMessage);
	pause(3000);
	getLogger().log(infoLevel, infoMessage + "\n\nThe two next config messages will not display at the screen.");
	pause(3000);
	getLogger().config(infoMessage);
	getLogger().log(configLevel, configMessage);
	pause(3000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}
