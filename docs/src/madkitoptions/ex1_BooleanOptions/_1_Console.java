/**
 * READ ME
 * 
 * This tutorial is about MaDKit options. An option is a feature that may be specified or activated.
 * You can find more details here : http://www.madkit.net/madkit/repository/MaDKit-5.2/docs/api/.
 * MaDKit options are divided in three categories :
 *    - Boolean Options
 *    - Level Options  
 *    - MaDKit Options
 *    
 * In this first set of examples, we will present you Boolean Options.
 * Among the others options, boolean options are either activated or not. 
 */

package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of the console option.
 * If this boolean option is set to true, the MaDKit console agent is launched.
 * The default value is false.
 * 
 *
 */

public class _1_Console {

	 public static void main(String[] args) {
		 
		 /* If no boolean is specified, MaDKit considers it as true */
		 new Madkit(Madkit.BooleanOption.console.toString()); /* Equivalent to : new Madkit(Madkit.BooleanOption.console.toString(), Boolean.TRUE.toString()); */
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.console.toString(), Boolean.FALSE.toString());
	 }
}
