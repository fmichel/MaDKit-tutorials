package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.ex1_BooleanOptions._2_Agent;

//this is deprecated, if you 
/**
 * This example is about the level option KernelLogLevel.
 * This option allow to specify the log level of MaDKit's 
 * kernel and is extremely useful for debugging.
 * It is mainly useful for kernel developers.
 *  
 * #jws# madkitoptions.ex2_LevelOptions._4_KernelLogLevel #jws#
 * #args# #args#
 */
public class _6_WarningLogLevel {
	
	public static void main(String[] args) {
		
		/* Displays everything */
		new Madkit(Madkit.LevelOption.warningLogLevel.toString(),"ALL", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		
		/* Displays only informational messages */
		 new Madkit(Madkit.LevelOption.warningLogLevel.toString(),"INFO", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		
	}
}
