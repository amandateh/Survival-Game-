package game.positions.tree;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.SaleableItem;
import game.actions.SellAction;

/**
 * LargeFruit represent a fruit that can heal 2 hp to its owner
 * 'O' represent it in the game map
 * @author GAO HAO
 */
public class LargeFruit extends Fruit implements SaleableItem {

    private final static char DISPLAY_CHAR = 'O';
    private final static String NAME = "Large Fruit";

    private final static int HP = 2;
    private final static int PRICE = 30;

    /**
     * Constructor,
     */
    public LargeFruit(){
        super(NAME, DISPLAY_CHAR, HP);
    }

    @Override
    public String getVerb() {
        return "eats";
    }

    /**
     * @return A new instance of this class
     */
    public Fruit getFruit()
    {
        return new LargeFruit();
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

