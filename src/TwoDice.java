import java.lang.Math;
import java.util.Random;

public class TwoDice {
    private static Random random;
    private static int score;
    private static char[][][] dices;
    private static String dice1;
    private static String dice2;

    public TwoDice() {
        makeDieAsArray();
        score = 0;
        random = new Random(System.currentTimeMillis());
        dice1 = "";
        dice2 = "";
    }

    private static void makeDieAsArray() {

        dices = new char[][][]{
                // Dice face 1
                {
                        {'|', ' ', '|', ' ', '|', ' ', '|'},
                        {'|', ' ', '|', 'O', '|', ' ', '|'},
                        {'|', ' ', '|', ' ', '|', ' ', '|'},
                },
                // Dice face 2
                {
                        {'|', ' ', '|', ' ', '|', ' ', '|'},
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                        {'|', ' ', '|', ' ', '|', ' ', '|'},
                },
                // Dice face 3
                {
                        {'|', 'O', '|', ' ', '|', ' ', '|'},
                        {'|', ' ', '|', 'O', '|', ' ', '|'},
                        {'|', ' ', '|', ' ', '|', 'O', '|'},
                },
                // Dice face 4
                {
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                        {'|', ' ', '|', ' ', '|', ' ', '|'},
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                },
                // Dice face 5
                {
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                        {'|', ' ', '|', 'O', '|', ' ', '|'},
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                },
                // Dice face 6
                {
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                        {'|', 'O', '|', ' ', '|', 'O', '|'},
                }
        };
    }

    private static void setDices(char[][] firstRoll, char[][] secondRoll) {
        dice1 = dice2 = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                dice1 += firstRoll[i][j];
                dice2 += secondRoll[i][j];
            }
            dice1 += "\n";
            dice2 += (i < 2) ? "\n" : "";
        }
    }

    public String toString() {
        return dice1 + "\n\n" + dice2;
    }

    public int[] roll() {
        int randomDice1 = random.nextInt(6);
        int randomDice2 = random.nextInt(6);
        int[] res = {randomDice1 + 1, randomDice2 + 1};

        if (isDoubles(res[0], res[1])) {
            score += (randomDice1 + 1) * 4;
        } else if (hasSingleOnes(res[0], res[1])) {

        } else {
            score += randomDice1 + randomDice2 + 2;
        }

        setDices(dices[randomDice1], dices[randomDice2]);
        return res;
    }

    public int getValue() {
        return score;
    }

    public boolean isDoubles(int dice1Value, int dice2Value) {
        return dice1Value == dice2Value;
    }

    public boolean hasSingleOnes(int dice1Value, int dice2Value) {
        return (dice1Value == 1 && dice2Value != 1) || (dice1Value != 1 && dice2Value == 1);
    }
}
