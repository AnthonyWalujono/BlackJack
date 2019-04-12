//import java.util.*;
import java.util.LinkedList;
/**
  The play class flips the card and does war
  If player have same rank then it is war.
  Private instance variables are used
  @author Anthony Walujono
*/
public class Player
{
  private String name;
  //use linklist to store the cards on the deck
  private LinkedList<Card> deck;

  /**
  Player class calls the players name.
  @param name
  It makes a new linkedList for deck
  */
  public Player(String name)
  {
    this.name = name;
    deck = new LinkedList<Card>();
  }
  /**
  method Flip: removes and return cards at front of the list
  */
  public Card flip()
  {
    Card first_card = deck.getFirst();
    deck.remove();
    return first_card;
  }
  /**
  The method collect adds a card to the deck.
  @param card
  */
  public void collect(Card card)
  {
    deck.add(card);
  }
  /**
  Has won determine whether the player has 52 Cards
  @return true if it does
  @return false if it does not
  */
  public boolean hasWon()
  {
    if(deck.size() == 52)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  //
  public Card[] war()
  {
    //Card c_array[] = new Card[4];
    Card[] c_array = {};
    int deckSize = deck.size();
    //check to see if the size of the deck is 4 or more
    if (deckSize >= 4)
      c_array = new Card[4];
    else
      c_array = new Card[deckSize];
    //remove the deck for size of 4 or less
    for (int i = 0; i < c_array.length; i++) {
      c_array[i] = deck.remove();
    }
    return c_array;
  }
  public int getDeckSize()
  {
    return deck.size();
  }

  public int getHandValue()
  {
    int handTotal = 0;
    int cardVal;
    int numAces = 0;
    //calculate card's contribution to the player's handTotal
    for(int i = 0; i < getDeckSize(); i++)
    {
      cardVal = deck.get(i).getRank();
      if(cardVal == 14)
      {
        //we got an Ace
        numAces ++;
        handTotal += 11;
      }
      else if(cardVal > 10)
      {
        //face card
        handTotal += 10;
      }
      else
      {
        handTotal += cardVal;
      }
    }
    //if we have access and our sum is >21, set some or all
    while(handTotal > 21 && numAces > 0)
    {
      handTotal -= 10;
      numAces--;
    }
    return handTotal;
  }
  //Print cards
  //@param show first card whether the card is hidden or not
  public void printHandCard(boolean showFstCard)
  {
    System.out.println(name + " cards: ");
    for(int i = 0; i < getDeckSize(); i++)
    {
      if(i == 0 && !showFstCard)
      {
        System.out.println(" [Hidden]");
      }
      else
      {
        System.out.println(deck.get(i).toString());
      }
    }
  }
}
