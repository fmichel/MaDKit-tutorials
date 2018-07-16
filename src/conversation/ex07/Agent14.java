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
package conversation.ex07;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * #jws conversation.ex07.broadcastMessageWithRoleAndWaitForReplies jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, agent14 sends a message to all the other agent11 using
 * 'broadcastMessageWithRoleAndWaitForReplies'
 * 
 * @author Boher Adrien.
 */

public class Agent14 extends Agent {

    /**
     * Firstly, take a position in the artificial society
     */
    @Override
    protected void activate() {

	getLogger().setLevel(Level.INFO);

	createGroupIfAbsent("communication", "GroupTest");
	requestRole("communication", "GroupTest", "RoleTest2");
	pause(500);

    }

    /**
     * Now, we use broadcast to send a message to all the other agents 13 and we wait for a reply
     */
    @Override
    protected void live() {

	// Sending a message at all the agent who have this role
	getLogger().info("\n\t I use broadcast and I wait for a reply \n\n");
	broadcastMessageWithRoleAndWaitForReplies("communication", "GroupTest", "RoleTest1", new Message(), "RoleTest2", 10000);
	getLogger().info("\n\t I have received all the replies \n\n");
	pause(5000);
    }

    /**
     * @param argss
     *            It will run five Agent13 and one Agent14.
     */
    public static void main(String[] argss)// Launching six agents, five Agent13 and one Agent14.
    {
	new Madkit("--launchAgents", Agent13.class.getName() + ",true,5;", Agent14.class.getName() + ",true,1;");
    }

    @Override
    public void setupFrame(AgentFrame frame) {
	super.setupFrame(frame);
	frame.setLocation(500, 100);
    }

}
