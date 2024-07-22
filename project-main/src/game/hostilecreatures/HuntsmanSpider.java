package game.hostilecreatures;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * this class represents a huntsman spider in the game world
 * it is hostile to the player and if a play near it,
 * it has 25% to attack the player by 1 hp.
 * If no player near it, it will walk around the game map
 * @author GAO HAO
 */

public class HuntsmanSpider extends HostileCreature {
    private final static String NAME = "Huntsman Spider";
    private final static char DISPLAY_CHAR = '8';
    private final static int HIT_POINTS = 1;

    /**
     * constructor
     */
    public HuntsmanSpider() {
        super(NAME, DISPLAY_CHAR, HIT_POINTS);
        this.behaviours.put(99, new AttackBehaviour());
    }

    /**
     * spider's intrinsic weapon is a long leg, damage is 1, and have 25 hit rate
     * @return the long leg
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "bites", 25);
    }

}
