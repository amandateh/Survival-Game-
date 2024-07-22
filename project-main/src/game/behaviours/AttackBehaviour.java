package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.Status;

/**
 * this class represent an attack behaviour of an NPC actor,
 * if the NPC has an attack behaviour, it can perform an attack action
 * @author GAO HAO
 */
public class AttackBehaviour implements Behaviour {
    /**
     * if a hostile creature near it, it will perform an attack action to this that
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an attack action with its weapon or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()){
            Location destination = exit.getDestination();
            if(destination.containsAnActor())
            {
                if(destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY) &
                        (!destination.getActor().hasCapability(Status.CANNOT_BE_ATTACKED)))
                {
                    return new AttackAction(destination.getActor(), exit.getHotKey());
                }
            }
        }
        return null;
    }
}
