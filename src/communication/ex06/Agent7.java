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
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * As in previous examples, Agent7 is doing the same job as Agent6, having a RoleTest7.
 * 
 * @author Authors ARAGON Joseph and WAGNER Pascal. 
 */
@SuppressWarnings("serial")
public class Agent7 extends Agent
{

	protected void activate()
	{
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest7");
		pause(500);
	}
	
	/* 
	 * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
	 */
	protected void live()
	{
		ReturnCode code = null;
		
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication", "GroupTest", "RoleTest6", new Message(), "RoleTest7");
			pause(2000);
		}
	 	while(nextMessage() != null)
	 		pause(6000);
	}

	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(500,100);
	}
}
	
