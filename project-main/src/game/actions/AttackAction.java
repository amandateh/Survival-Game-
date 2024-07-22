package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * AttackAction represent an action that one actor attack another actor
 * @author GAO HAO
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private final Actor target;

    /**
     * The direction of incoming attack.
     */
    private final String direction;

    /**
     * Random number generator
     */
    private final Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used by actor to attack target
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor with intrinsic weapon as default
     *
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * When executed,
     * The actor will attack the target with its weapon,
     * if the target is dead after this attack, the actor will be removed from the game map,
     * and if the player died, the fancy message will show up
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return an execute message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        if (!(rand.nextInt(100) < weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        StringBuilder result = new StringBuilder(actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.");
        target.hurt(damage);
        if (!target.isConscious()) {
            result.append("\n").append(target.unconscious(actor, map));
        }

        return result.toString();
    }

    /**
     * show this action in user interface
     * @param actor The actor performing the action.
     * @return the description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
