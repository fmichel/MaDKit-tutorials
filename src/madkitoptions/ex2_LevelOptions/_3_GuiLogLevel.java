package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/**
 * Only useful for kernel developers, still same kind of output that AgentLogLevel
 *
 */

public class _3_GuiLogLevel {

	public static void main(String[] args) {
		
		/* Displays everything */
		//new Madkit(Madkit.LevelOption.guiLogLevel.toString(),"ALL");
		
		/* Displays only the informational messages */
		//new Madkit(Madkit.LevelOption.guiLogLevel.toString(),"INFO");
		
		/* Same output as INFO : no particular display .. */ 
		new Madkit(Madkit.LevelOption.guiLogLevel.toString(),"OFF");
	}
	
}
