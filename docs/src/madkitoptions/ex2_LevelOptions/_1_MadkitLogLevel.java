/**
 * Now we will interest into Level Options.
 * These features are more detailed than Boolean Options,
 * and allow slight differences. 
 * 
 * There are nine different levels, from :
 * 
 * OFF (turn off logging)
 * SEVERE (highest value : the less detailed)
 * WARNING
 * INFO
 * CONFIG
 * FINE
 * FINER
 * FINEST (lowest value : the more detailed)
 * ALL (enable all messages)
 * 
 * To understand their nuances you can check the official documentation
 * ( https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html?is-external=true )
 * or the logging tutorial.
 */
package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;

/**
 * This example is about the level option MadkitLogLevel.
 * This option allows the specification of MaDKit's log level.
 *
 */
public class _1_MadkitLogLevel {

	 public static void main(String[] args) {
		 
		/* Displays everything */
		new Madkit(Madkit.LevelOption.madkitLogLevel.toString(),Level.ALL.toString());
		
		/* Displays only informational messages */
		//new Madkit(Madkit.LevelOption.madkitLogLevel.toString(),Level.INFO.toString());
		
		/* The logging is turned off */ 
		//new Madkit(Madkit.LevelOption.madkitLogLevel.toString(),Level.OFF.toString());
	 }
}
