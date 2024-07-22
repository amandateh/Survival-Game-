package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.GenerateRandom;
import game.SaleableItem;
import game.actions.SellAction;

import javax.print.attribute.standard.MediaSize;


/**
 *  a class represent a large bolt scraps in the game world
 * @author GAO HAO
 */
public class MetalSheet extends Item implements SaleableItem {
    private final static String NAME = "Metal Sheet";
    private final static char DISPLAY_CHAR = '%';

    private final static int PRICE = 20;
    private final static int MAGIC_PRICE = 10;
    private final static int SPECIAL_SOLD_RATE = 60;

    /**
     *  constructor
     *  '%' represent a large bolt in the game map, and it can be picked up and dropped off
     */
    public MetalSheet(){
        super(NAME, DISPLAY_CHAR, true);
    }

    /** a method represent the functionality when this item is sold by the actor
     * @param actor the actor who sell it
     * @return display message when consuming
     */
    @Override
    public String be_sold(Actor actor) {
        String result;
        int price;
        if (GenerateRandom.generateRandomInteger(0, 100) < SPECIAL_SOLD_RATE){
            price = MAGIC_PRICE;
        }
        else {
            price = PRICE;
        }
        actor.removeItemFromInventory(this);
        actor.addBalance(price);
        result = actor + " sells " + this + " for " + price + " credits";
        return result;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.SALEABLE_IN)){
            actions.add(new SellAction(this));
        }
        return actions;
    }
}


