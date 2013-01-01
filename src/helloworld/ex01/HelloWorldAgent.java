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

package helloworld.ex01;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * A simple agent, having a default GUI, and that lives 10 seconds and quit.
 * 
 * 				#jws helloworld.ex01.HelloWorldAgent jws#
 * 
 * 
 * Here we just:
 * 	1. extend the madkit.kernel.Agent class 
 * 	2. override key methods (each being optional):
 * 
 * - activate: the first behavior in the life cycle of an agent.
 * It could be considered as a constructor which is called once the
 * agent is launched, so that it can use agent primitives.
 * It will be a good place to initialize the agent's position in the artificial society.
 * 
 * - live: this behavior is automatically called when the agent exits the activate method.
 * Usually it implements a infinite loop as it corresponds to the life of the agent.
 * 
 * - end: this behavior is automatically called when live exits or when the agent is killed.
 * Usually it is used to release resources and log the end of life event.
 * 
 * The default name of the agent is the name of the class + the ID of the agent which
 * corresponds to an instantiation number.
 * Here the name should be HelloWorldAgent-02.
 * This is because there are always
 * two agents priorly launched: 
 * 	- Agent-0: The kernel agent
 * 	- Agent-1: The GUI manager
 * 
 */
@SuppressWarnings("serial")
public class HelloWorldAgent extends Agent {

	/**
	 * This is the first activated behavior in the life cycle of a MaDKit agent.
	 * 
	 */
	@Override
	protected void activate() {
		// Agent can use their logger attribute to display messages in both console and GUI
		// Later we will see the advantages of using this instead of System.err.println();
		if (logger != null)
			logger.info("\tHello World !!\n\n\tI am activating...\n");

		// This primitive pauses the agent's thread for 2000 ms
		pause(2000);
	}

	/**
	 * This is the second behavior which is activated, i.e. when activate ends.
	 * It actually implements the life of the agent.
	 * It is usually a while true loop.
	 * Here the agent lives 10 seconds and quits.
	 * 
	 */
	@Override
	protected void live() {
		int nb = 10;
		while (nb-- > 0) {
			if (logger != null)
				logger.info("Living... I will quit in " + nb + " seconds");
			pause(1000);
		}
	}

	/**
	 * This behavior is called when the agent has finished its live behavior.
	 * Because there is no other agent, MaDKit quits when the agent is terminated.
	 * 
	 */
	@Override
	protected void end() {
		if (logger != null)
			logger.info("Bye bye !");
		pause(2000);
	}

	/**
	 * Now we have to start this agent one way or another.
	 * 
	 * Implementing a main method is not required at all but it could be used
	 * to simulate a command line call to MaDKit with the desired options inside
	 * an IDE. Such a command line would be (assuming a good classpath):
	 * 
	 * 	> java madkit.kernel.MaDKit --launchAgents helloworld.ex01.HelloWorldAgent,true
	 * 
	 * @param args unused here
	 */
	public static void main(String[] args) {
		String[] args2 = { "--launchAgents",
				"helloworld.ex01.HelloWorldAgent,true" }; // This agent with GUI
		Madkit.main(args2);

	}
	/*
	 * What we used here is exactly the same :
	 * 
	 * String[] argss = {Madkit.Option.launchAgents.toString(),HelloWorldAgent.class.getName()+",true"};
	 * Madkit.main(argss);
	 * 
	 * 
	 * which in turn is exactly the same as :
	 * 
	 * executeThisAgent(); //just a convenient way of launching one instance of this agent
	 */

}
