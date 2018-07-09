package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * This example is about the level option KernelLogLevel.
 * This option allow to specify the log level of MaDKit's 
 * kernel and is extremely useful for debugging.
 * It is mainly useful for kernel developers.
 *  
 * #jws# madkitoptions.ex2_LevelOptions._4_KernelLogLevel #jws#
 * #args# #args#
 */

public class _4_KernelLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),"ALL");
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),"INFO");
	}
}
