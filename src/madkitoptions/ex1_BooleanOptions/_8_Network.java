package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

public class _8_Network {

	 public static void main(String[] args) {
		 // false par défaut
		 new Madkit(Madkit.BooleanOption.network.toString(),"true");
		 
		 // notice the difference : no connection, no text
		 // new Madkit(Madkit.BooleanOption.network.toString(),"false");
	 }

}
