package helloworld.ex04;

import madkit.kernel.Agent;
import madkit.kernel.Madkit.BooleanOption;

/**
  If you used Java web start and did not open its console, 
  maybe that you did not see anything in the previous example as the agents were launched without a GUI.
  
  executeThisAgent(int, boolean, String...) can also take 
  additional parameters, especially MaDKit options such as 
  specified in the madkit.kernel.Madkit.BooleanOption enumeration.
  
  Let us add the BooleanOption#console option to request the launching of the madkit.gui.ConsoleAgent,
  which is a specific agent embedded that gathers all System.out outputs
  in its own GUI, so that we can also see the outputs of agents that have no GUI.
  
  		#jws# helloworld.ex05.AddingParametersToExecuteThisAgent #jws#
  		#args# --console --launchAgents helloworld.ex05.AddingParametersToExecuteThisAgent,false,3 #args#
  
 */

public class AddingParametersToExecuteThisAgent extends Agent {

    @Override
    protected void live() {
	int nb = 10;
	while (nb-- > 0) {
	    getLogger().info("Living... I will quit in " + nb + " seconds");
	    pause(1000);
	}
	getLogger().info("Bye !!");
    }

    public static void main(String[] args) {
	executeThisAgent(3, false, BooleanOption.console.toString());
	// which is strictly equivalent to 
	// executeThisAgent(3, false, "--console");
    }
}
