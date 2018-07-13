package madkitoptions.ex1_BooleanOptions;

import java.util.logging.Level;

import madkit.kernel.Madkit;
import madkitoptions.TutorialAgent;

/** 
 * This class exemplifies the use of cgrWarnings's option.
 * If this boolean option is set to true, warnings concerning
 * Community/Group/Role notifications are activated.
 * The default value is false.
 * 
 * #jws# madkitoptions.ex1_BooleanOptions._2_CgrWarnings #jws#
 * #args# #args#
 */

public class _2_CgrWarnings  extends TutorialAgent{

	@Override
	protected void activate() {
		requestRole("COMMUNITY", "GROUP", "ROLE");
		/**
		 * By requesting a role in a community that does not exist,
		 * our agent will cause a CGR warning.
		 */
	}
	
	 public static void main(String[] args) {
		 
		 new Madkit(Madkit.BooleanOption.cgrWarnings.toString(), Madkit.Option.launchAgents.toString(), _2_CgrWarnings.class.getName() + " ,true,1", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
		 
		 /* Check the difference by commenting the previous line and uncommenting the next one. */
		 // new Madkit(Madkit.BooleanOption.cgrWarnings.toString(), Boolean.FALSE.toString(), Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1", Madkit.LevelOption.agentLogLevel.toString(), Level.SEVERE.toString());
	 }
}
