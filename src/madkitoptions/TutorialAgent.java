/**
 * READ ME
 * 
 * This tutorial is about Madkit options. An option is a feature that may be specified or activate.
 * You can find more detail here : http://www.madkit.net/madkit/repository/MaDKit-5.2/docs/api/.
 * Madkit options are divided in three categories :
 *    - Boolean Options
 *    - Level Options  
 *    - Madkit Options
 *    
 * In this first set of examples, we will present you Boolean Options.
 * Among the others options, boolean options are either activated or not. 
 */

package madkitoptions;

import madkit.kernel.Agent;

/**
 * This class represents an agent that may be used for this tutorial.
 */

public class TutorialAgent extends Agent{

	@Override
	protected void activate() {
		pause(5000);
	}
	
	@Override
	protected void live() {
		getLogger().info("\n\t Hello ! I am an instance of Tutorial Agent.\t\n");
	}
}
