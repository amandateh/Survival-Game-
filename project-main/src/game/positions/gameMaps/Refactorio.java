package game.positions.gameMaps;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.World;

import java.util.Arrays;
import java.util.List;

/**
 * A class representing a map
 * @author Hihihi
 */
public class Refactorio extends TraversalMap {
    private final static String GAME_MAP_NAME = "Refactorio";
    private final static int TERMINAL_X = 15;
    private final static int TERMINAL_Y = 5;
    private final static List<String> LINES = Arrays.asList(
            "..........................~~~~",
            ".....,....................~~~~",
            "..........................~~~~",
            "~..........................~..",
            "~~...........#####............",
            "~~~..........#_=_#............",
            "~~~..........#___#............",
            "~~~..........##_##............",
            "~~~..................~~.......",
            "~~~~...,............~~~~......",
            "~~~~...............~~~~~......",
            "..~................~~~~.......",
            "....................~~........",
            ".............~~...............",
            "............~~~~..............");

    /**
     * Constructor.
     * @param groundFactory GroundFactory
     */
    public Refactorio(GroundFactory groundFactory) {
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
