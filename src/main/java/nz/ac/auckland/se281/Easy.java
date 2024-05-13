package nz.ac.auckland.se281;

public class Easy implements Diff {

    @Override
    public void setPreviousWin(boolean previousWin) {
    }

    @Override
    public Strategy getStrategy() {
        return new RandomStrategy();
    }
}