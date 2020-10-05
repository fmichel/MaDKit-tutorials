package helloworld.ex05;

import madkit.kernel.Madkit;

/**
  Here, we just test the desktop mode of MaDKit-5.
  
  	#jws# helloworld.ex05.DesktopHelloWorld #jws#
  	#args# --desktop --launchAgents helloworld.ex01.HelloWorldAgent,true,1 #args#
  
  The Desktop is a GUI front end embedding the agents and which features different actions that can help developing 
  applications. The Desktop do not quit when there is no more active agents, contrary to all the previous examples.
 */
public class DesktopHelloWorld {

    /**

      The only thing to do is to pass the --desktop parameter to the main method of MaDKit.
     
     */
    public static void main(String[] args) {
	String[] args2 = { "--desktop", "--launchAgents", "helloworld.ex01.HelloWorldAgent,true" };
	Madkit.main(args2);
    }

    /*
      What we used here is exactly the same as : 
    public static void main(String[] args) {
      String[] argss = {BooleanOption.desktop.toString(),Madkit.Option.launchAgents.toString(),HelloWorldAgent.class.getName()+",true"};
      Madkit.main(argss);
   }
     */

}
