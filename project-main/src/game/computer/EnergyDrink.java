package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.execptions.InsufficientBalanceException;
import game.positions.tree.ConsumableItem;
import game.positions.tree.ConsumeAction;

import java.util.Random;

/**
 * A class represent one type of Computer Items
 * @author Hihihi
 */
public class EnergyDrink extends ComputerItem implements ConsumableItem {
    private final static int CONSUME_VALUE = 1;
    private final static String NAME = "Energy Drink";
    private final static char DISPLAY_CHAR = '*';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 10;
    private final static int CHANCE = 20;
    /***
     * Constructor.
     */
    public EnergyDrink() {
        super(NAME, DISPLAY_CHAR, PORTABLE, PRICE, CHANCE);
    }

    /**
     * special condition have to meet for actor to buy this
     * @param actor the actor who perform the action on the Item
     */
    @Override
    public String special(Actor actor) {
        String result = "";
        Random r = new Random();
        try{
            if (CHANCE > r.nextInt(100))
            {
                if (checkWallet(actor, PRICE *2))
                {
                    actor.deductBalance(PRICE *2);
                    actor.addItemToInventory(this);
                    result = result + actor+ " successfully bought " + NAME + " for " + PRICE *2 + " credit.";
                }
                else
                {
                    throw new InsufficientBalanceException(actor, PRICE *2);
                }
            }
            else
            {
                if (checkWallet(actor, PRICE))
                {
                    actor.deductBalance(PRICE);
                    actor.addItemToInventory(this);
                    result = result + actor+ " successfully bought " + NAME + " for " + PRICE + " credit.";
                }
                else
                {
                    throw new InsufficientBalanceException(actor, PRICE);
                }
            }
        }catch (InsufficientBalanceException e)
        {
            result = result + e.getMessage() + " (" + e.getActorBalance() + " < " + e.getPrice() + ")";
        }

        return result;
    }

    /**
     * @return a String display the verb of how actor can use this item
     */
    @Override
    public String getVerb() {
        return "CHUGS";
    }

    /**
     * Special functionality of this Item when actor consume this item
     * @param actor the actor who consume this item
     * @return a display message
     */
    @Override
    public String consume(Actor actor) {
        actor.heal(CONSUME_VALUE);
        actor.removeItemFromInventory(this);
        return actor + " DRANK ENERGY DRINK HEALED 1 HP";
    }

    /**
     * All Action one actor can perform with this item
     * @param owner the actor that owns the item
     * @return A ActionList
     */
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     *
     * @return a new instance of this class
     */
    @Override
    public ComputerItem getItem() {
        return new EnergyDrink();
    }
}
