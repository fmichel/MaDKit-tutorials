package madkitoptions.ex2_LevelOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;
import madkitoptions.ex1_BooleanOptions._2_Agent;

/**
 * This example is about the deprecated option : warningLogLevel.
 * 
 * Since MaDKit v5.2 it is replaced by AgentLogger.enableCGRWarnings().
 * You can check how we use enableCGRWarnings() in the 
 * _6_AgentWithCGRWarnings class.
 *  
 * #jws# madkitoptions.ex2_LevelOptions._4_KernelLogLevel #jws#
 * #args# #args#
 */

public class _6_WarningLogLevel {
	
	public static void main(String[] args) {
		
		/* This was how we used the warningLogLevel. Keep in mind that it is now deprecated. */
		new Madkit(Madkit.LevelOption.warningLogLevel.toString(),Level.ALL.toString(), Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
	
	}
}
