package organization.ex02;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.AgentAddress;

import static organization.ex02.Society02.*;

/** In this exercise, we will take a look on the Role of an agent in a Community.
 * When we have more than 1 agent in a Community, they must be identified using the getAgentWithRole method.
 * Then, we can make them interact, but this part will be explain in the tutorial Communication.
 */

public class createOrganizationWithRole extends Agent {

    protected void activate() {

        // Thanks to this log level, everything the agent does in the artificial
        // society will be automatically logged
        getLogger().setLevel(Level.FINEST);

        createGroup(COMMUNITY,GROUP);

        //Requests a role within a group of a particular community.
        requestRole(COMMUNITY,GROUP,ROLE);

        pause(500);

    }

    protected void live() {

        // now getting the address of a partner using getAgentWithRole
        AgentAddress other = null;
        while (other == null) {
            // This way, I wait for another coming into play
            other = getAgentWithRole(COMMUNITY, GROUP, ROLE);
            pause(1000);
        }

        getLogger().info("\n\t I am the agent who is in the community "+ COMMUNITY +"\n and the group "
                + GROUP +" and the role "+ROLE+"\n\n");
        getLogger().info("\n\tI found someone !!\n" + other + "\n\n");
        pause(15000);
    }

    public static void main(String[] argss) {
        executeThisAgent(2, true);
    }
}
