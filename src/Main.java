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
        player.roll();
    }   
}