package game.positions.tree;

import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;


/**
 * DropFruitPlant represent a plant can drop a fruit in this game,
 * each plant have the fruit it can drop
 * and the drop rate in every turn.
 * @author Hihihi
 */
public abstract class DropFruitPlant extends Plant {
    /**
     * the fruit of the plant
     */
    private final int dropRate;

    /**
     * constructor
     * @param displayChar the character of this plant in the user interface
     * @param dropRate the drop rate of fruit
     * @param next_stage_age int represent the age of next stage
     * @param next_stage_tree Plant represent the plant of next stage
     */
    public DropFruitPlant(char displayChar, int dropRate, int next_stage_age, Plant next_stage_tree) {
        super(displayChar, next_stage_age, next_stage_tree);
        this.dropRate = dropRate;
    }
    /**
     * every tick,
     * the plant will drop a fruit base on the drop rate
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

        Random random = new Random();
        int a = random.nextInt(100);
        if (a<dropRate)
        {
            int b = random.nextInt(location.getExits().size());
            Location fruitDrop = location.getExits().get(b).getDestination();  // random get a exit
            drop_fruit(fruitDrop);
        }
    }

    /**
     * drop the fruit of the plant in the specific location
     * @param location the location fruit drop
     */
    public abstract void drop_fruit(Location location);
}
