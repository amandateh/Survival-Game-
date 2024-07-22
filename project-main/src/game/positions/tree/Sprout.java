package game.positions.tree;


/**
 * Sprout representing a stage of tree
 * ',' represents an inheritree in the game
 * @author Hihihi
 */
public class Sprout extends Plant{
    private final static int NEXT_STAGE_AGE = 3;
    private final static char DISPLAY_CHAR = ',';

    /**
     * constructor
     */
    public Sprout() {
        super(DISPLAY_CHAR, NEXT_STAGE_AGE, new Sapling());
    }
}
