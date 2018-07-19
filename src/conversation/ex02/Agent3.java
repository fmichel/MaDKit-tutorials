/*
 * Copyright 2011-2017 Fabien Michel
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
package conversation.ex02;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * Agent3 works with Agent4, using a different role.
 * 
 * #jws conversation.ex02.sendReply2 jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, two agents are replying the other one.
 */

public class Agent3 extends Agent {

    /**
     * Firstly, take a position in the artificial society
     */
    @Override
    protected void activate() {

	getLogger().setLevel(Level.INFO);

	createGroupIfAbsent("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest1");
	pause(500);

    }

    /**
     * Now we wait a message, after the reception we reply and we wait for a reply
     */
    @Override
    protected void live() {

	// waiting other's message
	Message receivedMessage = waitNextMessage();
	Message repliedMessage = new Message();

	getLogger().info("\n\t I received something !! \n\t I reply ! \n " + receivedMessage.getSender() + "\n\n");
	pause(1000);
	// Replying and wait for a reply
	sendReplyAndWaitForReply(receivedMessage, repliedMessage);

	getLogger().info("\n\t He replied !! \n " + receivedMessage.getSender() + "\n\n");
	pause(10000);
	pause(10000);
    }

    /*
     * Setting where the agent's window will be for a clear presentation.
     */

    @Override
    public void setupFrame(AgentFrame frame) {
	super.setupFrame(frame);
	frame.setLocation(100, 350 * (hashCode() - 2));
    }

}
