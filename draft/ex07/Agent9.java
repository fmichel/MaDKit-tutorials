package communication.ex07;

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
 * 		#jws communication.ex07.Agent9 jws# 
 * 
 * 
 * 
 * Agent9 is answering Agent8, having a RoleTest9.
 */

public class Agent9 extends Agent
{
	public static final StringMessage PING = new StringMessage("ping");
	public static final StringMessage PONG = new StringMessage("pong");
	/* 
	 * Firstly, taking position in the artificial society (having a RoleTest9).
	 */
	protected void activate() 
	{	
		getLogger().setLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");
		requestRole("communication","GroupTest","RoleTest9");
		pause(500);//Pausing 0.5sec to be sure displayed messages will appear in the right order.
	}
	/* 
	 * Setting where the agent's window will be.
	 */
	public void setupFrame(AgentFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(500,100);
		@SuppressWarnings("unused")
		int i = hashCode();
	}
	/* 
	 * When he gets "ping", Agent9 sends back "pong".
	 */
	protected void live()
	{
		Message incommingMessage = waitNextMessage();
		
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
			{		
				code = sendReply(incommingMessage,PONG);//sendReply sends "pong" as soon as Agent8 gets "ping".
			}
		pause(1500);
	 	while(nextMessage() != null);
		pause(3000);
	}
}