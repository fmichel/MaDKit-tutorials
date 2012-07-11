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
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import madkit.gui.OutputPanel;
import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * Shows how to set a custom panel to the default frame.
 * 
 * 		#jws gui.ex03_customPanel.CustomPanel jws#
 * 
 * In this example, we customize the default frame layout.
 * Doing so, we still use the madkit.gui.OutputPanel component
 * to ease the work.
 * 
 * @version 0.9
 * @author Fabien Michel
 */
@SuppressWarnings("serial")
public class CustomPanel extends Agent {

	@Override
	public void setupFrame(JFrame frame) {
		JPanel p = new JPanel(new BorderLayout());

		// customizing but still using the madkit.gui.OutputPanel component
		JPanel talkPanel = new OutputPanel(this);
		talkPanel.setBackground(Color.LIGHT_GRAY);
		p.add(talkPanel, BorderLayout.CENTER);
		
		p.add(new JLabel(new ImageIcon(getClass().getResource("agent.png"))), BorderLayout.NORTH);

		frame.add(p);
		frame.setLocation(200, 0);
		frame.setSize(400, 500);
	}

	@Override
	protected void live() {
		if (logger != null)
			logger.info("\n\tDo you see my customized panel ?");
		pause(5000);
	}

	/**
	 * @param argss
	 */
	public static void main(String[] argss) {
		String[] args = { "--launchAgents", CustomPanel.class.getName() + ",true" };
		Madkit.main(args);
	}

}
