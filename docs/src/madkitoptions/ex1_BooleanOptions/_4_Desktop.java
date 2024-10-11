package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

/**
 * This class exemplifies the use of desktop's option.
 * If this boolean option is set to true, MaDKit desktop is launched.
 * The default value is false.
 * 
 */
public class _4_Desktop {

	/**
	 * Despite default value being "false", if this property is not explicitly set
	 * to "false" and if Madkit.Option.launchAgents and Madkit.Option.configFile
	 * are both null, then the desktop mode will be automatically set to true
	 * during startup.
	 */
	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.desktop.toString());
		
		 /* Notice that it is the same behavior as the next line */
		 // new Madkit(Madkit.Option.launchAgents.toString(), "null", Madkit.Option.configFile.toString(), "null");
		 
		 /* Nevertheless if we specify it... There is not any MaDKit desktop displayed. */
		 // new Madkit(Madkit.BooleanOption.desktop.toString(), Boolean.FALSE.toString()); 
	 }

}
