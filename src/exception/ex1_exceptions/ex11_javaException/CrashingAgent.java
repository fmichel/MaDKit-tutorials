/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We advise you to not start with this tutorial.
 * You can check previous tutorials at: http://www.madkit.net/madkit/tutorials/ . Among those tutorials, you
 * may use here notions seen in logging and communication tutorials.
 * 
 * In this tutorial we will see what kind of exceptions may be encountered while developing
 * an application with MaDKit and what MadKit provides to improve our programs' reliability: AbstractAgent.ReturnCode.
 * 
 */

package exception.ex1_exceptions.ex11_javaException;

import java.util.logging.Level;

import exception.TutorialAgent;

/**
 * In this example you will understand that as MaDKit is a Java library, you will have to deal
 * with the same errors and exception that you may have encountered with Java.
 * 
 * Thus as in any Java-based program, you will have to be rigorous :)
 * 
 * 
 *  #jws# exception.ex1_exceptions.ex11_JavaException.CrashingAgent.jnlp #jws#
 *  #args# --launchAgents exception.ex1_exceptions.ex11_javaException.CrashingAgent #args#
 * 
 */

public class CrashingAgent extends TutorialAgent{
	
	/*
	 * On activation, we want the agent to throw a NullPointer Exception.
	 */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINEST); /* So that the agent's life cycle is traced. See the logging tutorial for more information. */
		
		pause(2000);
		/* Now we throw an exception */
		throw new NullPointerException();
	}
	
	/*
	 * As the agent throw a NullPointerException, this method should not be called.
	 */
	@Override
	protected void live() {
		getLogger().info("\n\tI have crashed, this message shall not be displayed.\t\n");
	}
	
	@Override
	protected void end() {
		getLogger().info("\n\tI have crashed. :(\t\n");
		super.end();
	}
	
	/**
	 * We launch a CrashingAgent that throws a NullPointer exception 
	 * and the agent terminates.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent();
		/**
		 * The previous line of code shall cause this error:
		 * 
		 * [CrashingAgent-2] SEVERE : -*-ACTIVATE BUG*-*
		 * ** java.lang.NullPointerException
		 *			at exception.ex1_exceptions.ex11_javaException.CrashingAgent.activate(CrashingAgent.java:40)
		 *
		 * Followed by the agent's life cycle.
		 * 
		 */
	}
}
