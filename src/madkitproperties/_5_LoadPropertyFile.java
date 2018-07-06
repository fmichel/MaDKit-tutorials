package madkitproperties;

import java.io.IOException;

import madkit.util.MadkitProperties;

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
