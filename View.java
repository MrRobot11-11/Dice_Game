/*Steven Lantz
ITDEV-140-002
Fall 2019
Assignment 3*/
package lantz_ofakind;

import java.util.Scanner;

public class View {
    
    Scanner input = new Scanner(System.in);

//Method to display who has the round and their totals so far
    public void whoWon(String player, int numberOfWins){
        System.out.println("\n" + player + " has won " + numberOfWins + " of the total rounds.");
    }

//Method to display type of hand the player has rolled; one pair, two pair, etc
    public void displayDiceType(String player, String handType){
        System.out.println("\n" + player + "'s dice poker hand:" + "\t\t"+handType);
    }

//Display dice scores to user; pass in user or computer
    public void scores(int array[], String player, int round){
        System.out.print("\n" + player + "'s dice for round " + round  + " are: " + "\t");
        for(int value: array)
            System.out.print(value + " ");
    }

 //Displays which round we're in
    public void round(int round){
        System.out.println("\nRound: " + round );
    }

//Displays intro for game
    public void Intro() {
        try {
            System.out.println("Let's play a dice poker game!");
            Thread.sleep(2000);
            System.out.println("\nYou're going to be playing against me!");
            Thread.sleep(2000);
            System.out.println("\nYou'll be player 1 for scoring.");
            Thread.sleep(2000);
            System.out.println("\nWe're each going to get 5 dice to roll.");
            Thread.sleep(2000);
            System.out.println("\nA round is both of us rolling the 5 die that we are given.");
            Thread.sleep(2000);
            System.out.println("\nThe winner of each round will be determined by who has the best dice poker hand. ");
            Thread.sleep(2000);
            System.out.println("\nIf we both have the same number of pairs, the player who has the higher value set of pairs  will win.");
            Thread.sleep(2000);
            System.out.println("\nReady to play?");
            Thread.sleep(2000);            
            System.out.println("\n");
        } catch (Exception e) {
        }
    }

//Ask the user if they would like to play another game
    public Boolean playAgain() {
        System.out.println("\nWould you like to play another game?");
        System.out.println("\n[0] to play another game");
        System.out.println("[1] to quit.");
        if (input.nextInt() == 1) return (true);
        else 
            return (false);
    }

//Outro message
    public void peaceOut() {
        System.out.println("\nThanks for playing!\n");
        try {
            System.out.println("\nSee you next time!\n");
            Thread.sleep(1500);
        } catch (Exception e) {};
    }
    
//Asks the user to press enter to continue to the next round
public void pressEnter(){
      System.out.println("\nPress [enter] to continue...");
      try
      {
      System.in.read();    
      }catch(Exception e){}

  }




}
