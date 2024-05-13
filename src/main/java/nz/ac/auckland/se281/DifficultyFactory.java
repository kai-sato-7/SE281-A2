package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

    public static Diff createDifficulty(Difficulty diff) {
        switch (diff.name()) {
            case "EASY":
                return new Easy();
            case "MEDIUM":
                return new Medium();
        }
        return null;
    }
}
