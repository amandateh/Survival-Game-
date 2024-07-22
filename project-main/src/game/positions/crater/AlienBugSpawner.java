package game.positions.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.hostilecreatures.AlienBug;


/**
 * a spawner can spawn alien bug in 10% every turn
 * @author GAO HAO
 */
public class AlienBugSpawner extends Spawner{
    private final static int SPAWN_RATE = 10;

    /**
     * Constructor.
     */
    public AlienBugSpawner() {
        super(SPAWN_RATE);
    }

    /**
     * spawn an alien bug in specific location
     * @param location the location alien bug should be spawned
     */
    @Override
    public void spawn(Location location) {
        location.addActor(new AlienBug());
    }

}
