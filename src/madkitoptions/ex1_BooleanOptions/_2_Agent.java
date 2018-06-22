package madkitoptions.ex1_BooleanOptions;

import madkitoptions.TutorialAgent;

public class _2_Agent extends TutorialAgent{

	@Override
	protected void activate() {
		requestRole("COMMUNITY", "GROUP", "ROLE");
	}
}
