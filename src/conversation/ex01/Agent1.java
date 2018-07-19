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
package conversation.ex01;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * Agent1 works with Agent2, using a different role.
 * 
 * #jws conversation.ex01.sendReply jws#
 * 
 * To interact with others agents, agents need a form of communication. Doing so,the agents have MailBox, they can used
 * it to receive and send messages. Here, two agents are communicating using reply.
 */

public class Agent1 extends Agent {

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
     * Now we wait a message, when we receive one we reply to this message
     */
    @Override
    protected void live() {

	// waiting other's message
	Message receivedMessage = waitNextMessage();

	getLogger().info("\n\t I receive something !! \n\t I reply ! \n " + receivedMessage.getSender() + "\n\n");

	Message repliedMessage = new Message();

	// we reply using sendReply
	sendReply(receivedMessage, repliedMessage);

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