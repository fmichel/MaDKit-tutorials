package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;
import madkitoptions.util.TutorialAgent;

/**
 * This option allows MaDKit users to specify
 * the directory in which the log files should
 * be stored. 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._5_LogDirectory #jws#
 * #args# #args#
 * 
 */

public class _5_LogDirectory {

	public static void main(String[] args) {
		
		/**
		 *  Here the created directory is : "myLogs".
		 *  We are launching a TutorialAgent to generate logs.
		 *  Do not forget to trigger the creation of log files using "createLogFiles".
		 */
		new Madkit(
			Madkit.Option.logDirectory.toString(), "myLogs",
			Madkit.BooleanOption.createLogFiles.toString(),
			Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName());
	}
}
