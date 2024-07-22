package game.positions.tree;


import edu.monash.fit2099.engine.positions.Location;

/**
 * Inheritree represent a tree in the game
 * it can drop small fruit in 30 percentage in every turn
 * 't' represent an inheritree in the game
 * @author GAO HAO
 */
public class Sapling extends DropFruitPlant {
    /**
     * age of the tree, 5 turns it will grow to large
     */
    private final static int NEXT_STAGE_AGE = 6;

    /**
     * display character of inheritree in the game
     */
    private final static char DISPLAY_CHAR = 't';

    /**
     * the rate it will drop a fruit every turn
     */
    private final static int DROP_RATE = 30;

    /**
     * Constructor.
     */
    public Sapling() {
        super(DISPLAY_CHAR, DROP_RATE, NEXT_STAGE_AGE, new YoungInheritree());
    }

    /**
     * drop the fruit of the plant in the specific location
     * @param location the location fruit drop
     */
    @Override
    public void drop_fruit(Location location){
        location.addItem(new SmallFruit());
    }

}

