package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.positions.tree.ConsumableItem;
import game.positions.tree.ConsumeAction;

/**
 * A class that represents the floor inside a building.
 * @author Hihihi
 */
public class Puddle extends Ground implements ConsumableItem {
    private final static int CONSUME_VALUE = 1;

    /**
     * Constructor
     */
    public Puddle() {
        super('~');
    }

    /**
     * @return string display the consume verb
     */
    @Override
    public String getVerb() {
        return "drinks";
    }

    /**
     *
     * @param actor the actor who perform consume
     * @return display message
     */
    @Override
    public String consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, CONSUME_VALUE);
        return "THE PUDDLE OF WATER IS SO REFRESHING!!";
    }

    /**
     * Allowable action Actor can perform on this ground (it is actually as an Item in the game)
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A ActionList which consists of all action actor can perform.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.getActor() == actor) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    /**
     *
     * @return display message of this ground
     */
    @Override
    public String toString() {
        return "Puddle";
    }

}
