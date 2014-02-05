package logging.ex03b_debugMode;

import java.util.logging.Level;

import madkit.kernel.Agent;

@SuppressWarnings("serial")
public class LaunchAtTheSameTime extends Agent{

	protected void live(){
		int nb = 10;
		Level l = logger.getLevel();
		while ((nb-- > 0) && (l != Level.ALL)) {
			if (logger != null){
				pause(1000);
				l = logger.getLevel();
				logger.config("Living... I will quit in " + nb + " seconds");
			}
		}
		l = logger.getLevel();
		if (l == Level.ALL){
			logger.talk("\n");
			logger.finest("If you see this message then you find the button debug mode !\n");
			pause(10000);
		}
	}
}
