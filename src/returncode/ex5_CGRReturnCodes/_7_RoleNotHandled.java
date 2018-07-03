package returncode.ex5_CGRReturnCodes;

import madkit.kernel.Madkit;
import madkit.kernel.Message;
import returncode.utils.TutorialAgent;

/**
 * This class exemplifies: ROLE_NOT_HANDLED.
 * This ReturnCode is returned when the agent does not have the role
 * needed if he wants to do a particular action.
 * 
 * 
 * 
 * #jws# returncode.ex5_CGRReturnCodes._7_RoleNotHandled #jws#
 * #args# --launchAgents returncode.ex5_CGRReturnCodes._7_RoleNotHandled #args#
 * 
 */
public class _7_RoleNotHandled extends TutorialAgent{

	/**
	 * We activate the _7_RoleNotHandled agent in the same virtual society than the
	 * TutorialAgent. Nevertheless, our agent will have a different role: myDifferentRole.
	 */
	@Override
	protected void activate() {
		createGroupIfAbsent("myCommunity", "myGroup");
		requestRole("myCommunity", "myGroup", "myDifferentRole");
		pause(500);
	}
	
	/**
	 * The agent will try to send a message to a TutorialAgent.
	 * However, in the method he uses : sendMessageWithRole(String community, String group, String role, Message message, String senderRole)
	 * our agent makes a mistake and specifies a role that is not his as senderRole.
	 */
	@Override
	protected void live(){
		ReturnCode sendFeedback;
		sendFeedback = sendMessageWithRole("myCommunity", "myGroup", "myRole", new Message(), "myRole"); 
		getLogger().info("\n\tThe ReturnCode is: \"" + sendFeedback.toString() + "\" .\n\tIt means that I do not have this role. \t\n");
					
		/* Then you do what you want with this agent */
	}
	
	/**
	 * Launch an _7_RoleNotHandled agent and a TutorialAgent (as receiver).
	 * 
	 * @param argss
	 */
    public static void main(String[] argss){
    	new Madkit("--launchAgents", _7_RoleNotHandled.class.getName() + ",true,1;", _5_NotRole.class.getName() + ",true,1;");
    }
}
