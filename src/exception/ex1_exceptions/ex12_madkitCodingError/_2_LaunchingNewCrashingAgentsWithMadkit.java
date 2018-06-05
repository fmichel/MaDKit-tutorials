/**
 * READ ME
 * This tutorial shows how MaDKit is dealing with exceptions. We strongly recommend that you do not start with this tutorial.
 * Please check previous tutorials at : http://www.madkit.net/madkit/tutorials/ . 
 * 
 * In this part of the tutorial we will see what kind of exceptions may be encountered while developing
 * an application with MaDKit.
 * 
 * #jws exception.ex1_exceptions.AgentThatLaunchesCrashingAgents jws#
 */

package exception.ex1_exceptions.ex12_madkitCodingError;

import exception.TutorialAgent;
import exception.ex1_exceptions.ex11_javaException.CrashingAgent;
import madkit.kernel.Madkit;

/**
 * Good failure's managing is extremely important in multi-agent system.
 * We do not want that because of the crash of one of our agents, the whole
 * society crashes too.
 * 
 * In this example we will see how are other agents impacted if one of them crash.
 * We will see this while launching a new kernel.
 */
public class _2_LaunchingNewCrashingAgentsWithMadkit{

	/**
	 * Launches one TutorialAgent and one exception.ex1_exceptions.CrashingAgentWithJava. As expected, the last agent will crash
	 * but without having any impact on the life of the three other agents. 
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		new Madkit("--launchAgents", TutorialAgent.class.getName() + ",true,1;", CrashingAgent.class.getName() + ",true,1;");
	}
}
