package returncode.ex2_madkitCodingError;

import returncode.TutorialAgent;
import returncode.ex1_javaException.CrashingAgent;
import madkit.kernel.Madkit;

/**
 * Now that we have seen that misusing MaDKit may generate KernelException, we will
 * see how other agents are impacted if one of them crash.
 * 
 * Good failure managing is extremely important in multi-agent system.
 * We do not want the whole society to crash because of the crash of one of our agents.
 * 
 * Here we launch two agents and see if the crash of one impacts the activity of the other.
 * 
 * 
 * #jws exception.ex1_exceptions.ex12_madkitCodingError._2_LaunchingNewCrashingAgentsWithMadkit jws#
 * 
 */

public class _2_LaunchingNewCrashingAgentsWithMadkit{

	/**
	 * Launches one TutorialAgent and one CrashingAgent. As expected, the last agent will crash
	 * but without having any impact on the life of the agents. 
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		new Madkit("--launchAgents", TutorialAgent.class.getName() + ",true,1;", CrashingAgent.class.getName() + ",true,1;");
	}
}
