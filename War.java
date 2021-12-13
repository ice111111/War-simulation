import java.util.ArrayList;
import java.util.Random;

public class War {
  private ArrayList<Card> player1Hand, player2Hand, player1Trash, player2Trash, tableCards;
  private Deck deck;
  private boolean gameIsOver;
  private int roundNum;
  private Random rand;

  public War() {
    this.initializeGame();
  }

  public void initializeGame() {
    //initialize gameIsOver to false
    this.gameIsOver = false;
    
    //initialize roundNum to 0
    this.roundNum = 0;
    

    //initialize player1Trash to new empty ArrayList
    this.player1Trash = new ArrayList<Card>();
    
    //initialize player2Trash to new empty ArrayList
    this.player2Trash = new ArrayList<Card>();

    //intialize deck using Deck constructor
    this.deck = new Deck();

    this.rand = new Random();
    
    //shuffle the deck (see class Deck)
    deck.shuffleDeck();
    
     

    //initialize player1Hand to new empty ArrayList
    this.player1Hand = new ArrayList<Card>();
    
    //add the first 26 cards of deck to player1Hand
    for (int i = 0; i <= 26; i++) {
      player1Hand.add(deck.getDeck()[i]);
    }

    //initialize player2Hand to new empty ArrayList
    this.player2Hand = new ArrayList<Card>();
    
    //add the latter 26 cards of deck to player2Hand
    for (int i = 27; i <= 51; i++) {
      player2Hand.add(deck.getDeck()[i]);
    }

    //initialize tableCards to new empty ArrayList
    this.tableCards = new ArrayList<Card>();
  }


  public void playWar() {
    //while the game is not yet over
    while (!gameIsOver) {
      checkForEmptyHands();
      checkIfGameOver();
      cardBattle();
      roundNum++;
    }

    confirmWinner();
      //play a round (see below)
      
      //increment roundNum
    
    //confirm winner (see below)
    
  }


  public void checkForEmptyHands() {
    //if player1Hand has no cards
    if (player1Hand.size() == 0 && player1Trash.size() > 0) {
      shuffle(player1Trash);
      for (int i = player1Trash.size()-1; i >= 0; i--) {
        Card temp = player1Trash.remove(i);
        player1Hand.add(temp);
      }


    }

    if (player2Hand.size() == 0 && player2Trash.size() > 0) {
      shuffle(player2Trash);
      for (int i = player2Trash.size()-1; i >= 0; i--) {
        Card temp = player2Trash.remove(i);
        player2Hand.add(temp);
      }

    }
      //shuffle player1's discard pile (see below)
      
      //loop through player1Trash
      
        //remove the current card from the trash
        
        //add the card to player1's hand
        
    //if player2Hand has no cards
    
      //shuffle player2's discard pile (see below)
      
      //loop through player2Trash
      
        //remove the current card from the trash
        
        //add the card to player2's hand
        
    
  }

  public void shuffle(ArrayList<Card> hand) {
    //declare and initialize a Random object
    
    for (int i = 0; i < 100000; i++) {
      int randIndex1 = this.rand.nextInt(hand.size());
      int randIndex2 = this.rand.nextInt(hand.size());
      while(randIndex1 == randIndex2) {
        randIndex1 = this.rand.nextInt(hand.size());
        randIndex2 = this.rand.nextInt(hand.size());
      }
      Card temp = hand.get(randIndex2);
      Card temp2 = hand.get(randIndex1);
      hand.set(randIndex1, temp);
      hand.set(randIndex2, temp2);
    }
  
    //loop 100,000 times
    
      //get 2 random indices from hand
      
      //swap the cards at the two random indices
      
    
  }


