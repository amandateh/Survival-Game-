package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author GAO HAO
 *
 */
public class Floor extends Ground {
    /**
     * Constructor.
     */
    public Floor() {
        super('_');
    }

    /**
     * Any actor with specific ability can enter floor
     * @param actor the Actor to check
     * @return a boolean determine whether the actor can enter the floor
     */
    // the player is default HOSTILE_TO_ENEMY, and the creature is not HOSTILE_TO_ENEMY that is hostile
    public boolean canActorEnter(Actor actor){
        return actor.hasCapability(Ability.CAN_ENTER_FLOOR);
    }
}


