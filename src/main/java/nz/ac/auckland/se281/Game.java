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
    int fingers = -1;
    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      try {
        fingers = Integer.parseInt(input);
        if (fingers >= 0 && fingers <= 5) {
          break;
        }
        MessageCli.INVALID_INPUT.printMessage();
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(options[0], String.valueOf(fingers));
  }

  public void endGame() {
  }

  public void showStats() {
  }
}
