package Elevens;
import java.util.*;

public class ElevensBoard extends Board {
	
	//Intance var.
	private static final int BOARD_SIZE = 9;
	private static final boolean DEBUGGING = false;
	
	//Constructor
	public ElevensBoard() {super(BOARD_SIZE, new Deck());}
	
	//Return if a play is legal
	public boolean isLegal(ArrayList<Integer> selCards) {
		if(selCards.size() == 2) {
			return containsPairSum11(selCards);
		}
		else if(selCards.size() == 3) {
			return containsJQK(selCards);
		}
		return false;
	}
	
	//Return true if another play is possible on the board
	public boolean anotherPlayIsPossible() {
		ArrayList<Integer> selIndexes = this.cardIndexes();
		return (containsPairSum11(selIndexes) || containsJQK(selIndexes));
	}
	
	//Checks if an ArrayList contains a pair which sums to 11
	public boolean containsPairSum11(ArrayList<Integer> index) {
		for(int i=0; i<index.size(); i++) {
			Card c = cards[index.get(i)];
			for(int j=0; j<index.size(); j++) {
				if(i == j) {continue;}
				if(c.getValue() + cards[index.get(j)].getValue() == 11) {return true;};
			}
		}
		return false;
	}
	
	//Checks if an ArrayList contains a JQK pair
	public boolean containsJQK(ArrayList<Integer> index) {
		boolean hasJack = false;
		boolean hasQueen = false;
		boolean hasKing = false;
		
		for(Integer i : index) {
			if(cards[i].getRank().equals("jack")) {hasJack = true;}
			if(cards[i].getRank().equals("queen")) {hasQueen = true;}
			if(cards[i].getRank().equals("king")) {hasKing = true;}
		}
		return hasJack && hasQueen && hasKing;
	}
}
