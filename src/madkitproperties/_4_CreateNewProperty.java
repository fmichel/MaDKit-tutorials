package madkitproperties;

import madkit.kernel.Madkit;

public class _4_CreateNewProperty {

	public static void main(String[] args) {
		new Madkit("--myNewProperty", "aNewValue",Madkit.LevelOption.madkitLogLevel.toString());
	}
}
