package game.positions.tree;

/**
 * SmallFruit represent a fruit that can heal 1 hp to its owner
 * 'o' represent it in the game map
 * @author GAO HAO
 */
public class SmallFruit extends Fruit {
    private final String VERB = "eats";
    /**
     * display character of SmallFruit in the game
     */
    private final static char DISPLAY_CHAR = 'o';

    /**
     * the name of small fruit
     */
    private final static String NAME = "small Fruit";

    /**
     * hp it can heal the owner
     */
    private final static int HP = 1;

    /**
     * Constructor.
     */
    public SmallFruit() {
        super(NAME, DISPLAY_CHAR, HP);
    }

    @Override
    public String getVerb() {
        return "eats";
    }

    /**
     * @return a new instance of this class
     */
    public Fruit getFruit()
    {
        return new SmallFruit();
    }
}
