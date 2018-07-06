package helloworld.ex03;

import madkit.kernel.Agent;

/**

 By default {@link #executeThisAgent()} launches one agent with a GUI. 
 However, we can add parameters to launch more agents or add other options.
 
 Let us launch two similar agents by using executeThisAgent(int, boolean, String...).
 
		#jws# helloworld.ex03.LaunchingTwoAgents #jws#
  		#args# --launchAgents helloworld.ex03.LaunchingTwoAgents,true,2 #args#
 */

public class LaunchingTwoAgents extends Agent {

    @Override
    protected void activate() {
	getLogger().info("Hello, my name is "+getName());
	/*
	 The agent's default name is built using its class + its ID (instantiation number). 
	 Here the name should be LaunchingTwoAgents-02 and -03. 
	 This is because two agents were priorly launched: (0) The kernel agent & (1) The GUI manager
	*/
    }

    @Override
    protected void live() {
	for (int i = 10; i > 0; i--) {
	    getLogger().info("Living... I will quit in " + i + " seconds");
	    pause(1000); 
	}
    }

    public static void main(String[] args) {
	// the first parameter is the number of agents to launch
	// the second specifies if a GUI should be installed or not for the agents
	executeThisAgent(2, true);
    }
}
