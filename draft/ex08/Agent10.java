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
package communication.ex08;

import java.util.logging.Level;
import javax.swing.JFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.message.StringMessage;;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex08.Agent10 jws#
 * 
 */
@SuppressWarnings("serial")
public class Agent10 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a GroupA and a MultiGroupRole).
	 */
	protected void activate() 
	{	
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupA");
		requestRole("communication","GroupA","MultiGroupRole");
		pause(500);
	}
	
	/* 
	 * Now our Agent will request roles to send messages in several groups
	 */
	@Override
	protected void live()
	{
		pause(1000);//Waiting other agents to be ready.
		logger.info("Request GroupB.");
		ReturnCode code = null;
		requestRole("communication","GroupB","MultiGroupRole");//First sending a message to an agent in the GroupB.
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupB","ReplyRole",new StringMessage("One"),"MultiGroupRole");
			pause(100);
		}
		logger.info("Waiting reply.");
		waitNextMessage();//Waiting a reply ("Two").
		pause(1500);
		logger.info("Request GroupC.");
		code = null;
		requestRole("communication","GroupC","MultiGroupRole");//Sending a message to an agent in the GroupC.
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupC","ReplyRole",new StringMessage("Three"),"MultiGroupRole");
			pause(100);
		}
		logger.info("Waiting reply.");
		waitNextMessage();//Waiting a reply ("Three").
		pause(1500);
		logger.info("Request GroupD.");
		code = null;
		requestRole("communication","GroupD","MultiGroupRole");//Sending a message, than broadcasting a message in the GroupD.
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupD","ReplyRole",new StringMessage("SingleMessage"),"MultiGroupRole");//Sending the single message.
			pause(100);
		}
		logger.info("Waiting reply.");
		waitNextMessage();
		pause(1500);
		code = null;
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = broadcastMessage("communication","GroupD","ReplyRole",new StringMessage("BroadcastMessage"));//Broadcasting.
			pause(100);
		}
		
	 	while(nextMessage() != null)
	 		pause(5000);
	}
	
	public static void main(String[] argss) 
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent10.class.getName() + ",true,1;" ,
				Agent11.class.getName() + ",true,1;" ,
				Agent12.class.getName() + ",true,1;" ,
				Agent13.class.getName() + ",true,5;" 
			);
	}

	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(400,0);
	}	
}