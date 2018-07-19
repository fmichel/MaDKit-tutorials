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

package conversation.ex05;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.message.XMLMessage;

/**
 * Shows how agents exchange messages.
 * 
 * #jws conversation.ex05.Agent10 jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, agent10 sends a message containing a string.
 */

public class Agent10 extends Agent {

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
     * Now we send a XMLMessage to another Agent
     */
    @Override
    protected void live() {
	AgentAddress other = null;
	while (other == null) {
	    other = getAgentWithRole("communication", "GroupTest", "RoleTest1");
	    pause(1000);
	}
	getLogger().info("\n\t I found someone !! \n\t I send a \" Hello World \" \n\n");
	pause(1000);
	// Sending XMLMessage
	XMLMessage firstMessage = new XMLMessage("Hello World");
	sendMessage(other, firstMessage);

	pause(10000);

    }

    /**
     * @param argss
     *            It will run one Agent9 and one Agent10.
     */
    public static void main(String[] argss)// Launching two agents, Agent9 and Agent10.
    {
	new Madkit("--launchAgents", Agent9.class.getName() + ",true,1;", Agent10.class.getName() + ",true,1;");
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
