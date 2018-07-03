package madkitproperties;

import madkit.kernel.Madkit;

public class _2_ToStringEquivalent {

	public static void main(String[] args) {
		new Madkit(Madkit.LevelOption.madkitLogLevel.toString());
		//is equivalent to
		new Madkit("--madkitLogLevel");
	}
}
