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
package communication.ex02_targetingRoles;

import static communication.ex01.Society.COMMUNITY;
import static communication.ex01.Society.GROUP;
import static communication.ex01.Society.ROLE;
import madkit.kernel.Madkit;
import madkit.kernel.Message;

import communication.ex01.PingAgent;

/**
 * Shows how agents exchange messages by targeting roles.
 * 
 * 		#jws communication.ex02_targetingRoles.PingAgent2 jws#
 * 
 * Looking for someone, agents do not necessarily 
 * need to know who they talk to in terms of real ID.
 * Indeed, what matters in the artificial society is the roles
 * an agent take. Roles tells a lot about what the agent is capable of
 * and what it is supposed to do. So, agents can send messages to roles
 * rather than to IDs. 
 * 
 * Here, the idea is: I need to contact a "ping agent", no matter who
 * receive the message. And it is possible to do so using what follows
 * 
 */
@SuppressWarnings("serial")
public class PingAgent2 extends PingAgent {//So I do the same activate

	/**
	 * Now ping another agent, just by targeting the role
	 */
	@Override
	protected void live() {
		
		ReturnCode code = null;
		
		//until I find someone having role
		while(code != ReturnCode.SUCCESS){
			//This will randomly choose a receiver having this role
			code = sendMessage(COMMUNITY, GROUP, ROLE, new Message());
			pause((int) (Math.random()*1000+100));
		}
		
		//just a way to purge the mailbox and log what I received
		while(nextMessage() != null);
		pause(10000);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Madkit("--launchAgents",
				PingAgent2.class.getName() + ",true,10;", 
				PingAgent.class.getName()//This one so that PingAgent2 agents always find someone (breaking the first while)
				);
	}

}