  public void cardBattle() {

    if (gameIsOver = false) {
    //remove a card from player1's hand and store for later
      Card card1 = player1Hand.remove(0);
    //remove a card from player2's hand and store for later
      Card card2 = player2Hand.remove(0);
    
    //Print out the two cards that each player played
    //e.g. Player 1 plays the King of Diamonds
      System.out.println("Player 1 plays the " + card1);
      System.out.println("Player 2 plays the " + card2);
    

    //add both player cards to tableCards
      tableCards.add(card1);
      tableCards.add(card2);
    
    
    //create an int and store the VALUE of player 1's card
      int int1 = card1.getValue();

    
    //create an int and store the VALUE of player 2's card
      int int2 = card2.getValue();
    

    //create a boolean p1Wins and initialize it to false
      boolean p1Wins = false;
      boolean p2Wins = false;

    //if player 1 value equals player 2 value
    
      //choose a random winner (p1Wins should be randomly true or false)

    //else if player 1 value greater than player 2 value
    
      //p1Wins is true

      if (int1 == int2) {
        int random = rand.nextInt(2);
        if (random == 1) {
          p1Wins = true;
          System.out.println("Player 1 wins the round");
          rewardWinner(1);
        } else {
          p2Wins = true;
          System.out.println("Player 2 wins the round");
          rewardWinner(2);
        }
      }

      if (int1 > int2) {
        p1Wins = true;
        System.out.println("Player 1 wins the round");
        rewardWinner(1);
      }

      if (int2 > int1) {
        p2Wins = true;
        System.out.println("Player 2 wins the round");
        rewardWinner(2);
      }
  
    //if player 1 wins
    
      //Print out that player 1 wins the round
      
      //Reward player 1 as the winner (see below)
    
    //else
    
      //Print out that player 2 wins the round
      
      //Reward player 2 as the winner (see below)

    //Print out how many TOTAL cards each player has
      int total1 = (player1Hand.size() + player1Trash.size());
      int total2 = (player2Hand.size() + player2Trash.size());
      System.out.println("Player 1 total card #: " + total1 + "\nPlayer 2 total card #: " + total2);
    
    
    //Print out a blank line
      System.out.println();

    }

  }
  
  /*  
      The int winner refers to player 1 and player 2
      1 for player1, 2 for player2 :)
  */
  public void rewardWinner(int winner) {
    //if the winner of the round is player 1
    
      //Print out the tableCards list and say that those cards were added to player 1's discard pile
      
      //loop through tableCards
      

        //remove the current card and store it
        
        //add the card to player 1's discard pile
    
    if (winner == 1) {
      System.out.println(tableCards);
      System.out.println("These cards will be added to Player 1's discard pile");
      for (int i = tableCards.size()-1; i >= 0; i--) {
        Card temp = tableCards.remove(i);
        player1Trash.add(temp);
      }
    }

    if (winner == 2) {
      System.out.println(tableCards);
      System.out.println("These cards will be added to Player 2's discard pile");
      for (int i = tableCards.size()-1; i >= 0; i--) {
        Card temp = tableCards.remove(i);
        player2Trash.add(temp);
      }
    }


    //else if the winner of the round is player 2
    
      //Print out the tableCards list and say that those cards were added to player 2's discard pile
      
      //loop through tableCards
      

        //remove the current card and store it
        
        //add the card to player 2's discard pile
        
        

  }

  public void checkIfGameOver() {
    //if player 1's hand and player 1's discard pile have no cards OR player 2's hand and player 2's discard pile have no cards
    

      //set gameIsOver to true
          
    if ((player1Hand.size() == 0 && player1Trash.size() == 0) || player2Hand.size() == 0 && player2Trash.size() == 0) {
      boolean gameisOver = true;
    }

  }

  public void confirmWinner() {
    //if player 1's hand and player 1's discard pile have no cards
    
      //print out that player 2 win in roundNum rounds
      
    if (player1Hand.size() == 0 && player1Trash.size() == 0) {
      System.out.println("Player 2 has won after " + roundNum + " rounds.");
    }

    if (player2Hand.size() == 0 && player2Trash.size() == 0) {
      System.out.println("Player 1 has won after " + roundNum + " rounds.");
    }
      
    //if player2's hand and player2's discard pile have no cards
    
      //print out that player 1 wins after roundNum rounds
      
      
  }
}
