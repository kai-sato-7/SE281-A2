package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;
  private Difficulty difficulty;
  private Choice choice;
  private String[] options;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.options = options;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(++round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    int fingers = Integer.parseInt(input);
  }

  public void endGame() {
  }

  public void showStats() {
  }
}
