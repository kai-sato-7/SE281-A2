package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

    private int[] history;
    private boolean evenWins;

    public void setHistory(int[] history) {
        this.history = history;
    }

    public void setEvenWins(boolean evenWins) {
        this.evenWins = evenWins;
    }

    @Override
    public int getMove() {
        int evenCount = 0;
        for (int i = 0; i < history.length; i++) {
            if (Utils.isEven(history[i])) {
                evenCount++;
            }
        }

        if (evenCount == history.length / 2) {
            return Utils.getRandomNumberRange(0, 5);
        } else if (evenCount > history.length / 2) {
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
