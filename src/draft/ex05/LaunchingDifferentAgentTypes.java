package draft.ex05;

import madkit.kernel.Agent;

/**
 * Launching other kind of agents using executeThisAgent() is possible
 * using the madkit.kernel.Madkit.Option#launchAgents
 * 
 * 		#jws helloworld.ex05.LaunchingDifferentAgentTypes jws#
 */

public class LaunchingDifferentAgentTypes extends Agent {

    @Override
    protected void live() {
	getLogger().info("I am different from all the other agents you met before!");
	pause(10000); 
    }


    public static void main(String[] args) {
	executeThisAgent(2, true, "--launchAgents helloworld.ex03.ModifyingGUILocation,true,2");
	//or
	// executeThisAgent(2, true, Option.launchAgents.toString(),helloworld.ex03.ModifyingGUILocation.class.getName()+",2");
    }
}
