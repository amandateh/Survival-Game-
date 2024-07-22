package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.GenerateRandom;
import game.SpeakAbleEntity;

import java.util.List;

/**
 * A class represent the action to listen the monologue of a SpeakAbleEntity
 * @author Hihihi
 */
public class ListenAction extends Action {
    private final SpeakAbleEntity entity;
    private final List<String> monologue;

    /**
     * Constructor
     * @param entity the entity to speak
     * @param monologue the monologue this entity can speak
     */
    public ListenAction(SpeakAbleEntity entity, List<String> monologue)
    {
        this.entity = entity;
        this.monologue = monologue;
    }

    /**
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return display message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "No Monologue Available";
        if(monologue.size() > 0){
            int choice = GenerateRandom.generateRandomInteger(0, monologue.size());
            result = entity + ": " + '"' + monologue.get(choice) + '"';
        }
        return result;
    }

    /**
     * Menu option
     * @param actor The actor performing the action.
     * @return display message
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + entity;
    }
}
