package exception.ex1_exceptions;

import madkit.kernel.Gatekeeper;

/**
 * 
 * Is it a class ? Shall we use this in an Agent as a nested class ?
 * Very questions, not much answer
 *
 */

public class MeanGatekeeper implements Gatekeeper{

	@Override
	public boolean allowAgentToTakeRole(String arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
