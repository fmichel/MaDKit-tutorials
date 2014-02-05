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
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		#jws communication.ex08.Agent12 jws#
 * 
 */
@SuppressWarnings("serial")
public class Agent12 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a GroupA and a Role1).
	 */
	protected void activate() 
	{	
		setLogLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupC");
		requestRole("communication","GroupC","ReplyRole");
	}
	
	/* 
	 * Now replying to Agent10
	 */
	protected void live()
	{
		Message incommingMessage = waitNextMessage();
		
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
			{		
				code = sendReplyWithRole(incommingMessage,new StringMessage("Four"), "ReplyRole");
			}
		logger.info("I just sent the "+incommingMessage.toString());
		pause(3000);
	 	while(nextMessage() != null)
	 		pause(3000);
	}

	public void setupFrame(JFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(400,300);
	}	
}