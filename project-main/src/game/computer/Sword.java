package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.execptions.InsufficientBalanceException;
import game.Status;

import java.util.Random;

/**
 * A class represent one type of computer item.
 * @author Hihihi
 */
public class Sword extends ComputerItem implements Weapon {
    private final static String NAME = "Dragon Slayer Sword";
    private final static char DISPLAY_CHAR = 'x';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 100;
    private final static int CHANCE = 50;
    private final static int HIT_RATE = 75;
    private final static int DAMAGE = 50;
    private final static String VERB = "SLICE";
    /***
     * Constructor.
     */
    public Sword() {
        super(NAME, DISPLAY_CHAR, PORTABLE, PRICE, CHANCE);
    }

    /**
     * Special condition what will happen when actor purchase this item
     * @param actor actor perform the action on the Item
     */
    @Override
    public String special(Actor actor) {
        String result = "";
        Random r = new Random();

        try{
            if(checkWallet(actor, PRICE))
            {
                if(CHANCE > r.nextInt(100))
                {
                    actor.addItemToInventory(this.getItem());
                    actor.deductBalance(PRICE);
                    result = result + actor + " successfully bought " + NAME + " for " + PRICE + " credit.";
                }
                else
                {
                    result = result + PRICE + " credit is received by " + actor + ", but nothing return.";
                    actor.deductBalance(PRICE);
                }
            }
            else {
                throw new InsufficientBalanceException(actor, PRICE);
            }
        } catch (InsufficientBalanceException e){
            result = result + e.getMessage() + " (" + e.getActorBalance() + " < " + e.getPrice() + ")";
        }
        return result;
    }

    /**
     * The damage value of this weapon
     * @return int represent the damage value of this weapon
     */
    @Override
    public int damage()
    {
        return DAMAGE;
    }

    /**
     * How this weapon attack other actor
     * @return String represent the attack method
     */
    @Override
    public String verb() {
        return VERB;
    }

    /**
     * The hit rate of this weapon
     * @return int represent the hitRate of this weapon
     */
    @Override
    public int chanceToHit() {
        return HIT_RATE;
    }

    /**
     * All actions actor can perform with this item
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return A ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (! otherActor.hasCapability(Status.HOSTILE_TO_ENEMY))
        {
            actions.add(new AttackAction(otherActor, location.toString(), this));
        }
        return actions;
    }

    /**
     *
     * @return a new instance of this class
     */
    @Override
    public ComputerItem getItem() {
        return new Sword();
    }
}
