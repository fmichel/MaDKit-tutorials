package logging.ex03a_levelFinerFinest;

import java.util.logging.Level;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Agent;
import madkit.kernel.AgentLogger;
import madkit.kernel.Message;

/**
 * You have surely noticed that some additional finer and finest messages appeared in the console in the last example
 * while they did not appear in the code. In fact, finest messages are used to log many of the agent methods defined in
 * MaDKit. And the agent's life cycle is traced at the finer level. So, setting the logger's level to finer, finest or
 * all represents a very easy way of debugging MaDKit agents ! Here, we just set the logger's level to all to show that
 * there are log messages which are displayed whereas there is no explicit code here. notes : - agent's life is composed
 * by the methods : activate(), live() and end(). - the different pauses are only there for you to see the agent's life
 * cycle.
 * 
 * 
 *  #jws# logging.ex03a_levelFinerFinest.LevelFinerFinest #jws#
 * 	#args# --launchAgents logging.ex03a_levelFinerFinest.LevelFinerFinest,true #args# 
 * 
 * 
 * @author Pascal Wagner
 */

public class LevelFinerFinest extends Agent {

    @Override
    protected void activate() {
	getLogger().setLevel(Level.ALL);
	pause(5000);
    }

    @Override
    protected void live() {
	Message m = nextMessage(); /**  In MaDKit, the {@link AbstractAgent#nextMessage()} method is added to
                                    retrieves and removes the oldest received message contained in the mailbox.  */
	pause(5000);
    }

    @Override
    protected void end() {
	pause(5000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}