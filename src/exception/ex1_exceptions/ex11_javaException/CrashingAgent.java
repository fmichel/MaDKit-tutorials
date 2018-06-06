/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with failure. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what kind of exceptions may be encountered while developing
 * an application with MaDKit.
 * 
 * #jws exception.ex1_exceptions.CrashingAgentWithJava jws#
 */

package exception.ex1_exceptions.ex11_javaException;

import java.util.logging.Level;

import exception.TutorialAgent;

/**
 * In this example you will understand that as MaDKit is a java library, you will have to deal
 * with the same errors and exception that you may encountered with java.
 * 
 * Thus as in any java-based program, you will have to be rigorous :)
 */
public class CrashingAgent extends TutorialAgent{
	
	/* On activation, we want the agent to cause a NullPointer Exception. */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINEST); /* So that the agent's life cycle is traced. See the logging tutorial for more information. */
		
		pause(2000);
		/* Now we cause an exception */
		Object o = null;
		o.toString();
	}
	
	@Override
	protected void end() {
		getLogger().info("\n\tI have crashed. :(\t\n");
		super.end();
	}
	
	/**
	 * We launch an exception.ex1_exceptions.CrashingAgentWithJava. We are willing to
	 * cause a NullPointer exception : the agent terminate.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
	}
}
