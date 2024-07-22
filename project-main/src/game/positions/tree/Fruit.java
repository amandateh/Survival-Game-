package game.positions.tree;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;

/**
 * Fruit represent a fruit in the game
 * @author GAO HAO
 */
public abstract class Fruit extends Item implements ConsumableItem{

    /**
     * the hp this fruit can heal
     */
    public final int healHp;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param hp the heal Point of fruit
     */
    public Fruit(String name, char displayChar, int hp) {
        super(name, displayChar, true);
        this.healHp = hp;
    }

    /**
     * when the Fruit is consumed by its owner,
     * it will be removed from the inventory and heal the owner.
     * @param actor the actor have the fruit
     * @return consume message
     */
    @Override
    public String consume(Actor actor){
        String returnSrting = "";
        actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, healHp);
        actor.removeItemFromInventory(this);
        returnSrting = returnSrting + actor + " consumes " + this + " and " + this
                + " heals " + actor +  " by " + healHp + " points.";
        return returnSrting;
    }

    /**
     * when the fruit in the inventory of an actor,
     * it will return a list of action to its owner
     * @param owner the actor that owns the item
     * @return action list it can be used
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * A method to get a new instance of corresponding classes
     * @return an instance of fruit
     */
    public abstract Fruit getFruit();
}
