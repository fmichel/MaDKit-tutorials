package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

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
		
		/* Here the wanted directory is : toto */
		new Madkit(Madkit.BooleanOption.createLogFiles.toString(), Madkit.Option.logDirectory.toString(), "toto");
	}
}
