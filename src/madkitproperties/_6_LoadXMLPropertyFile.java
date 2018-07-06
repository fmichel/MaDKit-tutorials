package madkitproperties;

import java.io.IOException;
import madkit.util.MadkitProperties;


/**
 * Comment utiliser MDK Prop dans un nouveau MaDKit ?
 * 
 * #jws# madkitproperties._6_LoadXMLPropertyFile #jws#
 * #args# #args#
 *
 */
public class _6_LoadXMLPropertyFile {

	public static void main(String[] args) throws IOException {
		try{
			System.out.println("toto\n");
			new MadkitProperties().loadPropertiesFromMaDKitXML("src/madkitproperties/XMLPropertyFile.xml");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
