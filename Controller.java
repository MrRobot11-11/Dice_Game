/*Steven Lantz
ITDEV-140-002
Fall 2019
Assignment 3*/
package lantz_ofakind;

public class Controller {

    Model computer = new Model();
    Model player1 = new Model();
    
    View ui = new View();
    
    private int round;
    private int pWins ; //Player wins; will total this value to get overall game winner
    private int cWins; //Computer wins; will total this value to get overall game winner
    
//Acts as my constructor
    public void Play() {

        do {
            round = 1;
            pWins = 0;
            cWins = 0;
            
            while (round <= 10) {
 
//Displays the current round
                ui.round(round);
                
                player1.roll();
//Display player scores to user             
                ui.scores(player1.getDiceScores(), "Player 1", round);

//Sets the player counts (these values are used to determine type of *poker* hand we have)
                player1.setCounts();
                
                ui.displayDiceType("Player 1", player1.getHandType());
//sum the total of dice scores in case there's a tie
                player1.totalDiceScores();
//Assigns a value to the type of hand we have; eg, four of a kind = 4, etc
                player1.determineHandValue();
//This will set the variable 'tieBreaker' in the case of each player getting the same number of pairs
                player1.setTieBreaker();
                
                computer.roll();
//Display computer scores 
                ui.scores(computer.getDiceScores(), "Computer", round);

//Sets the computer counts (these values are used to determine type of *poker* hand we have)
                computer.setCounts();

                ui.displayDiceType("Computer", computer.getHandType());
//sum the total of dice scores in case there's a tie   
                computer.totalDiceScores();
//Assigns a value to the type of hand we have; eg, four of a kind = 4, etc              
                computer.determineHandValue();
//This will set the variable 'tieBreaker' in the case of each player getting the same number of pairs
                computer.setTieBreaker();

//Create a space between scores
                System.out.println();
                
         
               
//Test to see who wins the round
                if(computer.getHandValue() > player1.getHandValue()){ 
//Computer wins by hand value
                    System.out.println("Computer wins this round!" );
                    cWins++;
                    ui.whoWon("Computer", cWins);
                }
//Player wins by hand value
                else if(computer.getHandValue() < player1.getHandValue()) { 
                    System.out.println("Player 1 wins this round!");
                    pWins++;
                    ui.whoWon("Player 1", pWins);
                }
//If a tie occurs comparing hand types, next test will compare who has the better value
//If both players each roll 3 of a kind, this test will determine who has the higher hand value
                else if(computer.getHandValue() == player1.getHandValue()){
                     if (computer.getTieBreaker()> player1.getTieBreaker()){
                         System.out.println("Computer wins this round!" );
                         cWins++;
                         ui.whoWon("Computer", cWins);
                     }
                         else if(computer.getTieBreaker()< player1.getTieBreaker()){
                             System.out.println("Player 1 wins this round!");    
                             pWins++;
                             ui.whoWon("Player 1", pWins);
                         }
                         else System.out.println("It's a tie!  No one wins.");
                }

//Running total of how many rounds played
                round++;

//Set counts back to 0 for each round played
               computer.zeroTotals();
                player1.zeroTotals();

//Once round reaches 10, will no longer ask to press enter
                if (round <= 10) {
                    ui.pressEnter();//Asks user to press enter key after each round
                }
            
            }//End of while loop
        
//Test to see who won the overall game
if (cWins > pWins) {

                System.out.println("\n***********************************************************");
                System.out.println("\nComputer wins with a total of  " + cWins + " games won. ");
                System.out.println("\nBetter luck next time.");
                System.out.println("\n***********************************************************");
            } else if (cWins < pWins) {
                System.out.println("\n***********************************************************");
                System.out.println("\nPlayer 1 wins the game with a total of  " + pWins + " games won.");
                System.out.println("\nNice job!!!");
                System.out.println("\n***********************************************************");

            } else if (cWins == pWins) {
                System.out.println("\n***********************************************************");
                System.out.println("\nIt's a tie overall.  Everyone gets a trophy!");
                System.out.println("\n***********************************************************");
            }

        } while (!ui.playAgain()); //End of do/while loop

    }//End of play();

}//End of class
