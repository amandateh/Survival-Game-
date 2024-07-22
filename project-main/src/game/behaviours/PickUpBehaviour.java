package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.GenerateRandom;

/**
 * A class represent a pickup action which normally preformed by non-player Actor
 * @author Hihihi
 */
public class PickUpBehaviour implements Behaviour {
    /**
     * When there is an Item on the location this actor currently stands on,
     * it will pick up this Item and put this item into its itemInventory
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return An PickUpAction if there is any item at the location of actor, or null -> no item
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        if(location.getItems().size() > 0)
        {
            Item item = location.getItems().get(GenerateRandom.generateRandomInteger(0, location.getItems().size()));
            return new PickUpAction(item);
        }
        else
        {
            return null;
        }
    }
}
