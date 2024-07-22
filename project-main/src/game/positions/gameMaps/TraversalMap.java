package game.positions.gameMaps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.List;

/**
 * A class represent a map can be travel through by actors
 * @author Hihihi
 */
public abstract class TraversalMap extends GameMap {
    private final int terminal_x;
    private final int terminal_y;

    /**
     * Constructor.
     * @param groundFactory groundFactory represent the used grounds
     * @param lines list of string represent the map
     * @param terminal_x the x location of the computer terminal
     * @param terminal_y the y location of the computer terminal
     */
    public TraversalMap(GroundFactory groundFactory, List<String> lines, int terminal_x, int terminal_y) {
        super(groundFactory, lines);
        this.terminal_x = terminal_x;
        this.terminal_y = terminal_y;
    }

    /**
     * Get the value of x
     * @return x location of the computer terminal
     */
    public int getTerminalX()
    {
        return terminal_x;
    }

    /**
     * Get the value of y
     * @return y location of the computer terminal
     */
    public int getTerminal_y()
    {
        return terminal_y;
    }
}
