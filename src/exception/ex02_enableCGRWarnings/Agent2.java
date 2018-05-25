package exception.ex02_enableCGRWarnings;

import madkit.kernel.Agent;

/**
 * TODO explain the purpose of this class : enable / disable the CGRWarnings()
 * 
 * #jws exception.ex02.Agent2 jws#
 * 
 */
public class Agent2 extends Agent {

	@Override
	protected void activate() {
		
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "roleAgent2");
		pause(500);
	}
	
	@Override
	protected void live() {
		
	}

}
