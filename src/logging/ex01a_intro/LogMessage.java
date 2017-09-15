package logging.ex01a_intro;

import madkit.kernel.Agent;

/**
 * This tutorial is about the agent's logger attribute which is an alternative to the method System.out.println(). In
 * fact the logger can do the same thing as System.out.println() : displaying message on the screen but it does many
 * other things. The logger is an instance of the AgentLogger class of the MaDKit library which extends the Logger class
 * of the Java SE. In this tutorial we will see why and how the logger replaces the method System.out.println() in
 * MaDKit. In the different examples of this tutorial we will see : - how to log a message - the different log levels -
 * the "finest" level particular features - how to create a log file - how to choose the log directory Firstly, we just
 * display a message to the screen with the method AgentLogger#info(String) of the getLogger(). A simple agent is used,
 * which has a default GUI, lives 10 seconds and quits. During the life of the agent, we show how to log an "info"
 * message. As you will see, by default this message is displayed in both the output console and the agent's GUI
 * 
 * 
 * 
 * #jws logging.ex01a_intro.LogMessage jws#
 * 
 * 
 * 
 * @author Pascal Wagner
 */

public class LogMessage extends Agent {

    @Override
    protected void live() {
	pause(2000);
	getLogger().info("This agent logs an 'info' message.");
	pause(8000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}
