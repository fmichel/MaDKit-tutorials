package madkitproperties;

import java.io.IOException;
import madkit.util.MadkitProperties;


/**
 * Now we will see how to load properties from a XML property file.
 * Unlike basics property files, XML allow a parameterization even
 * more accurate. Here we will parameterized agents while launching
 * them.
 * 
 * An exception is thrown if the specified file 
 * does not exist.
 * 
 * #jws# madkitproperties._6_LoadXMLPropertyFile #jws#
 * #args# #args#
 *
 */
public class _6_LoadXMLPropertyFile {

	public static void main(String[] args) throws IOException {
		try{
			new MadkitProperties().loadPropertiesFromMaDKitXML("src/madkitproperties/XMLPropertyFile.xml");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
