package madkitproperties;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;
import madkit.kernel.Madkit.LevelOption;
import madkit.kernel.Madkit.Option;

/**
 * You can also create the property you want and give it any value, which will be converted into a string.
 * 
 * #jws# madkitproperties._4_CreateNewProperty #jws#
 * #args# #args#
 */
public class _4_CreateNewProperty  extends Agent {

    @Override
    protected void live() {
	getLogger().info("getting a property passed as a MaDKit argument:");
	getLogger().info("myNewProperty has been set to "+getMadkitProperty("myNewProperty"));
	pause(5000);
    }

	/**
	 * Notice the new property among the "Additional non MaDKit options" 
	 * logged at startup.
	 */
	public static void main(String[] args) {
		new Madkit(
			"--myNewProperty", "aNewValue",
			LevelOption.madkitLogLevel.toString(),Level.FINER.toString(),
			Option.launchAgents.toString(),_4_CreateNewProperty.class.getName()+",true"
			);
	}
}
