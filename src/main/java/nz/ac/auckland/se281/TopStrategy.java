package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrategy implements Strategy {

    private ArrayList<Integer> history;
    private boolean evenWins;

    @Override
    public void setHistory(ArrayList<Integer> history) {
        this.history = history;
    }

    @Override
    public void setEvenWins(boolean evenWins) {
        this.evenWins = evenWins;
    }

    @Override
    public int getMove() {
        int evenCount = 0;
        for (int i : history) {
            if (Utils.isEven(i)) {
                evenCount++;
            }
        }

        System.out.println(this.history);
        System.out.println(this.evenWins);

        if (evenCount == history.size() / 2) {
            return Utils.getRandomNumberRange(0, 5);
        } else if (evenCount > history.size() / 2) {
            if (evenWins) {
                return Utils.getRandomEvenNumber();
            } else {
                return Utils.getRandomOddNumber();
            }
        } else {
            if (evenWins) {
                return Utils.getRandomOddNumber();
            } else {
                return Utils.getRandomEvenNumber();
            }
        }
    }
}
