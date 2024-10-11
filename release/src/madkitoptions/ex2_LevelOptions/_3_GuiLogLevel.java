package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This example concerns GuiLogLevel's option.
 * This option allows the specification of MaDKit
 * graphical user interface's log level.
 * It is mainly useful for kernel developers.
 * 
 */

public class _3_GuiLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.guiLogLevel.toString(),Level.ALL.toString());
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.guiLogLevel.toString(),Level.INFO.toString());
	}
	
}
