package nz.ac.auckland.se281;

/**
 * Interface for the difficulty levels.
 */
public interface Diff {

  public void setPreviousWin(boolean previousWin);

  public Strategy getStrategy();
}
