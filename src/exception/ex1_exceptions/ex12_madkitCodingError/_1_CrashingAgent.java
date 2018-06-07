package exception.ex1_exceptions.ex12_madkitCodingError;

import exception.TutorialAgent;
import madkit.kernel.Message;

/**
 * In addition of Java's exceptions, there is another category of failure that may happen with MaDKit :
 * madkit.kernel.KernelException. KernelException is a class of MaDKit that extends RuntimeException. 
 * Actually it is an exception thrown to indicate that the agent is trying to use a method
 * while not launched or already dead.
 * 
 * In this example we will see a KernelException being thrown while we try to
 * send a message with an agent without launching him.
 * 
 * 
 * #jws exception.ex1_exceptions.ex12_madkitCodingError._1_CrashingAgent jws#
 * 
 */

public class _1_CrashingAgent extends TutorialAgent {
	
	/**
	 * This will throw a KernelException.
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		_1_CrashingAgent agent = new _1_CrashingAgent();
		agent.sendMessage("myCommunity", "myGroup", "myRole", new Message());
		
		/**
		 * The previous line of code shall cause this error :
		 * "INSERTERRORHERE"
		 * 
		 * madkit.kernel.KernelException: _1_CrashingAgent-0 (NOT_LAUNCHED) must be launched to use this method 
		 *			at madkit.kernel.AbstractAgent.sendMessage(Unknown Source)
		 * Exception in thread "main" madkit.kernel.KernelException: _1_CrashingAgent-0 (NOT_LAUNCHED) must be launched to use this method 
		 *			at madkit.kernel.AbstractAgent.sendMessage(Unknown Source)
		 *
		 */
	}
}
