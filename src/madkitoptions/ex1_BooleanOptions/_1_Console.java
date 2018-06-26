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

package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of console's option.
 * If this boolean option is set to true, the MaDKit console agent is launched.
 * The default value is false.
 * 
 * #jws madkitoptions.ex1_BooleanOptions._1_Console jws#
 *
 */

public class _1_Console {

	 public static void main(String[] args) {
		 
		 /* If no boolean is specified, MaDKit considers it as true */
		 new Madkit(Madkit.BooleanOption.console.toString()); /* Equivalent to : new Madkit(Madkit.BooleanOption.console.toString(), "true"); */
		 
		 /* Check the difference by commenting the previous line and decommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.console.toString(), "false");
	 }
}
