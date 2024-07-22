package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.positions.gameMaps.TraversalMap;

/**
 * A class represent an actor travel through different maps
 * @author Hihihi
 */
public class TravelAction extends Action {
    private final TraversalMap destination;

    /**
     * Constructor.
     * @param destination the GameMap actor travel to
     */
    public TravelAction(TraversalMap destination)
    {
        this.destination = destination;
    }

    /**
     * Actor removed from current map and add to a specific location of another map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        destination.addActor(actor, destination.at(destination.getTerminalX(), destination.getTerminal_y()));
        return "Teleported " + actor + " to " +
                destination + " (" + destination.getTerminalX() + ", " + destination.getTerminal_y() + ")";
    }

    /**
     * Menu option
     * @param actor The actor performing the action.
     * @return display message
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " travels to " + destination.toString();
    }
}
