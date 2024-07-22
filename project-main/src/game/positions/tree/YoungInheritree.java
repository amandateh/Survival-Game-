package game.positions.tree;

/**
 * Young inheritree represent a stage of tree
 * 'y' represent an inheritree in the game
 * @author Hihihi
 */
public class YoungInheritree extends Plant{
    private int age = 0;
    private final static int NEXT_STAGE_AGE = 5;
    private final static char DISPLAY_CHAR = 'y';

    /**
     * constructor
     */
    public YoungInheritree() {
        super(DISPLAY_CHAR, NEXT_STAGE_AGE, new LargeInheritree());
    }
}
