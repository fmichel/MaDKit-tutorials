package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Agent;

/**
 * 
 * This class outlines how to use enableCGRWarnings().
 * 
 * #jws# madkitoptions.ex2_LevelOptions._6_AgentWithCGRWarnings #jws#
 * #args# --launchAgents madkitoptions.ex2_LevelOptions._6_AgentWithCGRWarnings, true #args#
 * 
 */
public class _6_AgentWithCGRWarnings extends Agent{

	@Override
	protected void activate() {
		getLogger().enableCGRWarnings();
		requestRole("COMMUNITY", "GROUP", "ROLE");
	}
}
