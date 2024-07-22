package game.positions.crater;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Spawner represent a spawner for a crater,
 * each spawner can spawn its own actor and has its spawn rate
 * @author GAO HAO
 */
public abstract class Spawner {

    /**
     * the rate a creature be created every turn
     */
    public int spawn_rate;

    /**
     * constructor
     * @param rate the rate of spawn every turn
     */
    public Spawner(int rate){
        spawn_rate = rate;
    }

    /**
     * Spawn creature on given location
     * @param location the location to spawn creature
     */
    public abstract void spawn(Location location);

    /**
     * @return spawn_rate represent the rate to spawn a specific creature
     */
    public int getSpawn_rate(){
        return spawn_rate;
    }
}
