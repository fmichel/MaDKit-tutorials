package communication.ex08;

import java.util.logging.Level;
import javax.swing.JFrame;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.message.StringMessage;;

/**
 * Shows how agents exchange messages.
 * 
 * 		 
 * 
 * 		#jws communication.ex08.Agent10 jws# 
 * 
 * 
 * 
 */

public class Agent10 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a GroupA and a MultiGroupRole).
	 */
	protected void activate() 
	{	
		getLogger().setLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupA");
		requestRole("communication","GroupA","MultiGroupRole");
		pause(500);
	}
	
	/* 
	 * Now our Agent will request roles to send messages in several groups
	 */
	@Override
	protected void live()
	{
		pause(1000);//Waiting other agents to be ready.
		getLogger().info("Request GroupB.");
		ReturnCode code = null;
		requestRole("communication","GroupB","MultiGroupRole");//First sending a message to an agent in the GroupB.
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupB","ReplyRole",new StringMessage("One"),"MultiGroupRole");
			pause(100);
		}
		getLogger().info("Waiting reply.");
		waitNextMessage();//Waiting a reply ("Two").
		pause(1500);
		getLogger().info("Request GroupC.");
		code = null;
		requestRole("communication","GroupC","MultiGroupRole");//Sending a message to an agent in the GroupC.
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupC","ReplyRole",new StringMessage("Three"),"MultiGroupRole");
			pause(100);
		}
		getLogger().info("Waiting reply.");
		waitNextMessage();//Waiting a reply ("Three").
		pause(1500);
		getLogger().info("Request GroupD.");
		code = null;
		requestRole("communication","GroupD","MultiGroupRole");//Sending a message, than broadcasting a message in the GroupD.
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = sendMessageWithRole("communication","GroupD","ReplyRole",new StringMessage("SingleMessage"),"MultiGroupRole");//Sending the single message.
			pause(100);
		}
		getLogger().info("Waiting reply.");
		waitNextMessage();
		pause(1500);
		code = null;
		pause(1500);
		while(code != ReturnCode.SUCCESS)
		{		
			code = broadcastMessage("communication","GroupD","ReplyRole",new StringMessage("BroadcastMessage"));//Broadcasting.
			pause(100);
		}
		
	 	while(nextMessage() != null)
	 		pause(5000);
	}
	
	public static void main(String[] argss) 
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent10.class.getName() + ",true,1;" ,
				Agent11.class.getName() + ",true,1;" ,
				Agent12.class.getName() + ",true,1;" ,
				Agent13.class.getName() + ",true,5;" 
			);
	}

	public void setupFrame(AgentFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(400,0);
	}	
}