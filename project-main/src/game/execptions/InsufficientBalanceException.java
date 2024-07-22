package game.execptions;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * A class represent an exception that actor can not afford the price of one item
 * @author Hihihi
 */
public class InsufficientBalanceException extends Exception{
    /**
     * A display message
     */
    private final static String MESSAGE = "Poor guy! your balance is not enough";
    /**
     * actor who pay the price
     */
    private final Actor actor;
    /**
     * int represent the price of one item
     */
    private final int price;

    /**
     * Constructor.
     * @param actor actor who pay the price
     * @param price int represent the price of one item
     */
    public InsufficientBalanceException(Actor actor, int price){
        super(MESSAGE);
        this.actor = actor;
        this.price = price;
    }

    /**
     * Getter method for attribute balance of actor
     * @return the balance of actor
     */
    public int getActorBalance(){
        return this.actor.getBalance();
    }

    /**
     * Getter method for attribute price
     * @return value of attribute price
     */
    public int getPrice() {
        return price;
    }
}
