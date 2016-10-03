
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface
{
	private Card[] deck = new Card[52];
	private int nxt_Card;
	private int numCardsRemaining;
	
	public DeckOfCards()
	{
	    restoreDeck();
	}
	/**
	* Shuffles the deck by randomly exchanging each card with another card.
	*/
	public void shuffle()
	{
	Random generator = new Random();
 
	// attempt to swap each card with a random card in the deck
	// this isn't a perfect shuffle but it is a simple one
	// a better shuffle requires a more complex algorithm
 
	for (int i=0; i< deck.length; i++) {
	int j = generator.nextInt(deck.length);
	Card temp = deck[i];
	deck[i] = deck[j];
	deck[j] = temp;
	}
 
	//don't forget to reset any variables you're using
	// to keep track of dealt and remaining cards
	numCardsRemaining = deck.length;
	nxt_Card = 0;
	}
	
	/**
	*
	*
	*/
	public Card draw()
	{
	nxt_Card++;
		if (nxt_Card >= deck.length)
		{
		return null;
		}
		return deck[nxt_Card-1];
	}
	
	/**
	*
	*
	*/
	public void restoreDeck()
	{
	int i = 0;
	deck = new Card[52];
	for (Suit suit: Suit.values())
	{
		for(FaceValue faceValue: FaceValue.values())
		{
			deck[i] = new Card(suit, faceValue);
			i++;
		}
	}
	nxt_Card = 0;
	}
	
	/**
	*
	*
	*/
	public int numCardsRemaining()
	{
		return deck.length-nxt_Card;
	}
	
	/**
	*
	*
	*/
	public int numCardsDealt()
	{
		return nxt_Card;
	}
	
	/**
	*
	*
	*/
	public Card[] dealtCards()
	{
		if(nxt_Card >= deck.length)
		{
			return null;
		}
		Card[] dealt = new Card[numCardsDealt()];
		
		for(int i = 0; i < nxt_Card; i++)
		{
			dealt[i]= deck[i];
		}
		return dealt;
	}
	
	/**
	*
	*
	*/
	public Card[] remainingCards()
	{
		if(nxt_Card >= deck.length)
		{
			return null;
		}
		
		Card[] remaining=new Card[numCardsRemaining()];
		
		for(int i = nxt_Card; i < deck.length; i++)
		{
			remaining[i] = deck[i];
		}
		return remaining;
	}
	
	/**
	*
	*
	*/
	public String toString()
	{
		String str= "";
		int num_card = 1;
		for (Card card: deck)
		{
		 str += card.toString() + " ";
		 if (num_card % 4 == 0)
		 {
		  str += "\n";
		 }
		 num_card++;
		}
		return str;
	}
	
	
	
	
}