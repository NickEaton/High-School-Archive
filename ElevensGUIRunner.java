package Elevens;

public class ElevensGUIRunner {
	
	//Main method to run the elevens game
	public static void main(String[] args) {
		Board board = new ElevensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
