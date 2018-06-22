/*
 * https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html?is-external=true
 * 
 * OFF
 * SEVERE (highest value)
 * WARNING
 * INFO
 * CONFIG
 * FINE
 * FINER
 * FINEST (lowest value)  : détaillé
 * ALL
 * 
 */
package madkitoptions.ex2_LevelOptions;

import madkit.kernel.Madkit;

public class _1_MadkitLogLevel {

	 public static void main(String[] args) {
		new Madkit(Madkit.LevelOption.madkitLogLevel.toString(),"ALL");
	 }
}
