package helloworld.ex03b;

import madkit.gui.AgentFrame;
import madkit.kernel.Agent;

/**

 By default, the GUI of an agent is placed in the center of the screen.
 So probably that the agents of the previous example were not visible at first sight...

 Let us change this default location by overriding the {@link #setupFrame} method, which
 allows to modify the default GUI's characteristics.

 First we import the AgentFrame class to Override one of its method : setupFrame(AgentFrame frame)

 Here, the trick is to use the hashCode() method to distinguish the agents.
 Indeed, each agent has a unique hashcode corresponding to their instantiation number.
 So one can use this hashcode to place similar agents at different locations.

 #jws# helloworld.ex04.ModifyingGUILocation #jws#
 #args# --launchAgents helloworld.ex04.ModifyingGUILocation,true,3 #args#

 */

public class LaunchingTwoAgentsB extends Agent {

    @Override
    protected void activate() {
	    getLogger().info("Hello, my name is "+getName());
    }

    @Override
    protected void live() {
        getLogger().info("Our GUI is managed !");
	    for (int i = 10; i > 0; i--) {
	        getLogger().info("Living... I will quit in " + i + " seconds");
	        pause(1000);
	    }
    }

    //We override the setupFrame method in the agent class to change the GUI position
    @Override
    public void setupFrame(AgentFrame frame) {
        super.setupFrame(frame);
        frame.setLocation(hashCode()*150, hashCode()*150);
    }

    public static void main(String[] args) {
	executeThisAgent(2, true);
    }
}
