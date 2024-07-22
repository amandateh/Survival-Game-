package game;

/**
 * Use this enum to represent abilities.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 */
public enum Ability {
    /**
     * have the capability to end the game (if user died, the game end)
     */
    END_GAME,
    /**
     * have this ability could be able to be followed by other actor
     */
    CAN_BE_FOLLOWED,
    /**
     * have this ability could enter the floor
     */
    CAN_ENTER_FLOOR,

    /**
     * an actor can sell an item
     */
    SALEABLE_IN,
    /**
     * have this ability could listen the monologue of speakAbleEntity
     */
    LISTEN_MONOLOGUE,
}