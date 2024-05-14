package nz.ac.auckland.se281;

/**
 * Represents the hard difficulty level with RandomStrategy, then changing
 * between TopStrategy and RandomStrategy.
 */
public class Hard implements Diff {

  private int round = 0;
  private String previousStrategy;
  private boolean previousWin;

  @Override
  public void setPreviousWin(boolean previousWin) {
    this.previousWin = previousWin;
  }

  // RandomStrategy for the first 3 rounds, then swapping strategy every loss
  @Override
  public Strategy getStrategy() {
    round++;
    if (round < 4) {
      previousStrategy = "RANDOM";
      return new RandomStrategy();
    }
    if (previousWin) {
      if (previousStrategy.equals("RANDOM")) {
        return new TopStrategy();
      }
      return new RandomStrategy();
    }
    if (previousStrategy.equals("RANDOM")) {
      return new RandomStrategy();
    }
    return new TopStrategy();
  }
}