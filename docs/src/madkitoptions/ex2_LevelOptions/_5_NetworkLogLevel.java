package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This example is about the level option NetworkLogLevel.
 * This option allows the specification of MaDKit
 * network's log level.
 * 
 */

public class _5_NetworkLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.networkLogLevel.toString(),Level.ALL.toString());
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.networkLogLevel.toString(),Level.INFO.toString());
	}
}
