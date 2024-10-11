package returncode.ex2_madkitCodingError;

import java.util.logging.Level;

import returncode.ex1_javaException.CrashingAgent;
import returncode.utils.TutorialAgent;

/**
 * Now that we have seen that misusing MaDKit may generate KernelException, we will
 * see how other agents are impacted if one of them crash.
 * 
 * Good failure managing is extremely important in multi-agent system.
 * We do not want the whole society to crash because of the crash of one of our agents.
 * 
 * Here we launch an agent that will launch two agents during his life.
 * The first one is a basic TutorialAgent while the second is a CrashingAgent.
 * The aim of this exercise is to see if the crash of a launched agent may have any
 * impact on the launcher agent.
 * 
 * 
 * 
 */

public class _3_AgentLaunchingNewCrashingAgents extends TutorialAgent{
	
	/**
	 * On activation we will just set the log level on FINEST so that
	 * the agent's life cycle is traced.
	 * See the logging tutorial for more information.
	 */
	@Override
	protected void activate() {
		getLogger().setLevel(Level.FINEST);
	}
	
	/**
	 * Launches a TutorialAgent and a CrashingAgent. 
	 */
	@Override
	protected void live() {
		//first launch a TutorialAgent
		launchAgent(new TutorialAgent(),true);

		//then launch a CrashingAgent
		launchAgent(new CrashingAgent(),true);
	}
	
	/**
	 * Launch a _3_AgentLaunchingNewCrashingAgents. As expected, the
	 * CrashingAgent will crash but without having any impact
	 * on the life of the others. 
	 * 
	 * @param argss
	 */
	public static void main(String[] argss) {
		executeThisAgent(1, true);
	}
}

