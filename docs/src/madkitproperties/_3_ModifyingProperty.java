package madkitproperties;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * A property has a value that we can change.
 * 
 */
public class _3_ModifyingProperty {

	/**
	 * Here we will change the value of the debug property and set it to true. 
	 * The property madkitLogLevel is only here to notice the difference. 
	 */
	public static void main(String[] args) {
		new Madkit(
			Madkit.BooleanOption.debug.toString(), "true", 
			Madkit.LevelOption.madkitLogLevel.toString(),Level.FINER.toString());
	}
}
