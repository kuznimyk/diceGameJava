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


    //constructor to intialize variables above
    public TwoDice() {
        makeDieAsArray();
        score = 0;
        random = new Random(System.currentTimeMillis());
        dicesOutput = "";
    }

    //function that stores dices in char form, value of the dice = index of the dice + 1
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

    //turns the arrays of the character into single string which then is easier to print out
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

    //ovveriding the string class so the output is the dices
    public String toString() {
        return dicesOutput;
    }


    //function roll that rolls the dices, get random value from 1 to 6

    public int[] roll() {
        int randomDice1 = random.nextInt(6);
        int randomDice2 = random.nextInt(6);
        int[] res = {randomDice1 + 1, randomDice2 + 1};

        //checks for doubles or one on dice and adds up to the total score
        if (isDoubles(res[0], res[1])) {
            score += (randomDice1 + 1) * 4;
        } else if (hasSingleOnes(res[0], res[1])) {

        } else {
            score += randomDice1 + randomDice2 + 2;
        }
        //sends the numbers into function that will convert the numbers into the output in console
        setDices(dices[randomDice1], dices[randomDice2]);
        return res;
    }

    //returns the score of the current player
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
