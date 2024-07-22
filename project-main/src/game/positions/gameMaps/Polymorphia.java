package game.positions.gameMaps;

import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.Arrays;
import java.util.List;

/**
 * A class representing a map
 * @author Hihihi
 */
public class Polymorphia extends TraversalMap {
    private final static String GAME_MAP_NAME = "Polymorphia";
    private final static int TERMINAL_X = 15;
    private final static int TERMINAL_Y = 5;
    private final static List<String> LINES = Arrays.asList(
            "...~~~~.........~~~...........",
            "...~~~~.......................",
            "...~~~........................",
            "....t.........................",
            ".............#####............",
            ".............#_=_#...........~",
            ".............#___#....t.....~~",
            "....t........##_##.........~~~",
            ".................~~........~~~",
            "................~~~~.......~~~",
            ".............~~~~~~~........~~",
            "......~.....~~~~~~~~.........~",
            ".....~~~...~~~~~~~~~..........",
            ".....~~~~~~~~~~~~~~~~........~",
            ".....~~~~~~~~~~~~~~~~~~~....~~");

    /**
     * Constructor.
     * @param groundFactory GroundFactory
     */
    public Polymorphia(GroundFactory groundFactory) {
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
