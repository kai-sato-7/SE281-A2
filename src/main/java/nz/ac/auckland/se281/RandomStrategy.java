package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

    public int getMove() {
        return Utils.getRandomNumberRange(0, 5);
    }
}
