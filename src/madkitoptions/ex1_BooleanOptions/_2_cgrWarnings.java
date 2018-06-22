package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

public class _2_cgrWarnings {

	 public static void main(String[] args) {
		 new Madkit(Madkit.BooleanOption.cgrWarnings.toString(),"false", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
		 //new Madkit(Madkit.BooleanOption.cgrWarnings.toString(),"true", Madkit.Option.launchAgents.toString(), _2_Agent.class.getName() + " ,true,1");
	 }
}
