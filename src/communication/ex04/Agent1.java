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
package communication.ex04;

import java.util.logging.Level;

import javax.naming.ldap.HasControls;
import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;
import madkit.kernel.Madkit;
import madkit.kernel.Message;
import communication.ex04.Agent2;

/**
 * Shows how agents exchange messages.
 * 
 * #jws communication.ex04.Agent1 jws#
 * 
 * To exchange messages, agents have to exist in an artificial society.
 * That is, agents have to create communities containing groups and
 * take roles within to interact with others.
 * Doing so, agents get agent addresses which could be used to send them messages.
 * Here, one agent (Agent1) is communicating with another agent (Agent2)
 * by getting its agent address in the artificial society and using it with sendMessage.
 */
@SuppressWarnings("serial")
public class Agent1 extends Agent {

	/*
	 * Firstly, take a position in the artificial society.
	 */
	protected void activate() {
		setLogLevel(Level.FINEST);

		createGroup("communication", "GroupTest");// Create the group GroupTest in the community communication.
		requestRole("communication", "GroupTest", "RoleTest1");// Request the role RoleTest1.
		pause(500);
	}

	/*
	 * First getting an Agent address, and then sending him a message.
	 */
	protected void live() {
		AgentAddress other = null;
		// Until we have an agent (in the group GroupTest in the community communication) having the role RoleTest2.
		while (other == null) {
			// Getting the address of an agent being in the community "communication" and the group "GroupTest", and having the role "RoleTest2".
			other = getAgentWithRole("communication", "GroupTest", "RoleTest2");

			// Trying to get another agent (Agent3).
			if (other == null) {
				other = getAgentWithRole("communication", "GroupTest", "RoleTest3");
			}
			pause(1000);
		}
		if (logger != null)// cf. logging.ex01
			logger.info("\n\tI found someone !!\n" + other + "\n\n");
		pause(1000);

		sendMessage(other, new Message());// Sending the message to the agent we found.
		pause(1000);

		while (nextMessage() != null)
			pause(6000);
	}

	/**
	 * @param argss
	 *           Running Agent1 will launch 2 instances of both Agent1 and Agent2.
	 *           They will send themselves 1 message.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] argss) {
		new Madkit(
				"--launchAgents", 
				Agent1.class.getName() + ",true,2;", Agent2.class.getName() + ",true,2;");
	}

	/*
	 * Setting where the agent's window will be
	 * for a clear presentation.
	 */
	public void setupFrame(JFrame frame) {
		super.setupFrame(frame);
		frame.setLocation(100, 320 * (hashCode() - 2));
	}
}