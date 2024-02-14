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
        TwoDice player = new TwoDice();
        TwoDice computer = new TwoDice();
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
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
        int[] roll = new int[2];
        // Game loop
        while (player.getValue() < 60 && computer.getValue() < 60) {
            if (playerTurn) {
                System.out.println("Your turn");



                    try {
                        Thread.sleep(2000);
                    }
                    catch(Exception ex){}
                    roll = player.roll();
                    System.out.println("\n\n" + player);
                    if (player.hasSingleOnes(roll[0], roll[1])) {
                        System.out.println("Your turn is over");
                        playerTurn = false;
                    } else if (player.isDoubles(roll[0], roll[1])) {
                        System.out.println("Doubles! Roll again.");
                        continue;
                    }
                    System.out.println("Score: Player " + player.getValue() + "; Computer " + computer.getValue());
                    if (playerTurn) {
                        System.out.println("Do you want to roll agian?y/n");
                        String rollagain = keyboard.next();
                        if (rollagain.equals("y")) {
                            continue;
                        } else {
                            playerTurn = false;
                        }



                }


            }
            else {

                System.out.println("Computer's turn");

                    try {
                        Thread.sleep(3000);
                    }
                    catch(Exception ex){}
                    roll = computer.roll();
                    System.out.println("\n\n" + computer);
                    if (computer.hasSingleOnes(roll[0], roll[1])) {
                        System.out.println("Computer rolled one, your turn now");
                        playerTurn = true;
                    } else if (computer.isDoubles(roll[0], roll[1])) {
                        System.out.println("Score: Player " + player.getValue() + "; Computer " + computer.getValue());
                        continue;
                    }
                    System.out.println("Score: Player " + player.getValue() + "; Computer " + computer.getValue());
                    if (rand.nextInt(3) + 1 == 3) {
                        System.out.println("Computer's turn is over");
                        playerTurn = true;
                    }
                    else{
                        continue;
                    }



            }

        }
        if (player.getValue() > computer.getValue()){
            System.out.println("You won!");
        }
        else{
            System.out.println("Computer won");
        }
    }
}
