package nz.ac.auckland.se281;

public class Medium implements Diff {

    private int round = 1;

    @Override
    public Strategy getStrategy() {
        if (++round < 4) {
            return new RandomStrategy();
        }
        return new TopStrategy();
    }
}