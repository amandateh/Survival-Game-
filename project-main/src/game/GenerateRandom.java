package game;

import java.util.Random;

/**
 * A simple math class to return a random number between given range
 * The main purpose for class is to avoid the repetition of instantiate an instance of Random class
 * or achieve generating random number when there is a limitation of instantiate an instance of Random class
 * @author Hihihi
 */
public class GenerateRandom {
    /**
     * Randomly return a number between given range
     * @param low the lower bound of the output
     * @param high the higher bound of the output
     * @return an integer between low and high
     */
    public static int generateRandomInteger(int low, int high)
    {
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }
}
