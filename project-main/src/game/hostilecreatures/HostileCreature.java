package game.hostilecreatures;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.Status;
import game.behaviours.WanderBehaviour;


import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class represent actor that are hostile to player
 * @author Hihihi
 */
public abstract class HostileCreature extends Actor {
    /**
     * A hash map mapping integer with the Behaviour of an HostileCreature
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name A string represent the name of the Actor
     * @param displayChar A char represent how to display this Actor on the GameMap
     * @param hitPoints An int represent the hit point of the Actor
     */
    public HostileCreature(String name, char displayChar, int hitPoints)
    {
        super(name, displayChar, hitPoints);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }


    /**
     * The HostileCreature can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return An ActionList
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}
