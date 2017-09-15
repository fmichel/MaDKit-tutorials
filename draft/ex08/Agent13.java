package communication.ex08;

import java.util.logging.Level;
import javax.swing.JFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		 
 * 
 * 		#jws communication.ex08.Agent13 jws# 
 * 
 * 
 * 
 */

public class Agent13 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a GroupA and a Role1).
	 */
	protected void activate() 
	{	
		getLogger().setLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupD");
		requestRole("communication","GroupD","ReplyRole");
	}	
	/* 
	 * Now replying to Agent10, if an Agent13 (only one will get it) gets the single message, he won't get the broadcast message.
	 */
	protected void live()
	{
		Message incommingMessage = waitNextMessage();
		if (incommingMessage.equals("SingleMessage"))
		{
			ReturnCode code = null;
			while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
				{		
					code = sendReplyWithRole(incommingMessage,new StringMessage("I've got the "+incommingMessage.toString()+" from "+incommingMessage.getSender()), "ReplyRole");
				}
		}
		else
		{
			ReturnCode code = null;
			while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
			{		
				code = sendReplyWithRole(incommingMessage,new StringMessage("I've got the "+incommingMessage.toString()+" from "+incommingMessage.getSender()), "ReplyRole");
			}
		}
		getLogger().info("I just sent the "+incommingMessage.toString());
		pause(3000);
	 	while(nextMessage() != null)
	 		pause(3000);
	}

	public void setupFrame(AgentFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(800,300);
	}
}