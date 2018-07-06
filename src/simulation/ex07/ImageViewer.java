package simulation.ex07;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import simulation.ex06.SituatedAgent;
import simulation.ex06.Viewer;

/**
 * 
 * 
 * #jws# simulation.ex07.MySimulationModel07 #jws#
 * #args# --launchAgents simulation.ex07.MySimulationModel07 #args# 
 * 
 * We can of course use images to represent the agents.
 */
public class ImageViewer extends Viewer {

    /**
     * Taking an image used in another tutorial
     */
    private final Image car = new ImageIcon(getClass().getResource("/gui/ex03_customPanel/agent.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

    /**
     * render is the method where the custom painting has to be made. Here, we use the image at the agents' location
     */
    @Override
    protected void render(Graphics g) {
    	for (SituatedAgent a : agentsLocationProbe.getCurrentAgentsList()) {
    		Dimension location = agentsLocationProbe.getPropertyValue(a);
    		g.drawImage(car, location.width, location.height, null);
    	}
    }
}
