/*
The purpose of the code is to ask a user whether he wants to play a game, and if the
answer is positive ask which game he wants to play. If the user does not want to play
then print out "Do something else", if the user wants to play some other type of game 
print "No more time to play! Back to programming"
Mykyta Kuznietsov
AUCSC 112 LAB
1796090
February 10th 2024
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TwoDice game = new TwoDice();
        System.out.println("================================");
        System.out.println("The Dice Game");
        System.out.println("How Much Can You Afford to Lose?");
        System.out.println("================================");
        System.out.println("Roll the dice, accumulating the total to add to your score.");
        System.out.println("Hit 60 before the computer and you win!");
        System.out.println("If you roll doubles, you get double the value and roll again.");
        System.out.println("If you roll a one, you lose the current round's total, unless it's snake eyes!");
        System.out.println("Here we go...");
        System.out.println("================================");

        boolean playerTurn = true;
        int playerScore = 0;
        int computerScore = 0;

        // Game loop
        while (playerScore < 60 && computerScore < 60) {
            if (playerTurn) {
                System.out.println("Your turn");
                boolean keepRolling = true;
                int roundScore = 0;

                while (keepRolling) {
                    System.out.println("Rolling...");
                    int[] roll = game.roll();
                    System.out.println(game.toString());

                    if (roll[0] == 1 && roll[1] == 1) {
                        System.out.println("OH NO...Snake eyes! You lost it all!");
                        playerScore = 0;
                        keepRolling = false;
                    } else if (game.hasSingleOnes(roll[0], roll[1])) {
                        System.out.println("A single one is not good. You lost the round's points.");
                        roundScore = 0;
                        keepRolling = false;
                    } else if (game.isDoubles(roll[0], roll[1])) {
                        System.out.println("Doubles! Roll again.");
                        roundScore += (roll[0] + roll[1]) * 2;
                    } else {
                        roundScore += roll[0] + roll[1];
                        keepRolling = false;
                    }
                }

                playerScore += roundScore;
                System.out.println("Score: Player " + playerScore + "; Computer " + computerScore);
                playerTurn = false;
            } else {

                System.out.println("Computer's turn");
                int computerRoll = game.roll()[0] + game.roll()[1];
                if (computerRoll == 2) {
                    computerScore = 0;
                    System.out.println("Computer rolled snake eyes and lost all points!");
                } else {
                    computerScore += computerRoll;
                }
                System.out.println("Score: Player " + playerScore + "; Computer " + computerScore);
                playerTurn = true;
            }


            if (playerScore >= 60) {
                System.out.println("Congratulations! You win!");
                break;
            } else if (computerScore >= 60) {
                System.out.println("Sorry, the computer wins this time.");
                break;
            }
        }

        System.out.println("Game Over.");
    }
}
