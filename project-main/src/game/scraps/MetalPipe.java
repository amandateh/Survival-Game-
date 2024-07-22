package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Ability;
import game.SaleableItem;
import game.actions.SellAction;
import game.actions.AttackAction;
import game.Status;

/**
 * metal pipe is a weapon item have damage 1 and 20 hit rate
 * @author GAO HAO
 */
public class MetalPipe extends WeaponItem implements SaleableItem {
    private final static String NAME = "Metal Pipe";

    private final static char DISPLAY_CHAR = '!';

    private final static int DAMAGE = 1;

    private final static String VERB = "taps";

    private final static int HIT_RATE = 20;

    private final static int PRICE = 35;
    /***
     * Constructor.
     * '!' represent a large bolt in the game map
     */
    public MetalPipe() {
        super(NAME, DISPLAY_CHAR, DISPLAY_CHAR, VERB, HIT_RATE);
    }

    /**
     * return an action list contains attack action when a hostile creature nearby
     * and when a seller nearby, it can be sold
     * @param otherActor the other actor which can be attack by this actor
     * @param location the location of the other actor
     * @return an action list
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if ((!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) &
                (!otherActor.hasCapability(Status.CANNOT_BE_ATTACKED)))
        {
            actions.add(new AttackAction(otherActor, location.toString(), this));
        }

        if (otherActor.hasCapability(Ability.SALEABLE_IN)){
            actions.add(new SellAction(this));
        }
        return actions;
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
        result =  actor + " sells " + this + " for " + PRICE + " credits";
        return result;
    }

}
