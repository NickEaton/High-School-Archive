package Elevens;
import java.util.*;

public abstract class Board {
	
	//Instance var.
	protected Card[] cards;
	protected Deck deck;
	private static final boolean DEBUGGING = false;
	
	//Abstract Methods
	public abstract boolean isLegal(ArrayList<Integer> selCards);
	public abstract boolean anotherPlayIsPossible();
	
	//Constructor
	public Board(int size, Deck d) {
		this.deck = d;
		this.cards = new Card[size];
		if(DEBUGGING) {
			System.out.println(this.deck + "\n------------");
		}
		dealCards();
	}
	
	private void dealCards() {
		for(int i=0; i < cards.length; i++) {
			cards[i] = deck.deal();
		}
	}
	
	//Method to reset deck
	public void newGame() {
		deck.shuffle();
		dealCards();
	}
	
	//Size accessor
	public int getSize() {return this.cards.length;}
	
	//Deck size access
	public int getDeckSize() {return this.deck.getSize();}
	
	//Returns true if the deck is "out" of cards
	public boolean isEmpty() {
		return cards.length == 0;
	}
	
	//Deals a card to the board
	public void deal(int k) {
		cards[k] = deck.deal();
	}
	
	//Gets a card on the board	
	public Card cardAt(int k) {return cards[k];}
	
	//Returns a list of the indexes of all non-null cards on the board
	public ArrayList<Integer> cardIndexes() {
		ArrayList<Integer> c = new ArrayList<Integer>();
		for(int i=0; i<cards.length; i++) {
			if(cards[i]!=null) {
				c.add(i);
			}
		}
		return c;
	}
	
	//Prints out a list of the cards in play to the console
	public String toString() {
		String s = "";
		for(int i=0; i < cards.length-1; i++) {
			s+=cards[i]+", ";
		}
		return s+cards[cards.length-1];		
	}
	
	//Returns true if the game is won by the player
	public boolean gameIsWon() {
		if(deck.isEmpty()) {
			for(Card c : cards) {
				if(c != null) {return false;}
			}
		}
		return true;
	}
	
	//Replacing card pairs removed by the user
	public void replaceSelected(ArrayList<Integer> indexes) {
		for(Integer i : indexes) {
			deal(i.intValue());
		}
	}
}
