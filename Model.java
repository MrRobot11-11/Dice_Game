/*Steven Lantz
ITDEV-140-002
Fall 2019
Assignment 3*/
package lantz_ofakind;
import java.util.Random;

public class Model {
    
    Random random = new Random();//Object from random class to generate dice numbers
    
    private int[] diceScores = new int[5]; //Will hold all the random generated numbers
    
    int[] counts = new int[6];//Holds the tally of how many times a score is repeated;
                                               //Helps in determining the type of hand we get

    private int fiveCount = 0; //Five a kind
    private int fourCount = 0; //Four of a kind
    private int threeCount = 0; //Three of a kind
    private int pairCount = 0; //Two of a kind  
    private int oneCount = 0; //One of a kind
    private String handType; //Will store type of hand; ie, pair, three of a kind, etc
    private int totalDiceScores = 0;
    private int handValue;  //This value will be used to rank dice poker hands
    private int tieBreaker = 0;

//Generates a random number & sets the diceScores array accordingly
    public void roll() {
        for (int i = 0; i < diceScores.length; i++) {
            diceScores[i] = random.nextInt(6) + 1;
        }
    }

//Accessors & mutators
    public int[] getCounts(){
        return counts;
    }

    public int[] getDiceScores() {
        return diceScores;
    }

    public int getHandValue(){
        return handValue;
}

    public String getHandType() {
        determineHand();
        determineHandType();
        return handType;
    }

    public int getTotalDiceScores() {
        return totalDiceScores;
    }

    public int getTieBreaker()
    {
        return tieBreaker;
    }

//Method will iterate through the counts array and add a value to the variable "tieBreaker"
//For each set of pairs of w ore more, will add a corresponding value to tieBreaker
//Eg. If counts[0] contains a pair of 2's or more, will add 2 to the variable tieBreaker
//In the case of both players rolling one pair, this value will be used to determine who's hand is worth more.
public void setTieBreaker(){
    for (int i = 0; i < counts.length; i++) {
        for (int j = 2; j < 7; j++) {
            if(counts[i] ==j)
                tieBreaker +=i+1;
        }
    }
}

//This method will tally the number of times a value is stored
// If index zero of the dice arry = 1, index zero of the counts array will add 1
//So index zero of the counts array equals the number of 1's there are, index 1 equals the number of 2's there are, etc
    public void setCounts() {
        
        for (int i = 0; i < diceScores.length; i++) {
            if (diceScores[i] == 1) {
                counts[0]++;
            }
            if (diceScores[i] == 2) {
                counts[1]++;
            }
            if (diceScores[i] == 3) {
                counts[2]++;
            }
            if (diceScores[i] == 4) {
               counts[3]++;
            }
            if (diceScores[i] == 5) {
               counts[4]++;
            }
            if (diceScores[i] == 6) {
                counts[5]++;
            }
        }
    }//End of setCounts method

//Iterate through count array and determine what kind of hand we have
public void determineHand(){
    for (int i = 0; i < counts.length; i++) {
        if (counts[i] == 5) fiveCount++;            //Five of a kind
        else if (counts[i] == 4) fourCount++;   //Four of a kind
        else if (counts[i] == 3) threeCount++; //Three of a kind
        else if (counts[i] == 2) pairCount++; //Two of a kind
        else if (counts[i] == 1) oneCount++; //One of a kind
    }
}

//Uses results from determineHand() and sets variable handType to the result
public void determineHandType(){
    if(fiveCount == 1) handType = "Five of a kind";
    else if(fourCount == 1) handType = "Four of a kind";
    else if(threeCount == 1) {
        if(pairCount == 1) handType = "Full house";
        else handType = "Three of a kind";
    }
    else if(pairCount == 2) handType = "Two pairs";
    else if(pairCount==1) handType = "One pair";
    else handType = "You rolled nothing this round";
}

//Takes result from determineHand() and assigns a value to the type of hand
public void determineHandValue(){
if (handType.equals("Five of a kind"))handValue = 6;
else if (handType.equals("Four of a kind")) handValue = 5;
else if(handType.equals("Full house")) handValue = 4;
else if(handType.equals("Three of a kind")) handValue = 3;
else if(handType.equals("Two pairs")) handValue = 2;
else if(handType.equals("One pair")) handValue = 1;
else handValue = 0;
}

//Takes int[] diceScores and sums the values
//Used in case each player has the same type of hand
public void totalDiceScores(){
    for (int i = 0; i < diceScores.length; i++) 
        totalDiceScores += diceScores[i];
}

//Method that will set variables back to zero when called
public void zeroTotals(){
    fiveCount=0;
    fourCount=0;
    threeCount=0;
    pairCount = 0;
    oneCount = 0;
for (int i = 0; i < counts.length; i++) 
        counts[i] = 0;
totalDiceScores = 0;
tieBreaker = 0;

}

}//End of class