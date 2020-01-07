/*
 *Copyright 2011-2017 Fabien Michel
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
import madkit.kernel.AgentAddress;
import madkit.kernel.ConversationID;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * #jws conversation.ex05.Agent8 jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, two agents are sending a message to the other one, we will see the difference
 * between sendMessage and SendReply.
 */

public class Agent8 extends Agent {

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
     * Now we send a message to an agent,we wait the reply and we check if he has used "reply" or "send"
     */
    @Override
    protected void live() {
	AgentAddress other = null;
	while (other == null) {
	    other = getAgentWithRole("communication", "GroupTest", "RoleTest1");
	    pause(1000);
	}

	getLogger().info("\n\t I found someone !! \n\t I send a message \n " + other + "\n\n");
	pause(1000);
	// Sending a message
	Message firstMessage = new Message();
	sendMessage(other, firstMessage);
	// Waiting message
	Message repliedMessage = waitNextMessage();

	getLogger().info("\n\t I received something!! \n ");
	pause(1000);
	// We take the conversationID of the firstMessage send and the receivedMessage
	ConversationID idFirstMessage = firstMessage.getConversationID();
	ConversationID idRepliedMessage = repliedMessage.getConversationID();
	// If it's a reply,both messages will have the same id so this message will be logged
	if (idFirstMessage.equals(idRepliedMessage)) {
	    getLogger().info("\n\t It's the same conversationId because it's a reply!!! \n");
	    getLogger().info("\n\t idFirstMessage =" + idFirstMessage + "\n\t idRepliedMessage =" + idRepliedMessage + "\n\n");
	}
	else {
	    getLogger().info("\n\t It's not the same conversationId because it's not a reply!!! \n");
	    getLogger().info("\n\t idFirstMessage =" + idFirstMessage + "\n\t idRepliedMessage =" + idRepliedMessage + "\n\n");
	}

	pause(10000);
    }

    /**
     * @param argss
     *            It will run one Agent7 and one Agent8.
     */
    public static void main(String[] argss)// Launching two agents, Agent7 and Agent8.
    {
	new Madkit("--launchAgents", Agent7.class.getName() + ",true,1;", Agent8.class.getName() + ",true,1;");
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
