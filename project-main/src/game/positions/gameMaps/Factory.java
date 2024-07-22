package game.positions.gameMaps;

import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.Arrays;
import java.util.List;

/**
 * A class represent a map
 * @author Hihihi
 */
public class Factory extends TraversalMap {
    private final static String GAME_MAP_NAME = "Static Factory";
    private final static int TERMINAL_X = 3;
    private final static int TERMINAL_Y = 2;
    private static final List<String> LINES =
            Arrays.asList(
                    ".......",
                    ".#####.",
                    ".#_=_#.",
                    ".#___#.",
                    ".##_##.",
                    ".......",
                    ".......",
                    ".......",
                    ".......",
                    ".......");

    /**
     * Constructor.
     * @param groundFactory GroundFactory
     */
    public Factory(GroundFactory groundFactory) {
        super(groundFactory, LINES, TERMINAL_X, TERMINAL_Y);
    }

    /**
     * Represent how to the display an instance of this class
     * @return display message
     */
    public String toString()
    {
        return GAME_MAP_NAME;
    }
}
