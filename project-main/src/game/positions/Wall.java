package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {
    /**
     * Constructor.
     */

    public Wall() {
        super('#');
    }

    /**
     * Determine whether an actor can enter Wall
     * @param actor the Actor to check
     * @return a boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
