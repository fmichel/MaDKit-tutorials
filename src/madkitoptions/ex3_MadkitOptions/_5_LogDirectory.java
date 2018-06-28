package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

public class _5_LogDirectory {

	public static void main(String[] args) {
		new Madkit(Madkit.BooleanOption.createLogFiles.toString(), "true", Madkit.Option.logDirectory.toString(), "newDirectory/");
	}
}
