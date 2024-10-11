package helloworld.ex01;

import madkit.kernel.Agent;

/**

 As of MaDKit-5, one source file can be enough to launch a MAS.

 Here we just :

 1. extend the madkit.kernel.Agent class (the MaDKit's threaded agent class).
 2. override its live method.
 3. launch the agent using executeThisAgent() within the main method.

 */

public class HelloWorldAgent extends Agent {
    
    @Override
    protected void live() {
	getLogger().info("\t Hello World! \n"); // This has several advantages over using System.out.println().
													// There is a tutorial about the logging mechanism of MaDKit-5.
	for (int i = 10; i > 0; i--) {
	    getLogger().info("Living... I will quit in " + i + " seconds");
	    pause(1000); // pauses the agent's thread for 1000 ms
	}
    }

	/** live() here is a method which is called automatically. It will be explained later in the next tutorial
	 * ex03(agentlifecycle) **/

    public static void main(String[] args) {
	executeThisAgent(); // a convenient static method for easily launching agents using an IDE
    }

	/**

	 Implementing a main method within an agent's class is not required at all but it could be
	 used to simulate a command line call to MaDKit with the desired options.

	 For this example, the corresponding command line is as follows (assuming a correct classpath)

	 > java madkit.kernel.MaDKit --launchAgents helloworld.ex01.HelloWorldAgent,true

	 Here we just use the executeThisAgent() method inside the main method
	 so that the launching is greatly simplified using an IDE.

	 Here we could also have used:

	 public static void main(String[] args) {
	 new Madkit("--launchAgents", "helloworld.ex01.HelloWorldAgent,true");
	 }

	 Or

	 public static void main(String[] args) {
	 String[] args2 = { "--launchAgents", "helloworld.ex01.HelloWorldAgent,true" };
	 Madkit.main(args2);
	 }

	 All of these calls are equivalent.

	 */
}