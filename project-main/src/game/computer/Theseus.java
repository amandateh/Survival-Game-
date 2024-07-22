package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.execptions.InsufficientBalanceException;
import game.actions.TeleportAction;

/**
 * A class represent an Item that can be print through computer,
 * it also can teleport actor to a random location
 * @author Hihihi
 */
public class Theseus extends ComputerItem {
    private final static String THESEUS = "THESEUS";
    private final static char DISPLAY_CHAR = '^';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 100;
    private final static int CHANCE = 0;

    /**
     * Constructor.
     */
    public Theseus(){
        super(THESEUS, DISPLAY_CHAR, PORTABLE, PRICE, CHANCE);
    }

    /**
     * Represent the logic to print the item from the computer terminal
     * @param actor actor perform the action on the Item
     * @return display message
     */
    @Override
    public String special(Actor actor) {
        String result = "";
        boolean success = false;
        if (checkWallet(actor, PRICE)) {
            actor.deductBalance(PRICE);
            success = true;
        }
        try {
            if (success) {
                actor.addItemToInventory(this);
                result = result + actor + " successfully bought " + THESEUS + " for " + PRICE + " credit.";
            } else {
                throw new InsufficientBalanceException(actor, PRICE);
            }
        }catch (InsufficientBalanceException e){
            result = result + e.getMessage() + " (" + e.getActorBalance() + " < " + e.getPrice() + ")";
        }
        return result;
    }

    /**
     * @return a new instance of itself
     */
    @Override
    public ComputerItem getItem() {
        return new Theseus();
    }

    /**
     * Represent what actions actor can perform with it
     * @param location the location of the ground on which the item lies
     * @return ActionList a list of action
     */
    @Override
    public ActionList allowableActions(Location location){
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(this));
        return actions;
    }

    /**
     * Display format
     * @return display message
     */
    @Override
    public String toString()
    {
        return THESEUS;
    }
}
