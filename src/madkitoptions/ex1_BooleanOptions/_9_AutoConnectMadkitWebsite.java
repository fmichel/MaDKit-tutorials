package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of autoConnectMaDKitWebsite
 * option. If this boolean is set to true, it connects  MaDKit
 * to the MaDKit repository when launched making all the main classes
 * or demos available in the MaDKit gui.
 * The default value is false.
 * 
 * #jws# madkitoptions.ex1_BooleanOptions._9_AutoConnectMadkitWebsite #jws#
 * #args# #args#
 *
 */

public class _9_AutoConnectMadkitWebsite {

	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.autoConnectMadkitWebsite.toString());
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.autoConnectMadkitWebsite.toString(), Boolean.FALSE.toString());
	 }

}
