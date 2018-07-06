package madkitproperties;

import madkit.kernel.Madkit;

/**
 * You can also create the property you want with the value you find accurate.
 * 
 * BALISES
 */
public class _4_CreateNewProperty {

	/**
	 * As the previous exercises, the madkitLogLevel option is only here to help
	 * us notice the new property among the Additional non MaDKit options displayed
	 * in the console.
	 */
	public static void main(String[] args) {
		new Madkit("--myNewProperty", "aNewValue",Madkit.LevelOption.madkitLogLevel.toString());
	}
}
