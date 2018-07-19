package madkitproperties;

import madkit.kernel.Madkit;

/**
 * As every variable, a property has a value that we can change.
 * 
 * #jws# madkitproperties._3_ModifyProperty #jws#
 * #args# #args#
 */
public class _3_ModifyProperty {

	/**
	 * Here we will change the value of the debug property and set it to true. 
	 * The property madkitLogLevel is only here to notice the difference. 
	 */
	public static void main(String[] args) {
		new Madkit(Madkit.BooleanOption.debug.toString(), "true", Madkit.LevelOption.madkitLogLevel.toString());
	}
}
