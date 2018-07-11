/**
 * Now we will interest to other Options.
 * These features are no longer valued by boolean nor 
 * level but with a string. 
 */
package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;


/**
 * 
 * In this example we will discover how to
 * launch agents as soon as a new MaDKit is
 * launched. 
 * 
 * You may see that there is different ways of doing it,
 * that you can launch several agents, or even different 
 * types of agent.
 *
 * Feel free to uncomment the lines to test and 
 * understand the differences.
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._1_LaunchAgents #jws#
 * #args# #args#
 * 
 */

public class _1_LaunchAgents {

	public static void main(String[] args) {
				
		/** 
		 * If nothing else than the class name of the agent to launch is specified,
		 * MaDKit launch one agent of the precised class without graphical user interface (GUI)
		 */
		new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName());
		
		/* The previous line was equivalent to the next one. */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",false,1");
		
		/* You can decide whether or not the agent has a GUI. */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",true");
		
		/**
		 * You can also launch several agents by adding the number
		 * of wanted agents right after the class name.
		 */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",3");
		
		/* Let's launch several agents with a GUI. */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",true,2");
		
		/* Now, let's launch different kind of agents. */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ";" + Agent.class.getName());
		
		/**
		 * Finally, you can note that while launching several (and possibly different)
		 * agents you don't have to precise everything each time. In that case,
		 * default values will be used.
		 */
		// new Madkit(Madkit.Option.launchAgents.toString(),TutorialAgent.class.getName() + ",2;" + TutorialAgent.class.getName() + ",true,1;");
	}
}
