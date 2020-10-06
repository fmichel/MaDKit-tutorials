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
package conversation.ex04;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * Agent7 works with Agent8, using a different role.
 * 
 * #jws conversation.ex05.Agent8 jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, two agents are sending a message to the other one, we will see the difference
 * between sendMessage and SendReply.
 */

public class Agent7 extends Agent {

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
     * Now we wait a message to reply using "sendMessage"
     */
    @Override
    protected void live() {

	// waiting other's message
	Message receivedMessage = waitNextMessage();

	getLogger().info("\n\t I received something !! \n\t I send a message without using reply ! \n\n");
	pause(1000);
	// Sending a message
	sendMessage(receivedMessage.getSender(), new Message());
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
