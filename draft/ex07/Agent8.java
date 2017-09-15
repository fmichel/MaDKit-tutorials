package communication.ex07;

import java.util.logging.Level;

import javax.swing.JFrame;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		 
 * 
 * 		#jws communication.ex07.Agent8 jws# 
 * 
 * 
 * 
 * This example is a bit more complicated, 
 * here two agents are sending messages and waiting a reply before sending another message.
 */

public class Agent8 extends Agent//Agent8 sends PING (as a message),
								//then Agent9 gets it (PONG), he sends back PONG,
								//Agent8 gets PONG and sends PING once last time.
{
	public static final StringMessage PING = new StringMessage("ping");
	public static final StringMessage PONG = new StringMessage("pong");

	protected void activate() 
	{
		getLogger().setLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupTest");//Does not produce a warning if the group already exists.
		requestRole("communication","GroupTest","RoleTest8");
	}
	/* 
	 * Setting where the agent's window will be.
	 */
	public void setupFrame(AgentFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(100,100);
		@SuppressWarnings("unused")
		int i = hashCode();
	}
	/* 
	 * Trying to send a message in a loop until this Agent succeeds sending a message with sendMessageWithRole.
	 * Then, wait a message.
	 * And once he gets the message, he sends back his last message.
	 */
	protected void live()
	{
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending "ping" to an Agent having a RoleTest9 specifying Agent8's role.
		{		
			code = sendMessageWithRole("communication", "GroupTest", "RoleTest9", PING, "RoleTest8");
			pause(100);//Waiting: if sendMessageWithRole fails, because Agent9 isn't ready yet.
		}
		pause(1500);
		Message incommingMessage = waitNextMessage();//Waiting to get a message.
		code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
		{		
			code = sendReply(incommingMessage,PING);//sendReply sends "ping" as soon as Agent8 gets "pong".
		}
		pause(1500);
		while(nextMessage() != null);
		pause(3000);
	}
	/**
	 * @param argss
	 * It will run one Agent8 and one Agent9.
	 */
	public static void main(String[] argss) 
	{
		new Madkit 
			( 
				"--launchAgents",
				Agent8.class.getName() + ",true,1;" ,
				Agent9.class.getName() + ",true,1;"
			);
	}
}