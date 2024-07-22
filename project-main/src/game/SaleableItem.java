package game;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * an interface represent that an item is saleable
 * @author Hihihi
 */
public interface SaleableItem {

    /** a method represent the functionality when this item is sold by the actor
     * @param actor the actor who sell it
     * @return display message when consuming
     */
    String be_sold(Actor actor);
}
