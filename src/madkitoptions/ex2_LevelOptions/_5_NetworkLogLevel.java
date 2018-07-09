package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;

/**
 * This example is about the level option NetworkLogLevel.
 * This option allow to specify the log level of MaDKit's network.
 * 
 * #jws# madkitoptions.ex2_LevelOptions._5_NetworkLogLevel #jws#
 * #args# #args#
 */

public class _5_NetworkLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.networkLogLevel.toString(),"ALL");
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.networkLogLevel.toString(),"INFO");
	}
}
