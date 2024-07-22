package game;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.List;

/**
 * An interface represent the special ability of one entity can speak monologue
 * @author Hihihi
 */
public interface SpeakAbleEntity {
    /**
     * The method to get the monologue this entity can speak based on the state of actor
     * @param actor the actor who listen
     * @return List of String this entity can speak
     */
    List<String> getMonologue(Actor actor);
}
