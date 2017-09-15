package logging.ex01b_levels;

import madkit.kernel.Agent;

/**
 * The main advantage of using the Logger class is that all messages are associated with a level. Indeed, depending on
 * the logging method used, a message will have a particular level. This level will have an impact on how the message is
 * displayed. In this example, we will log two messages with different levels. You will observe that the messages are
 * preceded by their own log level.
 * 
 * #jws logging.ex01b_levels.LevelMessage jws#
 * 
 * 
 * 
 * @author Pascal Wagner
 */

public class LevelMessage extends Agent {

    @Override
    protected void live() {
	pause(2000);
	getLogger().info("This is a message which has a level 'info'.");
	pause(3000);
	getLogger().warning("This is a message which has a level 'warning'.");
	pause(5000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}
