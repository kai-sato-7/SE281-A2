package nz.ac.auckland.se281;

import java.util.ArrayList;

// Strategy design pattern to change computer strategies
public class Computer {

  private Strategy strategy;

  public Computer(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setHistory(ArrayList<Integer> history) {
    strategy.setHistory(history);
  }

  public void setEvenWins(boolean evenWins) {
    strategy.setEvenWins(evenWins);
  }

  public int getMove() {
    return strategy.getMove();
  }
}
