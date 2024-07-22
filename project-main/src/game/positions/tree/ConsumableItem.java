package game.positions.tree;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * an interface represent that an item is consumable
 * @author GAO HAO
 */
public interface ConsumableItem{
    /**
     * @return A string represent the verb of consuming
     */
    String getVerb() ;

    /**
     * @param actor the actor who consume
     * @return display message when consuming
     */
    String consume(Actor actor);


}

