package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/** //DEPRECIE ?????
 * This class exemplifies the use of cgrWarnings's option.
 * If this boolean option is set to true, a MaDKit console is launched.
 * The default value is false.
 * 
 * #jws madkitoptions.ex1_BooleanOptions._2_CgrWarnings jws#
 *
 */

public class _2_CgrWarnings {
	
	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.cgrWarnings.toString(),"true", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		 
		 /* Check the difference by commenting the previous line and decommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.cgrWarnings.toString(), Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
	 }
}
