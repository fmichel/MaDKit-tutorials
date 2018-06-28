package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

public class _3_DesktopFrameClass {
	
	public static void main(String[] args) {
		new Madkit(Madkit.Option.desktopFrameClass.toString(), _3_CustomDesktopFrame.class.getName());
		//activates CGR warnings for the logging of the agents. see AgentLogger.enableCGRWarnings()
	}
}
