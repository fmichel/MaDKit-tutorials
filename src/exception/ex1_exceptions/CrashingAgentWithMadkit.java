/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what kind of exceptions may be encountered while developing
 * an application with MaDKit.
 *
 * #jws exception.ex1_exceptions.CrashingAgentWithMadkit jws#
 */

package exception.ex1_exceptions;

import madkit.kernel.Agent;
import madkit.kernel.Message;

/**
 * In addition of java's exceptions, there is another category of failure that may happen with MadKit :
 * madkit.kernel.KernelException. KernelException is a class of MadKit that extends RuntimeException. 
 * Actually it is an exception thrown to indicate that the agent is trying to use a method
 * while not launched or already dead.
 * 
 * In this example we will see a madkit.kernel.KernelException being thrown while we try to
 * send a message with an agent without launching him.
 */
public class CrashingAgentWithMadkit extends Agent {
	
	/**
	 * This will cause the throw of a KernelException.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		CrashingAgentWithMadkit agent = new CrashingAgentWithMadkit();
		agent.sendMessage("myCommunity", "myGroup", "myRole", new Message());
	}

}
