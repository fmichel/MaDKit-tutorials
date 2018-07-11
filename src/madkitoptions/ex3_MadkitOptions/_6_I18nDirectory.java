package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

/**
 * This option allows MaDKit users to specify
 * the directory in which the i18n (internationalization)
 * files are stored.
 * 
 * Of course, if the path leading to the wanted directory
 * is wrong, an error is thrown.
 * 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._6_I18nDirectory #jws#
 * #args# #args#
 * 
 */

public class _6_I18nDirectory {
	 
	public static void main(String[] args) {
		
		/* Here the wanted directory is : toto */
		new Madkit(Madkit.Option.i18nDirectory.toString(), "toto");
	}
}
