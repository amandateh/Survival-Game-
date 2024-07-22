package game.computer;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An abstract class represent all Items provided by the computer
 * @author Hihihi
 */
public abstract class ComputerItem extends Item{
    /**
     * Attribute represent the price of one computer item which shared by all child classes
     */
    protected final int price;
    /**
     * Attribute represent the chance of specific condition to occur for one computer item which shared by all child classes
     */
    protected final int chance;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     * @param price the price of this Item
     * @param chance  the chance of specific condition to occur for this Item
     */
    public ComputerItem(String name, char displayChar, boolean portable, int price, int chance) {
        super(name, displayChar, portable);
        this.price = price;
        this.chance = chance;
    }

    /**
     * Abstract method
     * @param actor actor perform the action on the Item
     * @return display message as a String
     */
    public abstract String special(Actor actor);

    /**
     * Check if the player have the enough money to buy the Item
     * @param actor the actor who is going to buy the item
     * @param price the price of the item
     * @return boolean determine whether actor could afford this item
     */
    public boolean checkWallet(Actor actor, int price)
    {
        return actor.getBalance() >= price;
    }

    /**
     * @return a new instance of ComputerItem
     */
    public abstract ComputerItem getItem();

}
