package madkitoptions.ex3_MadkitOptions;

import madkit.kernel.Madkit;

/**
 * This option allows MaDKit users to
 * change MaDKit desktop's display.
 * 
 * Of course, desktopFrameClass need to be associated with an existing 
 * class, here _3_CustomDesktopFrame.
 * 
 * 
 * #jws# madkitoptions.ex3_MadkitOptions._3_DesktopFrameClass #jws#
 * #args# #args#
 * 
 */

public class _3_DesktopFrameClass {
	
	public static void main(String[] args) {
		new Madkit(Madkit.Option.desktopFrameClass.toString(), _3_CustomDesktopFrame.class.getName());
	}
}
