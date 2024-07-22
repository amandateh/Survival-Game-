package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.computer.ComputerItem;

/**
 * A class represent an action to print
 * @author Hihihi
 */
public class PrintItemAction extends Action {
    private final ComputerItem item;

    /**
     * Constructor.
     * @param item the item to be printed
     */
    public PrintItemAction(ComputerItem item){
        this.item = item;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display message of successful payment made by actor
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return item.special(actor);
    }

    /**
     * Display message of this action in the menu
     * @param actor The actor performing the action.
     * @return display message
     */
    @Override
    public String menuDescription(Actor actor) {
        return "BUY " + item;
    }
}
