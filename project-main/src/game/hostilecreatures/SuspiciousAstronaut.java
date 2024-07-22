package game.hostilecreatures;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
/**
 * this class represents a Suspicious Astronaut in the game world
 * it is hostile to the player and if a play near it,
 * it has 100% to attack the player by Integer.MAX_VALUE which is extremely high.
 * If no player near it, it will walk around the game map
 * @author Hihihi
 * */
public class SuspiciousAstronaut extends HostileCreature{
    private final static String NAME = "Suspicious Astronaut";
    private final static char DISPLAY_CHAR = '\u0D9E';
    private final static int HIT_POINTS = 99;

    /**
     * Constructor.
     */
    public SuspiciousAstronaut() {
        super(NAME, DISPLAY_CHAR, HIT_POINTS);
        this.behaviours.put(998, new AttackBehaviour());
    }

    /**
     *
     * @return An IntrinsicWeapon with extremely high damage with 100% hitRate as Bonk
     */
    public IntrinsicWeapon getIntrinsicWeapon()
    {
        return new IntrinsicWeapon(Integer.MAX_VALUE, "bonk", 100);
    }
}
