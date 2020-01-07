package organization.ex01;


import static organization.ex01.Society.COMMUNITY;
import static organization.ex01.Society.GROUP;

import madkit.kernel.Agent;

/**
 * We will explain in this tutorial how to create an artificial society where agents can exchange messages. Basics
 * elements of a society will be explain through different exercises.
 *
 * An artificial society is a group where agents can interact between them.
 *
 * This exercise will talk about the creation of an artificial society using a community and a group.
 * */



public class createOrganization extends Agent{

    protected void activate() {

        /** First, we need to create a group, related with the values that were written in the Society class */

        createGroup(COMMUNITY,GROUP); //Creates a group within a community. If the community doesn't exist,
                                        //it will be created

    }

    protected void live() {

        /** Now, the agent will say which group and community he belongs to */

        getLogger().info("\n\t I am the agent who is in the community "+ COMMUNITY +"\n and the group "
                + GROUP +"\n\n");
        pause(15000);
    }

    public static void main(String[] argss) {
        executeThisAgent(1, true);
    }
}
