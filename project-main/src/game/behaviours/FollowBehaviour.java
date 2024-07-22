package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.GenerateRandom;

import java.util.ArrayList;
import java.util.List;


/**
 * A class represent a follow behaviour which normally performed by a non-player Actor
 * @author Hihihi
 */
public class FollowBehaviour implements Behaviour {
    private Actor target;

    /**
     * When an actor near this actor, it will make this actor as a target and keep following its target until its died or game end
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return A moveActorAction if it has a target to follow, or return null if it misses its target
     * Also, return a doNothingAction when it first detects that there is a nearby actor and make this actor as a target
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (this.target != null) {
            // To get the exits of the target
            List<Exit> target_exits = map.locationOf(target).getExits();
            // To get the exits of itself
            List<Exit> own_exits = map.locationOf(actor).getExits();
            // A list of exits
            List<Exit> exits_consistent = new ArrayList<>();
            // Add common exits to the exits_consistent represent the common exits between itself and the target.
            for (Exit target_exit : target_exits) {
                for (Exit own_exit : own_exits) {
                    // Same location and no actor currently on that location
                    if (target_exit.getDestination() == own_exit.getDestination()
                            & !own_exit.getDestination().containsAnActor()
                            & own_exit.getDestination().canActorEnter(actor))
                    {
                        exits_consistent.add(own_exit);
                    }
                }
            }
            if (exits_consistent.size() > 0) {
                Exit exit = exits_consistent.get(GenerateRandom.generateRandomInteger(0, exits_consistent.size()));
                return exit.getDestination().getMoveAction(actor, exit.getName(), exit.getHotKey());
            }
            else {
                target = null;
                return null;
            }
        }
        else {
            Location location = map.locationOf(actor);
            for (Exit exit : location.getExits()) {
                Location destination = exit.getDestination();
                if (destination.containsAnActor()) {
                    if (destination.getActor().hasCapability(Ability.CAN_BE_FOLLOWED)) {
                        this.target = destination.getActor();
                        return new DoNothingAction();
                    }
                }
            }
        }
        return null;
    }
}
