package game;

/**
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attack a Status.SLEEP to the player class
 * Created by:
 * @author Riordan D. Alfredo
 */
public enum Status {
    /**
     * Any actor with this ability will be attacked by HostileCreature
     */
    HOSTILE_TO_ENEMY,
    /**
     * Any actor with this ability can not be attacked
     */
    CANNOT_BE_ATTACKED,

}
