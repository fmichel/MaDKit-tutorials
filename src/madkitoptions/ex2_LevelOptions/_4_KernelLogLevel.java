package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This example is about the level option KernelLogLevel.
 * This option allows the specification of MaDKit's kernel's
 * log level and is extremely useful for debugging.
 * It is mainly useful for kernel developers.
 *  
 * #jws# madkitoptions.ex2_LevelOptions._4_KernelLogLevel #jws#
 * #args# #args#
 */

public class _4_KernelLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),Level.ALL.toString());
		
		/* Displays only informational messages */
		// new Madkit(Madkit.LevelOption.kernelLogLevel.toString(),Level.INFO.toString());
	}
}
