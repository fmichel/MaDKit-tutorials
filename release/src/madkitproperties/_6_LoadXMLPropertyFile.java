package madkitproperties;

import java.io.IOException;

import madkit.kernel.Madkit;
import madkit.kernel.Madkit.Option;

/**
 * Now we will see how to load properties from a XML property file.
 * Unlike basics property files, XML allow a parameterization even
 * more accurate. Here we will parameterized agents while launching
 * them.
 * 
 * An exception is thrown if the specified file 
 * does not exist.
 *
 */

public class _6_LoadXMLPropertyFile {

	public static void main(String[] args) throws IOException {
			new Madkit(Option.configFile.toString(),"madkitproperties/XMLPropertyFile.xml");
	}
}