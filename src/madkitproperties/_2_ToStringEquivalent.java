package madkitproperties;

import java.util.logging.Level;

import madkit.kernel.Madkit;
import madkit.kernel.Madkit.BooleanOption;
import madkit.kernel.Madkit.LevelOption;

/**
 * Each of the default MaDKit properties can be specified while launching MaDKit.
 * To do so, you have to specify the name of the wanted option as an argument of the
 * Madkit() method. To do so, you have two possibilities,which will be presented in this example.
 * 
 * #jws# madkitproperties._2_ToStringEquivalent #jws#
 * #args# #args#
 */
public class _2_ToStringEquivalent {

	public static void main(String[] args) {
		
		/**
		 * First you can specify the name of a property preceded by "--".
		 */
		new Madkit("--madkitLogLevel","FINER","--desktop","false");
		
		/**
		 * However, the previous solution is not absolutely reliable.
		 * Indeed if the option name is misspelled, then MaDKit does not
		 * recognize the property. Then, we will prefer the second option.
		 * 
		 * Note that this way we can benefit from the auto-completion.
		 */
		new Madkit(
			LevelOption.madkitLogLevel.toString(),Level.FINER.toString(),
			BooleanOption.desktop.toString(),Boolean.FALSE.toString()
			);
	}
}
