package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int round = -1;
  private int playerWins;
  private Diff difficulty;
  private Choice choice;
  private String[] options;
  private ArrayList<Integer> history;

  /**
   * Starts a new game with the given difficulty, choice and options.
   * 
   * @param difficulty the difficulty of the game
   * @param choice     the odd/even choice of the player
   * @param options    the player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Starts a new game with the given difficulty, choice and options.
    this.round = 0;
    this.playerWins = 0;
    this.difficulty = DifficultyFactory.createDifficulty(difficulty);
    this.choice = choice;
    this.options = options;
    this.history = new ArrayList<Integer>();
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  /**
   * Plays a round of the game.
   */
  public void play() {
    // Plays a round of the game.
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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

    // Initializes the computer strategy
    Computer computer = new Computer(difficulty.getStrategy());
    computer.setHistory(history);
    computer.setEvenWins(choice == Choice.ODD);

    int computerFingers = computer.getMove();
    boolean isEven = Utils.isEven(fingers + computerFingers);
    boolean playerWins = isEven == (choice == Choice.EVEN);
    if (playerWins) {
      this.playerWins++;
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(computerFingers));
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        String.valueOf(fingers + computerFingers),
        isEven ? "EVEN" : "ODD",
        playerWins ? options[0] : "HAL-9000");
    difficulty.setPreviousWin(!playerWins);
  }

  /**
   * Ends the game and prints the stats and winner.
   */
  public void endGame() {
    // Ends the game and prints the stats and winner.
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(options[0], String.valueOf(playerWins),
        String.valueOf(round - playerWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", String.valueOf(round - playerWins),
        String.valueOf(playerWins));
    if (playerWins > round - playerWins) {
      MessageCli.PRINT_END_GAME.printMessage(options[0]);
    } else if (playerWins < round - playerWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    round = -1;
  }

  /**
   * Shows the stats of the game.
   */
  public void showStats() {
    // Shows the stats of the game.
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(options[0], String.valueOf(playerWins),
        String.valueOf(round - playerWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", String.valueOf(round - playerWins),
        String.valueOf(playerWins));
  }
}
