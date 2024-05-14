package nz.ac.auckland.se281;

import java.util.ArrayList;

/**
 * Interface for the different strategies.
 */
public interface Strategy {

  public int getMove();

  public void setHistory(ArrayList<Integer> history);

  public void setEvenWins(boolean evenWins);
}
