package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.SaleableItem;
import game.actions.SellAction;


/**
 *  a class represent a large bolt scraps in the game world
 * @author GAO HAO
 */
public class LargeBolt extends Item implements SaleableItem {
    private final static String NAME = "Large Bolt";
    private final static char DISPLAY_CHAR = '+';

    private final static int PRICE = 25;

    /**
     *  constructor
     *  '+' represent a large bolt in the game map, and it can be picked up and dropped off
     */
    public LargeBolt() {
        super(NAME, DISPLAY_CHAR, true);
    }

    /** a method represent the functionality when this item is sold by the actor
     * @param actor the actor who sell it
     * @return display message when consuming
     */
    @Override
    public String be_sold(Actor actor) {
        String result;
        actor.removeItemFromInventory(this);
        actor.addBalance(PRICE);
        result = actor + " sells " + this + " for " + PRICE + " credits";
        return result;
    }

    /**
     * the method represent it can be sold to a seller when a seller nearby
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a sell action
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.SALEABLE_IN)){
            actions.add(new SellAction(this));
        }
        return actions;
    }
}