package madkitproperties;

import java.io.IOException;

import madkit.kernel.AbstractAgent;

/**
 * Now we will see how to load properties from a property file.
 * The loadPropertiesFromFile(nameOfFile) method allows to 
 * add and update properties that are stored in this particular file.
 * 
 * An exception is thrown if the specified file 
 * does not exist.
 * 
 * #jws# madkitproperties._5_AgentLoadingPropertyFile #jws#
 * #args# --launchAgents madkitproperties._5_AgentLoadingPropertyFile,true #args#
 *
 */

public class _5_AgentLoadingPropertyFile extends AbstractAgent{

	@Override
	protected void activate() {
		/* We display the original MaDKit configuration */
		getLogger().talk(getMadkitConfig().toString());
		try {
			/* Now we load new properties */
			getLogger().talk("\nNow I will load properties from : src/madkitproperties/PropertyFileToLoad.properties \n");
			getMadkitConfig().loadPropertiesFromFile("src/madkitproperties/PropertyFileToLoad.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* Finally, we display the properties again to notice the differences */
		getLogger().talk(getMadkitConfig().toString());
	}
	
	/**
	 * Launch a _5_AgentLoadingPropertyFile.
	 * @param args
	 */
	public static void main(String[] args) {
		executeThisAgent();
	}
	
}
