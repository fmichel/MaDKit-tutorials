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
package logging.ex02b_defaultLogLevel;


import madkit.kernel.Agent;

/**
 * 		So we can set the log level with setLogLevel() and we will see the
 * different existing levels in the next example. 
 * Here we go to see the method getLevel()
 * and see the default log level which is used in MaDKit.
 * 
 * 			#jws logging.ex02b_defaultLogLevel.TheDefaultLogLevel jws#
 * 
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class TheDefaultLogLevel extends Agent {
	
	@Override
	protected void live() {
		pause(2000);
		logger.info("The default log level is : "+ logger.getLevel());
		pause(8000);
	}

	public static void main(String[] args){
		executeThisAgent();
	}
}