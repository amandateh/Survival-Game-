package game.positions.tree;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * ConsumeAction represent an action to consume a ConsumableItem
 * @author GAO HAO
 */
public class ConsumeAction extends Action {

    /**
     * the item will be consumed in this action
     */
    private final ConsumableItem item;

    /**
     * constructor
     * @param item an consumable item
     */
    public ConsumeAction(ConsumableItem item) {
        this.item = item;
    }

    /**
     * when executed,
     * the actor consume the consumable item.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return this.item.consume(actor);
    }

    /**
     * show this action in user interface
     * @param actor The actor performing the action.
     * @return the description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " "+ item.getVerb() +" " + item;
    }
}
