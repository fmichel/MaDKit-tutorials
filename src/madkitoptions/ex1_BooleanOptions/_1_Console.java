/**
 * READ ME
 * 
 * presentation à faire
 */

package madkitoptions.ex1_BooleanOptions;

import madkit.kernel.Madkit;

//open a new madkit, with a default console agent on. Notice that we can launch agent in madkit, the notifications also appear in this console agent
// faux par défaut
public class _1_Console {

	 public static void main(String[] args) {
		 new Madkit(Madkit.BooleanOption.console.toString());
	 }
}
