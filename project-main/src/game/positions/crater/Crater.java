package game.positions.crater;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.GenerateRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represent a crater in the game world
 * each crater have chance to spawn a creature every turn
 * @author GAO HAO
 */
public class Crater extends Ground{
    /**
     * spawner of a crater, which decide the rate to spawn and which actor to spawn
     */
    private final Spawner spawner;

    private static final char DISPLAY_CHAR = 'u';

    /**
     * constructor
     * 'u' represent a crater in game map
     * @param spawner a Spawner which can spawn specific creature
     */
    public Crater(Spawner spawner) {
        super(DISPLAY_CHAR);
        this.spawner = spawner;
    }

    /**
     * every turn, a spawner have rate to be created a crater in an exit of this crater
     * @param location The location of the crater
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        int drop = GenerateRandom.generateRandomInteger(0,100);
        if (drop < spawner.getSpawn_rate())
        {
            List<Exit> exits = location.getExits();
            List<Exit> dropExits = new ArrayList<>();
            for (Exit exit : exits)
            {
                if (!exit.getDestination().containsAnActor())
                {
                    dropExits.add(exit);
                }
            }
            if (!dropExits.isEmpty())  // there is an exit to add the spider
            {
                int b = GenerateRandom.generateRandomInteger(0,dropExits.size());
                Location dropExit = dropExits.get(b).getDestination();
                this.spawner.spawn(dropExit);
            }
        }
    }
}
