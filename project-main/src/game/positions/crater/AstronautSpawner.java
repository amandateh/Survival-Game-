package game.positions.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.hostilecreatures.SuspiciousAstronaut;

/**
 * a spawner can spawn suspicious astronaut in 10% every turn
 * @author GAO HAO
 */
public class AstronautSpawner extends Spawner{
    private final static int SPAWN_RATE = 5;
    /**
     * constructor
     */
    public AstronautSpawner(){
        super(SPAWN_RATE);
    }

    /**
     * spawn a suspicious astronaut in specific location
     * @param location the location suspicious astronaut should be spawned
     */
    @Override
    public void spawn(Location location) {
        location.addActor(new SuspiciousAstronaut());
    }
}
