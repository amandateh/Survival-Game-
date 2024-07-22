package game;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * a class represents humanoid figure who is a npc in factory
 * can buy items and award player
 * @author Hihihi
 */
public class HumanoidFigure extends Actor {
    private final static char DISPLAY_CHAR = 'H';

    private final static int HIT_POINT = Integer.MAX_VALUE;
    private final static String NAME = "Humanoid Figure";
    /**
     * Constructor.
     */
    public HumanoidFigure()
    {
        super(NAME, DISPLAY_CHAR, HIT_POINT);
        this.addCapability(Ability.SALEABLE_IN); // can sale item to it
        this.addCapability(Status.CANNOT_BE_ATTACKED);  // can not be attack
    }

    /**
     * this actor have no behaviour
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return do nothing action
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }


}
