package madkitproperties;

import java.io.IOException;

import madkit.util.MadkitProperties;

/**
 * Now we will see how to load properties
 * from a property file.
 * 
 * An exception is thrown if the specified file 
 * does not exist.
 * 
 * #jws# madkitproperties._5_LoadPropertyFile #jws#
 * #args# #args#
 *
 */
public class _5_LoadPropertyFile {
	
	public static void main(String[] args) {
		try{
			new MadkitProperties().loadPropertiesFromPropertiesFile("src/madkitproperties/PropertyFile.properties");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
