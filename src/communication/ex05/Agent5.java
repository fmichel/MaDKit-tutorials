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
 * 
 * Authors ARAGON Joseph and WAGNER Pascal. 
 */
package communication.ex05;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex05.Agent5 jws#
 * 
 * Agent5 is almost like Agent4, the only difference is their roles.
 */
@SuppressWarnings("serial")
public class Agent5 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a RoleTest5).
	 */
	protected void activate()
	{
		setLogLevel(Level.FINEST);

		createGroup("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest5");
		pause(500);
	}

	/* 
	 *First getting an Agent address, and then sending him a message. 
	 */
	protected void live()//In this live period, Agent5 is doing exactly the same as Agent4, with a different role (RoleTest5).
	{
		AgentAddress other = null;
		while(other == null)
		{
			other = getAgentWithRole("communication","GroupTest","RoleTest4");
			pause(1000);
		}
		
		if(logger != null)
			logger.info("\n\tI found someone !!\n"+other+"\n\n");
		pause(1000);
		
	 	sendMessageWithRole(other, new Message(), "RoleTest5");
	 	
	 	while(nextMessage() != null)
	 		pause(6000);
	}
	/**
	 * @param argss
	 * Launching one Agent4 and one Agent 5.
	 */
	public static void main(String[] argss) 
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent4.class.getName() + ",true,1;" ,
				Agent5.class.getName() + ",true,1;" 
			);
	}
	
	/* 
	 * Setting where the agent's window will be
	 * for a clear presentation.
	 */
	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(100,350 * (hashCode()-2));
	}
}
