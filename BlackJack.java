/**
  BlackJack class plays the rule of the card game Black Jack.
  It calls the Card, Deck, and Player classes
  There are two players: the user and the dealer (the computer)
  The objective of this game is the first player get 21 cards wins the Game
  Or if the first player gets over 21 cards then the other player wins.
  @author Anthony Walujono
*/
import java.util.Scanner;
public class BlackJack
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    Deck cardDeck = new Deck();
    cardDeck.create();

    Player me = new Player("My");
    Player dealer = new Player("Dealer");
    me.collect(cardDeck.deal());
    dealer.collect(cardDeck.deal());
    me.collect(cardDeck.deal());
    dealer.collect(cardDeck.deal());

    System.out.println("Here are initial cards");
    me.printHandCard(true);
    dealer.printHandCard(false);

    boolean meFinish = false;
    boolean dealerFinish = false;
    String answ;

    /**
    This while loop plays the game until players won the game.
    meFinish and dealerFinish
    If the user responds hit(H) then a card needs to be added and
    we need to check if user is busted.
    If myHand/myDeck (card value) is greater than 21, then they cannot hit.
    If card value is less than 21 then they continue to hit
    If the player resonds Stay (S) then their card do not add to the deck.
    if(!meFinish) is the user's turn.
    if(!dealerFinish) is dealer's turn.
    */
    while(!meFinish || !dealerFinish)
    {
      if(!meFinish)
      {
        System.out.println("Hit or Stay (Enter H or S)");
        answ = userInput.next();
        System.out.println();
        if(answ.compareToIgnoreCase("H") == 0)
        {
          me.collect(cardDeck.deal());
          int myHand = me.getHandValue();
          if(myHand >= 21)
          {
            meFinish = true;
          }
          else
          {
            meFinish = false;
          }
        }
        else
        {
          meFinish = true;
        }
      }
      if(!dealerFinish)
      {
        if(dealer.getHandValue() < 17)
        {
          System.out.println("Dealer hits\n");
          dealer.collect(cardDeck.deal());
          int dealerHand = dealer.getHandValue();
          if(dealerHand >= 21)
          {
            dealerFinish = true;
          }
          else
          {
            dealerFinish = false;
          }
          dealer.printHandCard(false);
        }
        else
        {
          System.out.println("Dealer Stays \n");
          dealerFinish = true;
        }
    }
    System.out.println();
    System.out.println("Final Cards");
    me.printHandCard(true);
    System.out.println();
    dealer.printHandCard(true);
    int meSum = me.getHandValue();
    int dealerSum = dealer.getHandValue();

    /**
      This if-else statement prints which player won (user or dealer)
      If the either players get over 21 cards then their opponents won.
      If the first player gets 21 cards then they won.
    */
    if(meSum > dealerSum && meSum <= 21 || dealerSum > 21)
    {
      System.out.println();
      System.out.println("You won!!");
    }
    else
    {
      System.out.println();
      System.out.println("Dealer won :(");
    }
  }
  userInput.close();
  }
}
