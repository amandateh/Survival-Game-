package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.GenerateRandom;
import game.SaleableItem;
import game.actions.SellAction;
import game.positions.tree.ConsumableItem;
import game.positions.tree.ConsumeAction;

import java.util.Random;

/**
 * A class represent one consumable Item
 * @author Hihihi
 */
public class JarPickles extends Item implements ConsumableItem, SaleableItem {
    private final static int CONSUME_VALUE = 1;
    private final static String VERB = "eats";
    private final static String NAME = "Jar of Pickles";
    private final static char DISPLAY_CHAR = 'n';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 25;
    private final static int MAGIC_PRICE = 50;
    private final static int SPECIAL_SOLD_RATE = 50;

    /***
     * Constructor.
     */
    public JarPickles() {
        super(NAME, DISPLAY_CHAR, PORTABLE);
    }

    /**
     * @return A string display how this item will be consumed
     */
    @Override
    public String getVerb() {
        return VERB;
    }

    /**
     * Basic functionality when actor consume this item
     * @param actor the actor who consume this item
     * @return A display message
     */
    @Override
    public String consume(Actor actor) {
        Random r = new Random();
        boolean chance = r.nextBoolean();
        if(chance) {
            actor.heal(CONSUME_VALUE);
            actor.removeItemFromInventory(this);
            return "CONSUMED FRESH JAR PICKLES";
        }
        else {
            actor.hurt(CONSUME_VALUE);
            actor.removeItemFromInventory(this);
            return "CONSUMED EXPIRED JAR PICKLES";
        }

    }

    /**
     * All actions an actor can perform with this item
     * @param owner the actor that owns the item
     * @return A ActionList
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /** a method represent the functionality when this item is sold by the actor
     * @param actor the actor who sell it
     * @return display message when consuming
     */
    @Override
    public String be_sold(Actor actor) {
        int price;
        String result;
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
