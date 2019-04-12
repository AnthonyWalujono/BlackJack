/**
Card class gives the rank and suit of the card
Rank and Suit are private integers.
We use a toString method to change the Rank and the Suit into Strings
@author Anthony Walujono
*/
public class Card
{
  private int rank;
  private int suit;

  public Card(int c_rank, int c_suit)
  {
    rank = c_rank;
    suit = c_suit;
  }

  /**
  Getter method for getRank
  @return integer of rank
  */
  public int getRank()
  {
    return rank;
  }

  /**
  Getter method for getSuit
  @return integer of suit
  */
  public int getSuit()
  {
    return suit;
  }
  /**
  The setRank sets rank into @param c_rank
  */
  public void setRank(int c_rank)
  {
    rank = c_rank;
  }
  /**
  The setSuit sets suit into @param c_suit.
  */
  public void setSuit(int c_suit)
  {
    suit = c_suit;
  }
  /**
  The toString gives a description of rank and suit of each of the cards.
  We use switch statements to convert rank and suit into string
  @return the_rank
  @return the_suit
  */
  public String toString()
  {
    String the_rank;
    String the_suit;
    switch(rank)
      {
        case 2:
          the_rank = "2";
          break;
        case 3:
          the_rank = "3";
          break;
        case 4:
          the_rank = "4";
          break;
        case 5:
          the_rank = "5";
          break;
        case 6:
          the_rank = "6";
          break;
        case 7:
          the_rank = "7";
          break;
        case 8:
          the_rank = "8";
          break;
        case 9:
          the_rank = "9";
          break;
        case 10:
          the_rank = "10";
          break;
        case 11:
          the_rank = "Jack"; //Rank is Jack
          break;
        case 12:
          the_rank = "Queen"; //Rank is Queen
          break;
        case 13:
          the_rank = "King"; //Rank is King
          break;
        case 14:
          the_rank = "Ace"; //Rank is Ace
          break;
        default:
          the_rank = "No rank applicable"; //if rank is 1, greater than or equal to 15
          break;
      }
    switch(suit)
      {
        case 0:
          the_suit = "Hearts";
          break;
        case 1:
          the_suit = "Spades";
          break;
        case 2:
          the_suit = "Clubs";
          break;
        case 3:
          the_suit = "Diamonds";
          break;
        default:
          the_suit = "No suit applicable"; //if the suit is 4 or greater
          break;
      }
    return the_rank + " of " + the_suit;
  }
}
