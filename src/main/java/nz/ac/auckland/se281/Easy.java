package nz.ac.auckland.se281;

public class Easy implements Diff {

    @Override
    public Strategy getStrategy() {
        return new RandomStrategy();
    }
}