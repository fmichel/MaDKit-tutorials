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
 */
package communication.ex06;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

import communication.ex06.Agent7;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex06.Agent6 jws#
 * 
 * Agent6 won't get an agent address, 
 * he will send him a message using sendMessageWithRole. 
 * @author Authors ARAGON Joseph and WAGNER Pascal. 
 */
@SuppressWarnings("serial")
public class Agent6 extends Agent 
{
	/* 
	 * Firstly, taking position in the artificial society (having a RoleTest6).
	 */
	protected void activate()
	{
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest6");
		pause(500);
	}

	/** 
	 * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
	 */
	protected void live()
	{
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the message.
		{		
			//Sending a message to an Agent having a RoleTest7 Specifying Agent6's role.
			code = sendMessageWithRole("communication", "GroupTest", "RoleTest7", new Message(), "RoleTest6");
			pause(3000);
		}
	 	while(nextMessage() != null)
	 		pause(6000);
	}	
	
	/**
	 * @param argss
	 * It will run one Agent6 and one Agent7.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] argss)//Launching two agents, Agent6 and Agent7.
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent6.class.getName() + ",true,1;" ,
				Agent7.class.getName() + ",true,1;"
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