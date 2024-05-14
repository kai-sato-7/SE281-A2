package nz.ac.auckland.se281;

// Easy strategy with only RandomStrategy
public class Easy implements Diff {

    @Override
    public void setPreviousWin(boolean previousWin) {
    }

    @Override
    public Strategy getStrategy() {
        return new RandomStrategy();
    }
}