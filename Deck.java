package Elevens;
import java.util.*;

/*Class to simulate a deck of cards,
 * uses a pointer to choose which card
 * is on the top of the deck in stead of
 * simply removing the card in order to 
 * save on resources
 */
public class Deck {
	//instance var, array of card objects simulates the deck
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int size;
	
	//Takes 3 arrays of custom rank, suit and value to create a deck
	public Deck(String[] ranks, String[] suits, int[] values) {
		for(int i = 0; i<suits.length; i++) {
			deck.add(new Card(ranks[i], suits[i], values[i]));
		}
		size = suits.length;
		this.shuffle();
	}
	
	//Generic 52 size deck constructor
	public Deck() {
		size = 52;
		String[] rn = {"Clubs", "Spades", "Hearts", "Diamonds"};
		String[] sp = {"Jack", "Queen", "King"};
		for(int i = 0; i<4; i++) {
			for(int j = 1; j<14; j++) {
				if(j>10) {
					deck.add(new Card(sp[j-11], rn[i], 10));
				}
				else if(j==1) {
					deck.add(new Card("Ace", rn[i], 1));
				}
				else {
					deck.add(new Card(""+j, rn[i], j));
				}
			}
		}
		this.shuffle();
	}
	
	//Method to shuffle the deck using random values
	public void shuffle() {
		size = deck.size();
		Random rand = new Random();
		for(int i=0; i<size; i++) {
			int k=rand.nextInt(size);
			Card temp = deck.get(i);
			deck.set(i, deck.get(k));
			deck.set(k, temp);
		}
	}
	
	//returns if the deck "contains" any more cards
	public boolean isEmpty() {
		return size==0;
	}
	
	//returns the current value of size
	public int getSize() {
		return this.size;
	}
	
	//returns the top cards and decrements the value of the size pointer
	public Card deal() {
		if(size>=1) {size--;}
		else if(size==0) {return null;}
		else {throw new ArrayIndexOutOfBoundsException();}
		return deck.get(size);
	}
	
	//returns the string value of the deck
	public String toString() {
		String s ="[";
		for(int i=0; i<size-1; i++) {
			s+=deck.get(i)+", ";
		}
		return s+deck.get(size-1)+"]";
	}
}