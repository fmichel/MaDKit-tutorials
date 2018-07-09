package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * This example is about the level option GuiLogLevel.
 * This option allow to specify the log level of MaDKit's 
 * graphical user interface.
 * It is mainly useful for kernel developers.
 * 
 * #jws# madkitoptions.ex2_LevelOptions._3_GuiLogLevel #jws#
 * #args# #args#
 */

public class _3_GuiLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.guiLogLevel.toString(),"ALL");
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.guiLogLevel.toString(),"INFO");
	}
	
}
