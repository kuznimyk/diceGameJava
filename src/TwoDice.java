import java.lang.Math;
import java.util.Random;
public class TwoDice {
    // Create arrays to represent each number on a standard dice
    static Random random;
    static int score;
    private static char[][][] dices;

    public TwoDice() {
        makeDieAsArray();
        score = 0;
        random = new Random(System.currentTimeMillis());
    }

    private static void makeDieAsArray() {
        dices = new char[][][]{
                {
                        {' ', ' ', ' '},
                        {' ', 'o', ' '},
                        {' ', ' ', ' '}
                },

                {
                        {'o', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', 'o'}
                },

                {
                        {'o', ' ', ' '},
                        {' ', 'o', ' '},
                        {' ', ' ', 'o'}
                },

                {
                        {'o', ' ', 'o'},
                        {' ', ' ', ' '},
                        {'o', ' ', 'o'}
                },

                {
                        {'o', ' ', 'o'},
                        {' ', 'o', ' '},
                        {'o', ' ', 'o'}
                },
                {
                        {'o', ' ', 'o'},
                        {'o', ' ', 'o'},
                        {'o', ' ', 'o'}
                }};
    }

    public static void toString(char[][] dice1, char[][] dice2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dice1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dice2[i][j]);
            }
            System.out.println();
        }
    }

    public static void roll() {
        int randomDice1 = random.nextInt(6) ;
        System.out.println(randomDice1);
        // Set a different seed

        int randomDice2 = random.nextInt(6) ;
        System.out.println(randomDice2);
        char[][] dice1 = dices[randomDice1];
        char[][] dice2 = dices[randomDice2];
        toString(dice1, dice2);
    }

    public void getValue() {

    }

    public void isDoubles() {

    }

    public void hasSingleOnes() {

    }
}
