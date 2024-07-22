package game.execptions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;


/**
 * A class represent an exception that actor can not teleport to here
 * @author Hihihi
 */
public class UnavailableTeleportExecption extends Exception{
    private final static String MESSAGE = "Actor can't be teleported to this place";
    /**
     * actor who pay the price
     */
    private final Actor actor;
    /**
     * Location of the actor
     */
    private final Location location;

    /**
     * Constructor.
     * @param actor the actor perform the teleport
     * @param location the location to teleport
     */
    public UnavailableTeleportExecption(Actor actor, Location location){
        super(MESSAGE);
        this.actor = actor;
        this.location = location;
    }

    /**
     * Getter for attribute actor
     * @return an actor
     */
    public Actor getActor()
    {
        return actor;
    }

    /**
     * Getter for attribute location
     * @return a location
     */
    public Location getLocation()
    {
        return location;
    }
}
