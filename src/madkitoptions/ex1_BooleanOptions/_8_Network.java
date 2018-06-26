package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of network's option.
 * If this boolean option is set to true, MaDKit starts
 * the network on startup.
 * The default value is false.
 * 
 * #jws madkitoptions.ex1_BooleanOptions._8_Network jws#
 *
 */

public class _8_Network {

	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.network.toString());
		 
		 /* Check the difference by commenting the previous line and decommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.network.toString(),"false");
	 }

}
