// TODO NOT_GROUP
package exception.ex4_CGRReturnCodes;

import madkit.kernel.Agent;

public class AgentLeavingAGroup extends Agent {

	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		createGroupIfAbsent("myCommunity", "myGroup2");
		requestRole("myCommunity", "myGroup", "myRole");
		pause(1500);
	}
	
	@Override
	protected void live() {
		ReturnCode rc1 = leaveGroup("myCommunity", "myGroup2");
		ReturnCode rc2 = leaveGroup("myCommunity", "myGroup");
		getLogger().info( rc1.toString() + "   " + rc2.toString());
	}
	
	/**
     * @param argss
     */
    public static void main(String[] argss) {
    	executeThisAgent(5,false);
    }
}




/*AgentAddress agentAddr = null;
while (agentAddr == null)// Until we found an Agent having "("communication","GroupTest","RoleTest4")".
{
    agentAddr = getAgentAddressIn("myCommunity", "myGroup", "myRole");
}
sendMessage(agentAddr, new Message());

Message message = null;
while(message == null) {
	message = getLastReceivedMessage();
}*/



//ReturnCode returnCode = sendReply(message, new Message());
//if(returnCode == ReturnCode.NOT_IN_GROUP) {
	//getLogger().info("\n\t You can not leave a group you do not belong to. \t\n");
	//returnCode = leaveGroup("myCommunity", "myOwnGroup");
//}