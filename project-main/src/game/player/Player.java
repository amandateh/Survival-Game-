package game.player;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.FancyMessage;
import game.Status;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author GAO HAO
 *
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitPoints
     */

    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.END_GAME);
        this.addCapability(Ability.CAN_BE_FOLLOWED);
        this.addCapability(Ability.CAN_ENTER_FLOOR);
        this.addCapability(Ability.LISTEN_MONOLOGUE);
    }

    /**
     * for each turn, the player's hp will show up at screen
     * and user can choose an action to this actor when it is not dead
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return An Action player perform at this turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        int hp = this.getAttribute(BaseActorAttributes.HEALTH);  // check the players hp
        if (this.isConscious())
        {
            display.print(this.name + "\n" + "HP: " + hp + "/" +
                    this.getAttributeMaximum(BaseActorAttributes.HEALTH) + "\n");  // print the hp
            display.print("Balance: " + this.getBalance() + "\n"); // print the balance
        }
        else
        {
            display.print(this.unconscious(map) + "\n");
            return new DoNothingAction();
        }


        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * What will happen when player's hp reach 0
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return A display message
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        String result = "";
        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            result += "\n";
            result += line;
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return result + "\n";
    }

    /**
     * What will happen when player natural died
     * @param map where the actor fell unconscious
     * @return A display message
     */
    @Override
    public String unconscious( GameMap map) {
        map.removeActor(this);
        String result = "";
        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            result += "\n";
            result += line;
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return result + "\n";
    }

    /**
     * @return  The intrinsicWeapon of player
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }


}

