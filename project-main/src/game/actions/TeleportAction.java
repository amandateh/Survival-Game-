package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.execptions.UnavailableTeleportExecption;

import java.util.Random;

/**
 * A class represent an action teleport an actor to different random location
 * @author Hihihi
 */
public class TeleportAction extends Action {
    private final Item item;

    /**
     * Constructor.
     * @param item the item used to teleport actor
     */
    public TeleportAction(Item item)
    {
        this.item = item;
    }

    /**
     * Represent the functionality of the execution of teleportation
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display message
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Random rand = new Random();
        int x = rand.nextInt(map.getXRange().max());
        int y = rand.nextInt(map.getYRange().max());
        try{
            if(map.at(x,y).containsAnActor())
                throw new UnavailableTeleportExecption(actor, map.at(x,y));
            else {
                map.moveActor(actor, map.at(x, y));
                return actor.toString() + " arrived at (" + x + ", " + y + ") in " + map;
            }
        } catch (UnavailableTeleportExecption e) {
            return e.getMessage();
        }
    }

    /**
     * Menu option
     * @param actor The actor performing the action.
     * @return display message
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Teleport with " + item.toString();
    }
}
