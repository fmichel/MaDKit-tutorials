package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

/**
 * With the configFile option you can specify which
 * property file MaDKit shall use.
 * 
 * If you want extra detail about MaDKit properties,
 * check out the dedicated tutorial.
 * 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._2_ConfigFile #jws#
 * #args# #args#
 * 
 */

public class _2_ConfigFile {

	public static void main(String[] args) {
		new Madkit(Madkit.Option.configFile.toString(), "madkitoptions/ex3_MadkitOptions/myPropertyFile.properties");
	}
}
