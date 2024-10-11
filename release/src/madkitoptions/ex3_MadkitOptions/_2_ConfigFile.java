package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Madkit.Option;

/**
 * With the configFile option you can specify a property file that MaDKit will load on startup.
 * The configuration file of this example just contains one line: " test=23 "
 * If you want extra detail about MaDKit properties, check out the dedicated tutorial.
 * 
 */

public class _2_ConfigFile extends Agent {

    @Override
    protected void live() {
	getLogger().info("getting a property from the loaded file:");
	getLogger().info(getMadkitProperty("test"));
    }

    public static void main(String[] args) {
	new Madkit(
		Madkit.Option.configFile.toString(), "madkitoptions/ex3_MadkitOptions/myPropertyFile.properties",
		Option.launchAgents.toString(), _2_ConfigFile.class.getName()
		);
    }
}
