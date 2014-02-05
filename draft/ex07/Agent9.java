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
package communication.ex07;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex07.Agent9 jws#
 * 
 * Agent9 is answering Agent8, having a RoleTest9.
 */
@SuppressWarnings("serial")
public class Agent9 extends Agent
{
	final static public StringMessage PING = new StringMessage("ping");
	final static public StringMessage PONG = new StringMessage("pong");
	/* 
	 * Firstly, taking position in the artificial society (having a RoleTest9).
	 */
	protected void activate() 
	{	
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest9");
		pause(500);//Pausing 0.5sec to be sure displayed messages will appear in the right order.
	}
	/* 
	 * Setting where the agent's window will be.
	 */
	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(500,100);
		@SuppressWarnings("unused")
		int i = hashCode();
	}
	/* 
	 * When he gets "ping", Agent9 sends back "pong".
	 */
	protected void live()
	{
		Message incommingMessage = waitNextMessage();
		
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
			{		
				code = sendReply(incommingMessage,PONG);//sendReply sends "pong" as soon as Agent8 gets "ping".
			}
		pause(1500);
	 	while(nextMessage() != null);
		pause(3000);
	}
}