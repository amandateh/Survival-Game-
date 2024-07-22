package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.World;
import game.computer.*;
import game.positions.gameMaps.Refactorio;
import game.positions.crater.AlienBugSpawner;
import game.positions.crater.AstronautSpawner;
import game.positions.crater.Crater;
import game.positions.crater.SpiderSpawner;
import game.player.Player;
import game.positions.Dirt;
import game.positions.Floor;
import game.positions.Puddle;
import game.positions.Wall;
import game.positions.gameMaps.Factory;
import game.positions.gameMaps.Polymorphia;
import game.positions.gameMaps.TraversalMap;
import game.positions.tree.Sprout;
import game.positions.tree.YoungInheritree;
import game.scraps.*;
import game.positions.tree.Sapling;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Hihihi
 *
 */
public class Application {
    /**
     * Run the program
     * @param args A list of String
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Sapling(), new Computer(), new Sprout());

        TraversalMap gameMap1 = new Polymorphia(groundFactory);
        TraversalMap gameMap2 = new Factory(groundFactory);
        TraversalMap gameMap3 = new Refactorio(groundFactory);
        world.addGameMap(gameMap1);
        world.addGameMap(gameMap2);
        world.addGameMap(gameMap3);


        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap1.at(7,10).setGround(new Crater(new SpiderSpawner()));
        gameMap1.at(25, 5).setGround(new Crater(new AlienBugSpawner()));
        gameMap1.at(17, 10).setGround(new Crater(new AstronautSpawner()));

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap1.at(15, 6));

        gameMap1.at(15,8).addItem(new LargeBolt());
        gameMap1.at(15,9).addItem(new MetalSheet());
        gameMap1.at(15,10).addItem(new MetalPipe());
        gameMap1.at(15, 6).addItem(new PotOfGold());
        gameMap1.at(12, 10).addItem(new JarPickles());
        gameMap1.at(15, 6).addItem(new PotOfGold());
        gameMap2.at(3,gameMap2.getXRange().max()).addActor(new HumanoidFigure());

        Computer computer = new Computer();
        computer.addItemToComputer(new EnergyDrink());
        computer.addItemToComputer(new Sword());
        computer.addItemToComputer(new ToiletPaper());
        computer.addItemToComputer(new Theseus());
        computer.addItemToComputer(new Astley());
        computer.addMapToComputer(gameMap1);
        computer.addMapToComputer(gameMap2);
        computer.addMapToComputer(gameMap3);

        gameMap1.at(15,5).setGround(computer);
        gameMap2.at(3, 2).setGround(computer);
        gameMap3.at(15, 5).setGround(computer);
        gameMap3.at(17,10).setGround(new Sprout());
        player.addBalance(51);
        world.run();
    }
}
