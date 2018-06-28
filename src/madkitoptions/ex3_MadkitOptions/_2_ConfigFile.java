package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

//for more detail about prop file see the dedicated tutorial

public class _2_ConfigFile {

	public static void main(String[] args) {
		new Madkit(Madkit.Option.configFile.toString(), "madkitoptions/ex3_MadkitOptions/myPropertyFile.properties");
		//activates CGR warnings for the logging of the agents. see AgentLogger.enableCGRWarnings()
	}
}
