package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of loadLocalDemos
 * option. This option load all the demos that are 
 * available so far. 
 * If this boolean is set to true, you can access
 * to all of the demos and launch them in the
 * "MAS" tab of MaDKit GUI (graphical user interface). 
 * The default value is false.
 * 
 *
 */

public class _7_LoadLocalDemos {

	 public static void main(String[] args) {
	
		 new Madkit(Madkit.BooleanOption.loadLocalDemos.toString());
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.loadLocalDemos.toString(), Boolean.FALSE.toString());
	 }

}
