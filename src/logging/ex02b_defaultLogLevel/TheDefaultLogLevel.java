package logging.ex02b_defaultLogLevel;

import madkit.kernel.Agent;

/**
 * So we can set the log level with getLogger().setLevel() and we will see the different existing levels in the next
 * example. Here we go to see the method getLevel() and see the default log level which is used in MaDKit. 
 * 
 * #jws logging.ex02b_defaultLogLevel.TheDefaultLogLevel jws#
 * 
 * 
 * 
 * @author Pascal Wagner
 */

public class TheDefaultLogLevel extends Agent {

    @Override
    protected void live() {
	pause(2000);
	getLogger().info("The default log level is : " + getLogger().getLevel());
	pause(8000);
    }

    public static void main(String[] args) {
	executeThisAgent();
    }
}