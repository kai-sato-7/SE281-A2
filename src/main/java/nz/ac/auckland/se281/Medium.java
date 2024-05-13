package nz.ac.auckland.se281;

public class Medium implements Diff {

    @Override
    public Strategy getStrategy() {
        return new RandomStrategy();
    }
}