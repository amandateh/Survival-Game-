package game.positions.tree;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

/**
 * Plant represent a plant in the game,
 * each plant can grow to the other stage in several turn
 * @author GAO HAO
 */
public abstract class Plant extends Ground {

    private int age = 0;

    private final int next_stage_age;

    private final Plant next_stage_tree;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param next_stage_age int represent the age of next stage
     * @param next_stage_tree Plant represent the plant of next stage
     */
    public Plant(char displayChar, int next_stage_age, Plant next_stage_tree) {
        super(displayChar);
        this.next_stage_age = next_stage_age;
        this.next_stage_tree = next_stage_tree;
    }

    /**
     * every tick,
     * the plant's age will increment, when the age achieve to next stage age,
     * it will grow to next stage
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.age ++;
        if (this.next_stage_tree != null)
        {
            if (this.age >= this.next_stage_age) {
                location.setGround(next_stage_tree);
            }
        }
    }
}
