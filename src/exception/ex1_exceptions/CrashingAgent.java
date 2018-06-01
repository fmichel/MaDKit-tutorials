package exception.ex1_exceptions;

import madkit.kernel.Message;
import madkit.kernel.Agent;

public class CrashingAgent extends Agent {

	public static void main(String[] argss) {
		CrashingAgent agent = new CrashingAgent();
		ReturnCode returnSend = agent.sendMessage("myCommunity", "myGroup", "myRole", new Message());
		
		//this code is not reached
		if(returnSend != ReturnCode.SUCCESS) {
			agent.getLogger().info(returnSend.toString());
		}
	}
}
