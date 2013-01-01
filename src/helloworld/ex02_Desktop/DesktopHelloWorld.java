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
package helloworld.ex02_Desktop;

import madkit.kernel.Madkit;

/**
 * Here, we just start the previous agent but
 * also using the desktop mode of MaDKit.
 * 
 * 		#jws helloworld.ex02_Desktop.DesktopHelloWorld jws#
 * 
 * 
 * The Desktop is a GUI front end embedding the agents and
 * which features different actions that can help developing
 * MAS applications.
 * 
 * The Desktop do not quit when there is no active agent,
 * contrarily to the first example.
 * 
 */
public class DesktopHelloWorld {

	/**
	 * The only thing to do is to add the --desktop parameter
	 * to the main method of MaDKit.
	 * 
	 * @param args useless in this example
	 */
	public static void main(String[] args) {
		String[] args2 = { "--desktop", "--launchAgents",
				"helloworld.ex01.HelloWorldAgent,true" };
		Madkit.main(args2);
	}

	/*
	 * What we used here is exactly the same as :
	 * 
	 * String[] argss = {BooleanOption.desktop.toString(),Madkit.Option.launchAgents.toString(),HelloWorldAgent.class.getName()+",true"};
	 * Madkit.main(argss);
	 */

}
