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
package gui.ex05_multi_GUI;

import gui.ex03_customPanel.CustomPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to build a totally independent GUI while still
 * using a default GUI for the agent.
 * 
 * 		#jws gui.ex05_multi_GUI.MultiGUI jws#
 * 
 * The idea is that it could be interesting to have several GUI for an agent:
 * A main and the default which could be used as a console for the agent.
 * 
 */
@SuppressWarnings("serial")
public class MultiGUI extends Agent {

	private JFrame	myFrame;

	/**
	 * building my own GUI here
	 */
	@Override
	protected void activate() {
		myFrame = new JFrame("My GUI");
		myFrame.add(new JLabel(new ImageIcon(CustomPanel.class.getResource("agent.png"))), BorderLayout.CENTER);
		myFrame.setSize(400, 500);
		myFrame.setLocation(100,100);// centered
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
	
	/**
	 * But still customizing the default GUI if activated
	 */
	@Override
	public void setupFrame(JFrame frame) {
		super.setupFrame(frame);
		frame.setLocation(500, 100);
	}

	@Override
	protected void live() {
		if (logger != null)
			logger.info("\n\tI have defined my personnal frame,\n\tbut this is displayed in my default GUI");
		pause(6000);
	}

	/**
	 * I have to close the frame myself
	 * because its life cycle is not managed by
	 * the MaDKit kernel.
	 */
	@Override
	protected void end() {
		myFrame.dispose();
	}

	/**
	 * @param argss unused here
	 */
	public static void main(String[] argss) {
		String[] args = { "--launchAgents", MultiGUI.class.getName() + ",true" };
		Madkit.main(args);
	}

}
