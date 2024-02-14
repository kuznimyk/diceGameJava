/*

                                                Ý Æ Ã-Ø Œ ¿

Code description:
    The purpose of the code is to include the user in making decisions about how to play the game. It asks the user
    whether they would like to play the game first. If the answer is yes, it asks what kind of game the user is most
    interested in. On the other hand, in the event that the user chooses not to participate, it boldly recommends,
    "Think about doing something else." When the user wants to switch to a different game, it firmly suggests, "Game
    time is up! Come back to programming, please."

Authors:
    * Mykyta Kuznietsov
    * Vadim Rudenko

Class:
    * AUCSC 112 LAB 1H04

ID numbers:
    * 1796900
    * 1793290

Date:
    * 13 Feb, 2024

Task spreading:
    * File TwoDice.java:
         Mykyta, except for getValue(), isDoubles(), hasSingleOnes() methods
    * File Main.java:
         Vadim, except for minor code fixing

*/


import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //create two players
        TwoDice player = new TwoDice();
        TwoDice computer = new TwoDice();
        //init keyboard and scanner
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
        //checks if its player's turn
        boolean playerTurn = true;
        //get's two values of the dice that rolled
        int[] roll = new int[2];
        // Game loop
        //game goes until player or computer reach 60 and over
        while (player.getValue() < 60 && computer.getValue() < 60) {
            if (playerTurn) {
                System.out.println("Your turn");


                    //sleep so that the console doesnt run that fast
                    try {
                        Thread.sleep(2000);
                    }
                    catch(Exception ex){}
                    roll = player.roll();
                    System.out.println("\n\n" + player);
                    //checks for the single and doubles
                    if (player.hasSingleOnes(roll[0], roll[1])) {
                        System.out.println("Your turn is over");
                        playerTurn = false;
                    } else if (player.isDoubles(roll[0], roll[1])) {
                        System.out.println("Doubles! Roll again.");
                        continue;
                    }
                    //asks if the player wants to roll again
                    System.out.println("Score: Player " + player.getValue() + "; Computer " + computer.getValue());
                    if (playerTurn) {
                        System.out.println("Do you want to roll agian?y/n");
                        String rollagain = keyboard.next();
                        if (rollagain.charAt(0) == 'y' || rollagain.charAt(0) == 'Y') {
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
                    //checks if the computer rolled single of doubles
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
        //if the player had bigger score than computer print you win
        if (player.getValue() > computer.getValue()){
            System.out.println("You won!");
        }
        else{
            System.out.println("Computer won");
        }
    }
}
