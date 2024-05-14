package nz.ac.auckland.se281;

// Medium strategy with RandomStrategy and then TopStrategy
public class Medium implements Diff {

    private int round = 0;

    @Override
    public void setPreviousWin(boolean previousWin) {
    }

    @Override
    public Strategy getStrategy() {
        round++;
        if (round < 4) {
            return new RandomStrategy();
        }
        return new TopStrategy();
    }
}