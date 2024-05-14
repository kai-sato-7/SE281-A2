package nz.ac.auckland.se281;

import java.util.ArrayList;

// Randomly selects fingers to play
public class RandomStrategy implements Strategy {

    @Override
    public void setHistory(ArrayList<Integer> history) {
    }

    @Override
    public void setEvenWins(boolean evenWins) {
    }

    @Override
    public int getMove() {
        return Utils.getRandomNumberRange(0, 5);
    }
}
