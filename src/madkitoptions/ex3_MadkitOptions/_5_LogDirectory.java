package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

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
		 *  Here the wanted directory is : myLogs.
		 *  We are launching a TutorialAgent to generate logs.
		 *  Do not forget also to allow the creation of log files.
		 */
		new Madkit(Madkit.Option.logDirectory.toString(), "myLogs", Madkit.BooleanOption.createLogFiles.toString(),Madkit.Option.launchAgents.toString(), TutorialAgent.class.getName());
	}
}
