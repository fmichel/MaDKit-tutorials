package madkitproperties;

import madkit.kernel.Madkit;

/**
 * Each of the default MaDKit property can be specified while launching MaDKit.
 * To do so, you have to specify the name of the wanted option as an argument of the
 * Madkit() method. To do so, you have two possibility that will be presented in this example.
 * 
 * #jws# madkitproperties._2_ToStringEquivalent #jws#
 * #args# #args#
 */
public class _2_ToStringEquivalent {

	public static void main(String[] args) {
		
		/**
		 * First you can specify the name of the required property preceded by "--".
		 */
		new Madkit("--madkitLogLevel");
		
		/**
		 * However, the previous solution is not absolutely reliable.
		 * Indeed if the option name is misspelled, then MaDKit does not
		 * recognize the property. Then, we will prefer the second option.
		 * 
		 * Note that this way we can benefit of the auto-completion.
		 */
		new Madkit(Madkit.LevelOption.madkitLogLevel.toString());
	}
}
