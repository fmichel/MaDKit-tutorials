package madkitproperties;

import java.io.IOException;

import madkit.util.MadkitProperties;

/**
 * Comment utiliser MDK Prop dans un nouveau MaDKit ?
 * 
 * #jws# madkitproperties._5_LoadPropertyFile #jws#
 * #args# #args#
 *
 */
public class _5_LoadPropertyFile {
	
	public static void main(String[] args) {
		try{
			System.out.println("toto\n");
			new MadkitProperties().loadPropertiesFromPropertiesFile("src/madkitproperties/LoadingPropertyFile.properties");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
