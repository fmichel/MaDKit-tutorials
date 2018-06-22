package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

public class _4_Desktop {

	/* Default value is "false".
	 * Still, if this property is not explicitly set to "false" and
	 * if Madkit.Option.launchAgents and Madkit.Option.configFile are both null,
	 * then the desktop mode will be automatically set to true during startup.
	 */
	 public static void main(String[] args) {
		new Madkit(Madkit.BooleanOption.desktop.toString(),"true");
		 //notice its the same behavior as
		 //new Madkit(Madkit.Option.launchAgents.toString(), "null", Madkit.Option.configFile.toString(), "null");
		 
		 //nevertheless if we specify it...
		 //new Madkit(Madkit.BooleanOption.desktop.toString(),"false");
	 }

}
