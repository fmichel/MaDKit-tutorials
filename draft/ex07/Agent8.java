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
import madkit.kernel.Madkit;
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex07.Agent8 jws#
 * 
 * This example is a bit more complicated, 
 * here two agents are sending messages and waiting a reply before sending another message.
 */
@SuppressWarnings("serial")
public class Agent8 extends Agent//Agent8 sends PING (as a message),
								//then Agent9 gets it (PONG), he sends back PONG,
								//Agent8 gets PONG and sends PING once last time.
{
	final static public StringMessage PING = new StringMessage("ping");
	final static public StringMessage PONG = new StringMessage("pong");

	protected void activate() 
	{
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");//Does not produce a warning if the group already exists.
		requestRole("communication","GroupTest","RoleTest8");
	}
	/* 
	 * Setting where the agent's window will be.
	 */
	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(100,100);
		@SuppressWarnings("unused")
		int i = hashCode();
	}
	/* 
	 * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
	 * Then, wait a message.
	 * And once he gets the message, he sends back his last message.
	 */
	protected void live()
	{
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending "ping" to an Agent having a RoleTest9 specifying Agent8's role.
		{		
			code = sendMessageWithRole("communication", "GroupTest", "RoleTest9", PING, "RoleTest8");
			pause(100);//Waiting: if sendMessageWithRole fails, because Agent9 isn't ready yet.
		}
		pause(1500);
		Message incommingMessage = waitNextMessage();//Waiting to get a message.
		code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
		{		
			code = sendReply(incommingMessage,PING);//sendReply sends "ping" as soon as Agent8 gets "pong".
		}
		pause(1500);
		while(nextMessage() != null);
		pause(3000);
	}
	/**
	 * @param argss
	 * It will run one Agent8 and one Agent9.
	 */
	public static void main(String[] argss) 
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent8.class.getName() + ",true,1;" ,
				Agent9.class.getName() + ",true,1;"
			);
	}
}