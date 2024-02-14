//Authors: Mykyta Kuznietsov, Vadim Rudenko
//Class: AUCSC 112 LAB 1H04
//ID numbers: 1796090, 1793290
//Date: Feb 13, 2024

import java.lang.Math;
import java.util.Random;

public class TwoDice {
    private static Random random;
    private static char[][][] dices;
    private  int score;
    static String dicesOutput;

    public TwoDice() {
        makeDieAsArray();
        score = 0;
        random = new Random(System.currentTimeMillis());
        dicesOutput = "";
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

    private void setDices(char[][] firstRoll, char[][] secondRoll) {
        dicesOutput = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                dicesOutput += firstRoll[i][j];
            }
            dicesOutput += "\t\t";
            for (int j = 0; j < 7;j++){
                dicesOutput += secondRoll[i][j];
            }
            dicesOutput += "\n";
        }
        dicesOutput += "\n\n";

    }

    public String toString() {
        return dicesOutput;
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
