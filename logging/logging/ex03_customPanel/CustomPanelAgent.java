/*
 * Copyright 2011-2012 Fabien Michel
 * 
 * This file is part of MaDKit-tutorials.
 * 
 * MaDKit-tutorials is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MaDKit-tutorials is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MaDKit-tutorials. If not, see <http://www.gnu.org/licenses/>.
 */
package gui.ex03_customPanel;

import java.awt.BorderLayout;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import madkit.gui.OutputPanel;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to set a custom panel with the frame given by the default GUI mechanism of MaDKit 5
 * 
 */
@SuppressWarnings("serial")
public class CustomPanelAgent extends Agent {
	
	
	@Override
	public void setupFrame(JFrame frame) {
		JPanel p = new JPanel(new BorderLayout());
		//customizing but still using the OutputPanel from MaDKit GUI
		p.add(new OutputPanel(this),BorderLayout.CENTER);
		p.add(new JLabel(new ImageIcon(getClass().getResource("agent.png"))),BorderLayout.NORTH);
		p.validate();
		frame.add(p);
		frame.setTitle("Overring Default Frame Behavior");
		frame.setLocation(200, 0);
		frame.setSize(400, 500);
	}

	@Override
	protected void activate() {
		setLogLevel(Level.FINE);
		//The following log will be both in the console and in the default GUI
		if(logger != null)
			logger.info("I am in the activation phase");
		// the level "talk" can be used to print without any formatting whatever the log level
		if(logger != null)
			logger.talk("\nI am talking \n\n");
	}
	
	@Override
	protected void live() {
		//setting this log level enables to see all agent default API operations 
		setLogLevel(Level.FINEST);		
		waitNextMessage(1000);//will be logged because of FINEST
	}
	
	@Override
	protected void end() {
		requestRole("test", "test", "test");//should be log too and also produces a warning
		setLogLevel(Level.INFO);
		getLogger().setWarningLogLevel(Level.FINEST);
		requestRole("test", "test", "test");//no log and no warning
		if(logger != null)
			logger.talk("\nI am talking \n\n");
		waitNextMessage(10000);//waiting the kill  just to see the result
	}
	/**
	 * @param args
	 */
	public static void main(String[] argss) {
		String[] args = {"--launchAgents",CustomPanelAgent.class.getName()+",true"};
		Madkit.main(args);
	}

}
