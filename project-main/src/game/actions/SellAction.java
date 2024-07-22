package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.SaleableItem;

/**
 * a class represent an action when an item is sold
 * @author Hihihi
 */
public class SellAction extends Action {

    private static final String DESC = "sells";
    private final SaleableItem item;

    /**
     * constructor
     * @param item the item will be sold
     */
    public SellAction(SaleableItem item){
        this.item = item;
    }

    /**
     * when the action execute, each item will show different functionality
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return completion message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return this.item.be_sold(actor);
    }

    /**
     * the message show in the menu
     * @param actor The actor performing the action.
     * @return show up message
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " " + DESC + " " + item;
    }
}
