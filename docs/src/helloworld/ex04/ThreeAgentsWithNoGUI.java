package helloworld.ex04;

import madkit.kernel.Agent;

/**
  
  Let us try executeThisAgent(int, boolean, String...) with no GUI for the agents.
  
  
 */

public class ThreeAgentsWithNoGUI extends Agent {

    @Override
    protected void live() {
	for (int i = 10; i > 0; i--) {
	    getLogger().info("Living... I will quit in " + i + " seconds");
	    pause(1000); // pauses the agent's thread for 1000 ms
	}
	getLogger().info("Bye !!");
    }

    public static void main(String[] args) {
	// the first parameter is the number of agents to launch
	// the second specifies if a GUI should installed or not for the agents -> no GUI here
	executeThisAgent(3, false);
    }
}
