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
package logging.ex03a_levelFinerFinest;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 *  You have surely noticed that some additional finer and finest messages 
 *  appeared in the console in the last example
 *  while they did not appear in the code. In fact, finest messages are used to log many 
 *  of the agent methods defined in MaDKit. And the agent's life cycle is traced 
 *  at the finer level. So, setting the logger's level 
 *  to finer, finest or all represents a very easy way of debugging MaDKit agents !
 *  
 *  Here, we just set the logger's level to all to show that there are log messages
 *  which are displayed whereas there is no explicit code here.
 *  notes : - agent's life is composed by the methods : activate(), live() and end().
 *  		- the different pauses are only there for you to see the agent's life cycle.
 * 
 * 			#jws logging.ex03a_levelFinerFinest.LevelFinerFinest jws#
 * 
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class LevelFinerFinest extends Agent {
	
	@Override
	protected void activate() {
		setLogLevel(Level.ALL);
		pause(5000);
	}

	@Override
	protected void live() {
		Message m = nextMessage();
		pause(5000);
	}
	
	@Override
	protected void end() {
		pause(5000);
	}
	
	public static void main(String[] args){
		executeThisAgent();
	}
}