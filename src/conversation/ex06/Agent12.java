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
package conversation.ex06;

import java.util.logging.Level;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

/**
 * Shows how agents exchange messages.
 * 
 * #jws conversation.ex06.broadcastMessage jws#
 * 
 * To interact with other agents, agents need a form of communication. Doing so,the agents have MailBox, they can use it
 * to receive and send messages. Here, agent12 sends a message to all the other agent11 using 'broadcastMessage'
 * 
 * @author Boher Adrien.
 */

public class Agent12 extends Agent {

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
     * Now, we use broadcast to send a message to all the other agents 11
     */
    @Override
    protected void live() {

	ReturnCode code = null;
	pause(2000);
	while (code != ReturnCode.SUCCESS) {
	    // Sending a message to all the agents who have this role
	    code = broadcastMessage("communication", "GroupTest", "RoleTest1", new Message());
	}
	getLogger().info("\n\t I use broadcastMessage !! \n\n");
	pause(10000);
    }

    /**
     * @param argss
     *            It will run five Agent11 and one Agent12.
     */
    public static void main(String[] argss)// Launching six agents,five Agent11 and one Agent12.
    {
	new Madkit("--launchAgents", Agent11.class.getName() + ",true,5;", Agent12.class.getName() + ",true,1;");
    }

    @Override
    public void setupFrame(AgentFrame frame) {
	super.setupFrame(frame);
	frame.setLocation(500, 100);
    }

}