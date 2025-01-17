package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** Factory design pattern to create difficulty levels. */
public class DifficultyFactory {

  /**
   * Creates difficulty level based on difficulty.
   * 
   * @param diff Difficulty level
   */
  public static Diff createDifficulty(Difficulty diff) {
    switch (diff.name()) {
      case "EASY":
        return new Easy();
      case "MEDIUM":
        return new Medium();
      case "HARD":
        return new Hard();
    }
    return null;
  }
}
