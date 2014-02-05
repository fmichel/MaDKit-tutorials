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
import madkit.kernel.Madkit.Option;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex05.Agent4 jws#
 * 
 * Agent4 will get an agent's address, and then send his message using sendMessageWithRole. 
 */
@SuppressWarnings("serial")
public class Agent4 extends Agent
{
	/**
	 * Firstly, taking position in the artificial society (having a RoleTest4).
	 */
	protected void activate()
	{
		setLogLevel(Level.FINEST);

		createGroup("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest4");
		pause(500);
	}

	protected void live()
	{
		AgentAddress other = null;//other will contain the Agent's address.
		while(other == null)//Until we found an Agent having "("communication","GroupTest","RoleTest4")".
		{
			other = getAgentWithRole("communication","GroupTest","RoleTest4");
			pause(1000);
			
			if (other == null)//Or an Agent having "("communication","GroupTest","RoleTest5")".
			{
				other = getAgentWithRole("communication","GroupTest","RoleTest5");
			}
			pause(1000);
		}
		if(logger != null)//If the display level isn't at null (Logger).
			logger.info("\n\tI found someone !!\n"+other+"\n\n");//Displaying our Agent properties (the one we founded).
		pause(1000);
		
	 	sendMessageWithRole(other, new Message(), "RoleTest4");//Sending the message specifying the sender's role.
	 	
	 	while(nextMessage() != null)
	 		pause(6000);
	}
	/**
	 * @param argss
	 * Running Agent4 will launch 2 Agent4.
	 */
	public static void main(String[] argss)//Launching two Agent4.
	{
		new Madkit 
			( 
				Option.launchAgents.toString(),
				Agent4.class.getName() + ",true,2;"
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