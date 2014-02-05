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
package communication.ex03_replyingToMessages;

import static communication.ex01.Society.COMMUNITY;
import static communication.ex01.Society.GROUP;
import static communication.ex01.Society.ROLE;
import madkit.kernel.Madkit;
import madkit.kernel.Message;
import madkit.message.StringMessage;

import communication.ex01.PingAgent;

/**
 * Shows how agents exchange messages by targeting roles.
 * 
 * 		#jws communication.ex03_replyingToMessages.ReplierAgent jws#
 * 
 * Receiving a message, you can learn information about the
 * sender. This is illustrated firstly in this example.
 * 
 * Sometimes, agents need to communicate by replying
 * to messages. There are primitives for that and they have two advantages.
 * (1) This will identify the message as being a concrete reply to the received message
 * thus easing the programming of protocols for instance.
 * (2) This greatly improves code legibility 
 * 
 */
@SuppressWarnings("serial")
public class ReplierAgent extends PingAgent {//So I do the same activate

	@Override
	protected void live() {

		// until I found someone having that role
		while (sendMessage(COMMUNITY, GROUP, ROLE, new Message()) != ReturnCode.SUCCESS) {
			pause((int) (Math.random() * 1000 + 100));
		}

		Message m = nextMessage();
		if (m != null) {
			if (logger != null)
				logger.info("I have to thank " + m.getSender());
			sendReply(m, new StringMessage("thanks"));
		}
		pause(10000);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Madkit("--launchAgents",
				ReplierAgent.class.getName() + ",true,10;", 
				PingAgent.class.getName()//This one so that agents always find someone (breaking the first while)
				);
	}

}
