package logging.ex02c_theDifferentLevels;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.AgentLogger;

/**
 * The java.util.logging.Level class of the Java SE defines a set of standard logging levels that can be used to control
 * logging outputs: Here they are in descending order : - severe - warning - info - config - fine - finer - finest In
 * addition there is a level OFF that can be used to turn off logging, and a level ALL that can be used to enable the
 * logging of all messages. In MaDKit, the {@link AgentLogger#talk(String)} method is added to define an additional
 * level which is used log a talk message. This is an example which recaps how to set and get the log level and how we
 * display or not messages according to their level. All the levels are used here. 
 * 
 * #jws logging.ex02c_theDifferentLevels.TheDifferentLevels jws#
 * 
 * 
 * @author Pascal Wagner
 */

public class TheDifferentLevels extends Agent {

    private static List<Level> levels = Arrays.asList(Level.ALL, Level.FINEST, Level.FINER, Level.FINE, Level.CONFIG, Level.INFO, Level.WARNING, Level.SEVERE, Level.OFF);

    @Override
    protected void activate() {
	pause(2000);
    }

    @Override
    protected void live() {
	getLogger().talk("\n\t************************************\n" + "\t   The different levels of display\n" + "\t************************************\n\n");
	pause(1000);

	getLogger().talk("\n\nLog level = " + getLogger().getLevel() + " (default Level)\n");
	getLogger().severe("Default log level = " + getLogger().getLevel());
	getLogger().warning("Default log level = " + getLogger().getLevel());
	getLogger().info("Default log level = " + getLogger().getLevel());
	getLogger().config("Default log level = " + getLogger().getLevel());
	getLogger().fine("Default log level = " + getLogger().getLevel());
	getLogger().finer("Default log level = " + getLogger().getLevel());
	getLogger().finest("Default log level = " + getLogger().getLevel());
	pause(2000);
	int i = 10;
	for (Level l : levels) {
	    getLogger().talk("\n\nLog level --> " + l + "\n");
	    getLogger().setLevel(l);

	    getLogger().severe("severe message");
	    getLogger().warning("warning message");
	    getLogger().info("info message");
	    getLogger().config("config message");
	    getLogger().fine("fine message");
	    getLogger().finer("finer message");
	    getLogger().finest("finest message");
	    pause(1000 * (i--));
	}
	if (getLogger().getLevel() == Level.OFF) {
	    System.out.println("This message is displayed thanks to System.out.println()\n" + "In fact with the log level OFF neither is displayed.\n");
	    pause(2000);
	}
	getLogger().setLevel(Level.INFO);

	getLogger().talk("\nThe loggger is set back to " + getLogger().getLevel() + "\n\n\n");
	pause(1000);
    }

    @Override
    protected void end() {
	getLogger().info("Bye bye !");
	pause(5000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}