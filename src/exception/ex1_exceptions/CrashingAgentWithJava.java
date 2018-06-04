package exception.ex1_exceptions;

import madkit.kernel.AbstractAgent;

public class CrashingAgentWithJava extends AbstractAgent{

	/* We just want this method to fail.*/
	@Override
	protected void activate() {
		Object o = null;
		o.toString();
	}
	
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
