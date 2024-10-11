package madkitoptions.ex3_MadkitOptions;

import java.awt.Color;

import madkit.gui.MDKDesktopFrame;
import madkit.kernel.Madkit;

/**
 * This option allows MaDKit users to
 * change MaDKit desktop's display.
 * 
 * Of course, desktopFrameClass need to be associated with an existing 
 * class, here _3_CustomDesktopFrame.
 * 
 * 
 * 
 */

public class _3_DesktopFrame extends MDKDesktopFrame{

	public _3_DesktopFrame() {
		super();
		setBackground(Color.BLUE);
	}
	
	public static void main(String[] args) {
		new Madkit(Madkit.Option.desktopFrameClass.toString(), _3_DesktopFrame.class.getName());
	}
}
