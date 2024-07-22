package game.hostilecreatures;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.*;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.GenerateRandom;

/**
 * This class represent an Alien Bug in the game world
 * it is hostile to the player and if a play near it,
 * it will either pick up the Item on the location it stands
 * or follow an actor if this actor became its target.
 * If no player near it, it will wander around the game map
 * @author Hihihi
 */
public class AlienBug extends HostileCreature {

    private final static char DISPLAY_CHAR = 'a';
    private final static int HIT_POINTS = 2;

    /**
     * Constructor.
     */
    public AlienBug() {
        super("feature-" + GenerateRandom.generateRandomInteger(100, 1000), DISPLAY_CHAR, HIT_POINTS);
        this.addCapability(Ability.CAN_ENTER_FLOOR);
        this.behaviours.put(99, new FollowBehaviour());
        this.behaviours.put(1, new PickUpBehaviour());
    }

    /**
     * Display message when an Alien Bug is unconscious (its hp == 0)
     * And it will drop all item in its itemInventory to the location it stands before it died
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return A display message
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        Location location = map.locationOf(this);
        String result = super.unconscious(actor, map);
        for(Item item: this.getItemInventory())
        {
            location.addItem(item);
        }
        return result;
    }

}
