import java.lang.Math;
import java.util.Random;
public class TwoDice {
    // Create arrays to represent each number on a standard dice
    static Random random;
    static int score;
    private static char[][][] dices;

     static String dice1;
     static String dice2;



    public TwoDice() {
        makeDieAsArray();
        score = 0;
        random = new Random(System.currentTimeMillis());
        dice1 = "";
        dice2 = "";
    }

    private static void makeDieAsArray() {
        dices = new char[][][]{
                {

                        {'|',' ', '|', ' ', '|', ' ','|'},

                        {'|',' ', '|', 'O', '|', ' ','|'},

                        {'|',' ', '|', ' ', '|', ' ','|'},

                },

                {

                        {'|',' ', '|', ' ', '|', ' ','|'},

                        {'|','O', '|', ' ', '|', 'O','|'},

                        {'|',' ', '|', ' ', '|', ' ','|'},

                },

                {

                        {'|','O', '|', ' ', '|', ' ','|'},

                        {'|',' ', '|', 'O', '|', ' ','|'},

                        {'|',' ', '|', ' ', '|', 'O','|'},

                },

                {

                        {'|','O', '|', ' ', '|', 'O','|'},

                        {'|',' ', '|', ' ', '|', ' ','|'},

                        {'|','O', '|', ' ', '|', 'O','|'},

                },

                {

                        {'|','O', '|', ' ', '|', 'O','|'},

                        {'|',' ', '|', 'O', '|', ' ','|'},

                        {'|','O', '|', ' ', '|', 'O','|'},

                },
                {

                        {'|','O', '|', ' ', '|', 'O','|'},

                        {'|','O', '|', ' ', '|', 'O','|'},

                        {'|','O', '|', ' ', '|', 'O','|'},

                }};
    }

    private static void setDices(char[][] firstroll,char[][] secondroll){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                dice1 += firstroll[i][j];
            }
            dice1 += "\n";
        }
        dice1 += "\n\n\n";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                dice2 += secondroll[i][j];
            }
            dice2 += "\n";
        }
        dice2 += "\n\n";
    }
    public String toString() {
        return dice1 + dice2;
    }

    public int[] roll() {
        int randomDice1 = random.nextInt(6) ;
        int randomDice2 = random.nextInt(6) ;
        int[] res = new int[2];
        if (isDoubles(randomDice1 + 1, randomDice2+1)){
            score += (randomDice1 + 1) * 4;
        }
        else if (hasSingleOnes(randomDice1 + 1, randomDice2 + 1)){
            res[0] = randomDice1 + 1;
            res[1] = randomDice2 + 1;
            return res;
        }
        else{
            score += randomDice1 + randomDice2 + 2;
        }

        char[][] dice1 = dices[randomDice1];
        char[][] dice2 = dices[randomDice2];
        setDices(dice1, dice2 );
        return res;
    }

    public int getValue() {
        return score;
    }

    public boolean isDoubles(int dice1Value, int dice2Value) {
        return true;
    }

    public boolean hasSingleOnes(int dice1Value, int dice2Value) {
        return false;
    }
}
