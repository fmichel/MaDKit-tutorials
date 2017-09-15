package helloworld.ex02_Desktop;

import madkit.kernel.Madkit;

/**
 * Here, we just start the previous agent but also using the desktop mode of MaDKit.
 * 
 * 
 * 
 * #jws helloworld.ex02_Desktop.DesktopHelloWorld jws#
 * 
 * 
 * 
 * The Desktop is a GUI front end embedding the agents and which features different actions that can help developing MAS
 * applications. The Desktop do not quit when there is no active agent, contrary to the first example.
 */
public class DesktopHelloWorld {

    /**
     * The only thing to do is to pass the --desktop parameter to the main method of MaDKit.
     * 
     * @param args
     *            useless in this example
     */
    public static void main(String[] args) {
	String[] args2 = { "--desktop", "--launchAgents", "helloworld.ex01.HelloWorldAgent,true" };
	Madkit.main(args2);
    }

    /*
     * What we used here is exactly the same as : String[] argss =
     * {BooleanOption.desktop.toString(),Madkit.Option.launchAgents.toString(),HelloWorldAgent.class.getName()+",true"};
     * Madkit.main(argss);
     */

}
