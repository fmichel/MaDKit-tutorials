package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * Only useful for kernel developers
 * 
 * INFO and OFF identical
 *
 */

public class _4_KernelLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),"ALL");
		
		/* Displays only the informational messages */
		//new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),"INFO");
		
		/* The logging is turned off */ 
		//new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),"OFF");
	}
}
