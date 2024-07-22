package game.positions.crater;

import edu.monash.fit2099.engine.positions.Location;
import game.hostilecreatures.HuntsmanSpider;

/**
 * a spawner can spawn huntsman spider in 5% every turn
 * @author GAO HAO
 */
public class SpiderSpawner extends Spawner{
    /**
     * rate that the spawner will spawn spider in every turn
     */
    private final static int SPAWN_RATE = 5;

    /**
     * constructor
     */
    public SpiderSpawner(){
        super(SPAWN_RATE);
    }

    /**
     * spawn a spider in the location
     * @param location a spider is added in
     */
    @Override
    public void spawn(Location location) {
        location.addActor(new HuntsmanSpider());
    }
}
