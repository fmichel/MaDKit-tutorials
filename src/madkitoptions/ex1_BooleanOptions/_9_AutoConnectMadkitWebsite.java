package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

public class _9_AutoConnectMadkitWebsite {

	 public static void main(String[] args) {
		 // default value : false
		 // new Madkit(Madkit.BooleanOption.autoConnectMadkitWebsite.toString(), "true");
		 // see the difference
		 new Madkit(Madkit.BooleanOption.autoConnectMadkitWebsite.toString(), "false");
	 }

}
