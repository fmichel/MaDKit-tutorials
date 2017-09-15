package logging.ex03b_debugMode;

import java.util.logging.Level;

import madkit.kernel.Agent;


public class LaunchAtTheSameTime extends Agent{

	protected void live(){
		int nb = 10;
		Level l = getLogger().getLevel();
		while ((nb-- > 0) && (l != Level.ALL)) {
			{
				pause(1000);
				l = getLogger().getLevel();
				getLogger().config("Living... I will quit in " + nb + " seconds");
			}
		}
		l = getLogger().getLevel();
		if (l == Level.ALL){
			getLogger().talk("\n");
			getLogger().finest("If you see this message then you find the button debug mode !\n");
			pause(10000);
		}
	}
}
