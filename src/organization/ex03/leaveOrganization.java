package organization.ex03;

import static organization.ex03.Society03.COMMUNITY;
import static organization.ex03.Society03.GROUP;

import madkit.kernel.Agent;

/** In this final exercise, we will see how an agent can leave a group.*/

public class leaveOrganization extends Agent {


    protected void activate () {
        createGroupIfAbsent(COMMUNITY,GROUP); //Creates a new Group within a community but does not produce any warning
                                                // if the group already exists.

    }

    protected void live() {



        getLogger().info("\n\t I am the agent who is in the community "+ COMMUNITY +"\n and the group "
                + GROUP +"\n\n");
        pause(500);

        getLogger().info("\n\t But I will now leave this group :(\n\n");
        pause(500);

        //leaveGroup method allow the agent to leave the group
        ReturnCode bool = leaveGroup(COMMUNITY,GROUP);


        if (bool != ReturnCode.SUCCESS) {
            //If the group doesn't exist or the agent isn't in the group, the leaveGroup method will return an error
            getLogger().info("\n\t I can't leave ! there is an error somewhere\n\n");
        }
        else {
            //The agent leaved the group successfully
            getLogger().info("\n\t I leaved successfully !\n\n");
        }

        pause(15000);
    }

    public static void main(String[] argss) {

        executeThisAgent(1, true);
    }
}
