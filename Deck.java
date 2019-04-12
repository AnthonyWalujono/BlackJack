//import java.util.*;
import java.util.LinkedList;
import java.util.Random;
/**
  The Deck class creates a deck. It has
  a deal class to remove a random card.
  @author Anthony Walujono
*/
public class Deck
{
    private Card card;
    private LinkedList<Card> deck = new LinkedList<Card>();
    //adds cards to the deck
    public void create()
    {
      for(int i = 2; i < 15; i++)
      {
        for(int j = 0; j < 4; j++)
        {
          Card x = new Card(i,j);
          deck.add(x);
        }
      }
    }
    /** method deal: removes a random card from the list & returns that card
    @return card_x
    */
    public Card deal()
    {
      final int min = 0;
      final int max = deck.size() - 1;
      Random rand = new Random();
      int rand_card = rand.nextInt(max - min + 1) + min;
      Card card_x = deck.get(rand_card);
      deck.remove(rand_card);
      return card_x;
    }
    //check to see if the deck size is not empty
    public boolean hadMoreCards()
    {
      return (deck.size() > 0);
    }
    /**
    getDeckSize @return deck.size()
    */
    public int getDeckSize()
    {
      return deck.size();
    }

}
