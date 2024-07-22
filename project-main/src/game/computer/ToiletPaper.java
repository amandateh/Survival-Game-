package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.GenerateRandom;
import game.SaleableItem;
import game.actions.SellAction;
import game.execptions.InsufficientBalanceException;

import java.util.Random;

/**
 * A class represent one type of computer item
 * @author Hihihi
 */
public class ToiletPaper extends ComputerItem implements SaleableItem {
    private final static String NAME = "Toilet Paper Roll";
    private final static char DISPLAY_CHAR = 's';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 5;
    private final static int CHANCE = 75;
    private final static int LUCKY_PRICE = 1;

    private final static int SPECIAL_SOLD_RATE = 50;
    /***
     * Constructor.
     */
    public ToiletPaper() {
        super(NAME, DISPLAY_CHAR, PORTABLE, PRICE,CHANCE);
    }

    /**
     * Special condition what will happen when actor purchase this item
     * @param actor actor perform the action on the Item
     */
    @Override
    public String special(Actor actor) {
        String result = "";
        Random r = new Random();
        boolean success = false;
        int cost;
        if (CHANCE > r.nextInt(100)){
            cost = LUCKY_PRICE;
            if (checkWallet(actor, LUCKY_PRICE))
            {
                actor.deductBalance(LUCKY_PRICE);
                success = true;
            }
        }
        else
        {
            cost = PRICE;
            if (checkWallet(actor,PRICE))
            {
                actor.deductBalance(PRICE);
                success = true;
            }
        }
        try
        {
            if (success)
            {
                actor.addItemToInventory(this);
                result = result + actor + " successfully bought " + NAME + " for " + cost + " credit.";
            }
            else
            {
                throw new InsufficientBalanceException(actor, cost);
            }
        }catch (InsufficientBalanceException e){
            result = result + e.getMessage() + " (" + e.getActorBalance() + " < " + e.getPrice() + ")";
        }
        return result;
    }

    /**
     * @return A new instance of this class
     */
    @Override
    public ComputerItem getItem() {
        return new ToiletPaper();
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
            actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.DECREASE,
                    actor.getAttribute(BaseActorAttributes.HEALTH));
            result = "Goodbye";
            return result;
        }
        else {
            price = LUCKY_PRICE;
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
