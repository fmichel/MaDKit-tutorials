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
package communication.ex04;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Agent2 works as Agent1, using a different role.
 *  
 * 		#jws communication.ex04.Agent1 jws#
 *
 * Agent2 is almost like Agent1, the only difference is the role and frame's location.
 */
@SuppressWarnings("serial")
public class Agent2 extends Agent 
{

	protected void activate() 
	{
		setLogLevel(Level.FINEST);

		createGroup("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest2");
		pause(500);
	}
	
	protected void live() 
	{			
		AgentAddress other = null;
		while(other == null)
		{
			other = getAgentWithRole("communication","GroupTest","RoleTest1");
			pause(1000);
		}			
		if(logger != null)
			logger.info("\n\tI found someone !!\n"+other+"\n\n");
		pause(1000);
	
		sendMessage(other, new Message());
		pause(1000);
			
		while(nextMessage() != null)
			pause(6000);
	}
	
	/**
	 * Will launch 2 instances of both Agent1 and Agent2.
	 * They will send themselves 1 message.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] argss)
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent1.class.getName() + ",true,2;" ,
				Agent2.class.getName() + ",true,2;"
			);
	}

	/* 
	 * Setting where the agent's window will be.
	 */
	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(550,350 * (hashCode()-4));
	}
}
