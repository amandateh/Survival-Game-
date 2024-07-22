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

/**
 * A class represent one type of consumable item
 * @author Hihihi
 */
public class PotOfGold extends Item implements ConsumableItem, SaleableItem {
    private final static int CONSUME_VALUE = 10;
    private final static String NAME = "Pot of Gold";
    private final static char DISPLAY_CHAR = '$';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 500;
    private final static int MAGIC_PRICE = 0;
    private final static int SPECIAL_SOLD_RATE = 25;


    /***
     * Constructor.
     */
    public PotOfGold() {
        super(NAME, DISPLAY_CHAR, PORTABLE);

    }

    /**
     * All actions one actor can perform with this Item
     * @param owner the actor that owns the item
     * @return A ActionList
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * @return A string display how this item will be consumed
     */
    @Override
    public String getVerb() {
        return "takes out money from";
    }

    /**
     * Basic functionality when actor consume this item
     * @param actor the actor who consume this item
     * @return A display message
     */
    @Override
    public String consume(Actor actor) {
        actor.addBalance(CONSUME_VALUE);
        actor.removeItemFromInventory(this);
        return "OMG GOT MONEY!! $" + CONSUME_VALUE + " has been added to wallet";
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
