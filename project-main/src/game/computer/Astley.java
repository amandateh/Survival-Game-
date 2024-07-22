package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.ListenAction;
import game.SpeakAbleEntity;
import game.execptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

/**
 * A class represent an AI named Astley
 * that can be print using computer terminal
 * @author Hihihi
 */
public class Astley extends ComputerItem implements SpeakAbleEntity {
    private final static String NAME = "Astley, an AI device";
    private final static char DISPLAY_CHAR = 'z';
    private final static boolean PORTABLE = true;
    private final static int PRICE = 50;
    private final static int SUBSCRIPTION_FEE = 1;
    private final static int CHANCE = 100;
    /**
     * The reason to initialize this attribute to true is:
     * actor pay the fee to print it out from the computer terminal.
     */
    private boolean subscription_paid = true;

    /**
     * represent the life of each instance
     */
    public int age = 0;

    /**
     * Constructor.
     */
    public Astley ()
    {
        super(NAME, DISPLAY_CHAR, PORTABLE, PRICE, CHANCE);
    }

    /**
     * Special condition what will happen when actor purchase this item
     * @param actor actor perform the action on the Item
     * @return display message
     */
    @Override
    public String special(Actor actor) {
        String result = "";
        boolean success = checkWallet(actor, PRICE);
        try {
            if (success) {
                actor.addItemToInventory(this.getItem());
                actor.deductBalance(PRICE);
                result = result + actor + " successfully bought " + NAME + " for " + PRICE + " credit.";
            } else {
                throw new InsufficientBalanceException(actor, PRICE);
            }
        } catch (InsufficientBalanceException e) {
            result = result + e.getMessage() + " (" + e.getActorBalance() + " < " + e.getPrice() + ")";
        }
        return result;
    }

    /**
     * @return an instance of itself
     */
    @Override
    public ComputerItem getItem() {
        return new Astley();
    }

    /**
     * Lifetime management of Astley
     * @param location The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location location, Actor actor) {
        super.tick(location, actor);
        if (actor.getItemInventory().contains(this) & actor.hasCapability(Ability.LISTEN_MONOLOGUE)) {
            age++;
            if (age == 5) {
                if(checkWallet(actor, SUBSCRIPTION_FEE)) {
                    actor.deductBalance(SUBSCRIPTION_FEE);
                    System.out.println("Subscription payment received!");
                    age = 0;
                    subscription_paid = true;
                }
                else
                {
                    age--;
                    System.out.println("Subscription payment not received!");
                    subscription_paid = false;
                }
            }
        }
        else
        {
            age--;
        }
    }

    /**
     * Allowable actions the owner can do with it
     * @param owner the actor that owns the item
     * @return An actionList
     */
    @Override
    public ActionList allowableActions(Actor owner)
    {
        ActionList actions = new ActionList();
        if(subscription_paid)
            actions.add(new ListenAction(this,  getMonologue(owner)));
        return actions;
    }

    /**
     * @return A list of monologue Astley currently can speak
     */
    @Override
    public List<String> getMonologue(Actor actor)
    {
        List<String> monologue = new ArrayList<>();
        monologue.add("The factory will never gonna give you up, valuable intern!");
        monologue.add("We promise we never gonna let you down with a range of staff benefits.");
        monologue.add("We never gonna run around and desert you, dear intern!");
        if(actor.getItemInventory().size() > 10)
            monologue.add("We never gonna make you cry with unfair compensation.");
        if(actor.getBalance() > 50)
            monologue.add("Trust is essential in this business. " +
                    "We promise we never gonna say goodbye to a valuable intern like you.");
        if(actor.getAttribute(BaseActorAttributes.HEALTH) < 2)
            monologue.add("Don't worry, we never gonna tell a lie and hurt you, " +
                    "unlike those hostile creatures.");
        return monologue;
    }
}
