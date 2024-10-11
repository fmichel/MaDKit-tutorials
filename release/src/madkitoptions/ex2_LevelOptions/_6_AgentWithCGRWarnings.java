package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Agent;

/**
 * 
 * This class outlines how to use enableCGRWarnings().
 * 
 * 
 */
public class _6_AgentWithCGRWarnings extends Agent{

	@Override
	protected void activate() {
		getLogger().enableCGRWarnings();
		requestRole("COMMUNITY", "GROUP", "ROLE");
	}
}
