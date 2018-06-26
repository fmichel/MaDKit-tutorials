package madkitoptions.ex1_BooleanOptions;

import madkitoptions.TutorialAgent;


/**
 * This class represents an agent who causes a Community Group Role warning.
 * It will be used for the madkitoptions.ex1_BooleanOptions._2_CgrWarnings example.
 */

public class _2_Agent extends TutorialAgent{

	@Override
	protected void activate() {
		requestRole("COMMUNITY", "GROUP", "ROLE");
	}
}
