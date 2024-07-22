package game.positions.tree;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Inheritree represent a tree in the game
 * it can drop large fruit in 2p percentage in every turn
 * 'T' represent a large inheritree in the game
 * @author GAO HAO
 */
public class LargeInheritree extends DropFruitPlant {
    /**
     * display character of LargeInheritree in the game
     */
    private final static char DISPLAY_CHAR = 'T';

    private final static int NEXT_STAGE_AGE = 0;

    /**
     * the rate it will drop a fruit every turn
     */
    private final static int DROP_RATE = 20;
    /**
     * Constructor.
     */
    public LargeInheritree() {
        super(DISPLAY_CHAR, DROP_RATE, NEXT_STAGE_AGE, null);
    }

    /**
     * drop the fruit of the plant in the specific location
     * @param location the location fruit drop
     */
    @Override
    public void drop_fruit(Location location){
        location.addItem(new LargeFruit());
    }
}
