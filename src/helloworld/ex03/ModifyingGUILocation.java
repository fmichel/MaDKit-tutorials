package helloworld.ex03;

import madkit.gui.AgentFrame;

/**
  
  By default, the GUI of an agent is placed in the center of the screen.
  So probably that the agents of the previous example were not visible at first sight...
  
  Let us change this default location by overriding the {@link #setupFrame(AgentFrame)} method, which
  allows to modify the default GUI's characteristics. 
  
  Here, the trick is to use the hashCode() method to distinguish the agents.
  Indeed, each agent has a unique hashcode corresponding to their instantiation number.
  So one can use this hashcode to place similar agents at different locations.
  
  			#jws# helloworld.ex03.ModifyingGUILocation #jws#
  			#args# --launchAgents helloworld.ex03.ModifyingGUILocation,true,3 #args#
 */

public class ModifyingGUILocation extends LaunchingTwoAgents {
    
    @Override
    public void setupFrame(AgentFrame frame) {
        super.setupFrame(frame);
        frame.setLocation(hashCode()*150, hashCode()*150);
    }

    public static void main(String[] args) {
	executeThisAgent(3, true);
    }
}
