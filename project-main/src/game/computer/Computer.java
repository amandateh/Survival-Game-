package game.computer;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.positions.gameMaps.TraversalMap;
import game.actions.PrintItemAction;

import java.util.ArrayList;
import java.util.List;

/**
 * A class represent a computer in the game world
 * @author Hihihi
 */
public class Computer extends Ground {
    private final List<ComputerItem> computerItemList;
    private final List<TraversalMap> gameMapList;
    private final static char DISPLAY_CHAR = '=';

    /**
     * Constructor.
     */
    public Computer() {
        super(DISPLAY_CHAR);
        computerItemList = new ArrayList<>();
        gameMapList = new ArrayList<>();
    }

    /**
     * player can buy computer items or traverse to the other Gamemap through a computer
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An ActionList contains all actions actor can perform on computer
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for(ComputerItem item: computerItemList)
        {
            actions.add(new PrintItemAction(item.getItem()));
        }
        for(TraversalMap gameMap: gameMapList)
        {
            if(location.map() != gameMap)
                actions.add(new TravelAction(gameMap));
        }
        return actions;
    }

    /**
     * Add computerItem to computer for it to generate PrintItemAction
     * @param computerItem the Item to add
     */
    public void addItemToComputer(ComputerItem computerItem)
    {
        if(!computerItemList.contains(computerItem))
        {
            this.computerItemList.add(computerItem);
        }
    }

    /**
     * Delete computerItem from computer
     * @param computerItem the Item to delete
     */
    public void deleteItemFromComputer(ComputerItem computerItem)
    {
        computerItemList.remove(computerItem);
    }

    /**
     * Add computerItem to computer for it to generate PrintItemAction
     * @param gameMap the Item to add
     */
    public void addMapToComputer(TraversalMap gameMap)
    {
        if(!gameMapList.contains(gameMap))
        {
            this.gameMapList.add(gameMap);
        }
    }
    /**
     * Delete computerItem from computer
     * @param gameMap the gameMap to delete
     */
    public void deleteMapFromComputer(TraversalMap gameMap)
    {
        gameMapList.remove(gameMap);
    }
}