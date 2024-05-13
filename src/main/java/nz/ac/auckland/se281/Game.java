package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = 0;
  private Diff difficulty;
  private Choice choice;
  private String[] options;
  private ArrayList<Integer> history;
  private boolean previousWin;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = DifficultyFactory.createDifficulty(difficulty);
    this.choice = choice;
    this.options = options;
    this.history = new ArrayList<Integer>();
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(++round));
    int fingers = -1;
    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      if (Utils.isInteger(input)) {
        fingers = Integer.parseInt(input);
        if (fingers >= 0 && fingers <= 5) {
          break;
        }
      }
      MessageCli.INVALID_INPUT.printMessage();
    }
    history.add(fingers);
    MessageCli.PRINT_INFO_HAND.printMessage(options[0], String.valueOf(fingers));

    Strategy computer = difficulty.getStrategy();
    computer.setHistory(history);
    computer.setEvenWins(choice == Choice.ODD);

    int computerFingers = computer.getMove();
    boolean isEven = Utils.isEven(fingers + computerFingers);
    boolean playerWins = isEven == (choice == Choice.EVEN);

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(computerFingers));
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        String.valueOf(fingers + computerFingers),
        isEven ? "EVEN" : "ODD",
        playerWins ? options[0] : "HAL-9000");
  }

  public void endGame() {
  }

  public void showStats() {
  }
}
