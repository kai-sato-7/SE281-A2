package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    MessageCli.START_ROUND.printMessage(String.valueOf(++round));
  }

  public void play() {
  }

  public void endGame() {
  }

  public void showStats() {
  }
}
