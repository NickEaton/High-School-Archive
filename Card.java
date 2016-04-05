package Elevens;

//Class to simulate a card
public class Card {
	
	//instance variables
	private String rank;
	private String suit;
	private int value;
	
	//Basic Constructor
	public Card(String r, String s, int v) {
		rank = r;
		suit = s;
		value = v;
	}
	
	//Accessor for rank
	public String getRank() {
		return this.rank;
	}
	
	//Accessor for suit
	public String getSuit() {
		return this.suit;
	}
	
	//Accessor for the internal value
	public int getValue() {
		return this.value;
	}
	
	//Comparator method to check if 2 card objects are equal
	public boolean equals(Card c) {
		return c.getValue()==this.value && c.getSuit().equals(this.suit) && c.getRank().equals(this.rank);
	}
	
	//@Override toString from Object superclass
	public String toString() {
		return this.rank+" of "+suit+" (point value = "+value+")";
	}
}
