package Elevens;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.net.*;

//Provides the interface for the elevens game
public class CardGameGUI extends JFrame implements ActionListener{
	
	//Instance var / board settings
	private static final int HEIGHT = 302;
	private static final int WIDTH = 800;
	private static final int CARD_HEIGHT = 97;
	private static final int CARD_WIDTH = 73;
	private static final int LAYOUT_TOP = 30;
	private static final int LAYOUT_LEFT = 30;
	private static final int LAYOUT_WIDTH = 100;
	private static final int LAYOUT_HEIGHT = 125;
	private static final int BUTTON_TOP = 30;
	private static final int BUTTON_LEFT = 570;
	private static final int BUTTON_HEIGHT = 50;
	private static final int LABEL_TOP = 160;
	private static final int LABEL_LEFT = 540;
	private static final int LABEL_HEIGHT = 35;
	
	//Main board & panel
	private Board board;
	private JPanel panel;
	
	//More initialization / instance var.
	private JButton replaceButton;
	private JButton restartButton;
	private JLabel statusMsg;
	private JLabel totalsMsg;
	private JLabel[] displayCards;
	private JLabel winMsg;
	private JLabel lossMsg;
	
	//Locations of the card displays
	private Point[] cardCoords;
	
	//final instance var
	private boolean[] selections;
	private int totalWins;
	private int totalGames;
	
	//Init the GUI
	public CardGameGUI(Board gameBoard) {
		this.board = gameBoard;
		totalWins = 0;
		totalGames = 0;
		
		//Initialize using 5 cards in ea row
		cardCoords = new Point[board.getSize()];
		int x = LAYOUT_LEFT;
		int y = LAYOUT_TOP;		
		for(int i=0; i<cardCoords.length; i++) {
			cardCoords[i] = new Point(x, y);
			if(i%5 == 4) {
				x = LAYOUT_LEFT;
				y += LAYOUT_HEIGHT;
			} else {
				x += LAYOUT_WIDTH;
			}
		}		
		selections = new boolean[board.getSize()];
		initDisplay();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
	}
	
	//Method to actually run the game
	public void displayGame() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {setVisible(true); }
		});
	}
	
	//Draw the display
	public void repaint() {
		for(int i=0; i < board.getSize(); i++) {
			String cardImageFileName = imageFileName(board.cardAt(i), selections[i]);
			URL imageURL = getClass().getResource(cardImageFileName);
			if(imageURL != null) {
				ImageIcon icon = new ImageIcon(imageURL);
				displayCards[i].setIcon(icon);
				displayCards[i].setVisible(true);
			} else {
				throw new RuntimeException("Card image not found: \""+cardImageFileName+ "\"");
			}
		}		
		statusMsg.setText(board.getDeckSize() + " undealt cards remain. ");
		statusMsg.setVisible(true);
		totalsMsg.setText("You've won "+totalWins+" out of " + totalGames + " games");
		totalsMsg.setVisible(true);
		pack();
		panel.repaint();
	}
	
	//Initialize the display
	private void initDisplay() {
		panel = new JPanel() {
			public void paintComponent(Graphics g) {super.paintComponent(g);}
		};
		
		String className = board.getClass().getSimpleName();
		int classNameLen = className.length();
		int boardLen = "Board".length();
		String boardStr = className.substring(classNameLen - boardLen);		
		if(boardStr.equals("Board") || boardStr.equals("board")) {
			int titleLength = classNameLen - boardLen;
			setTitle(className.substring(0, titleLength));
		}
		
		//Calc # rows of cards & adjust frame if necessary
		int numCardRows = (board.getSize() + 4) / 5;
		int height = HEIGHT;		
		if(numCardRows > 2) {
			height += (numCardRows - 2) * LAYOUT_HEIGHT;
		}
		
		this.setSize(new  Dimension(WIDTH, height));
		panel.setLayout(null);
		panel.setPreferredSize(
				new Dimension(WIDTH - 20, height - 20));
		displayCards = new JLabel[board.getSize()];		
		for(int i=0; i<board.getSize(); i++) {
			displayCards[i] = new JLabel();
			panel.add(displayCards[i]);
			displayCards[i].setBounds(cardCoords[i].x, cardCoords[i].y, CARD_WIDTH, CARD_HEIGHT);
			displayCards[i].addMouseListener(new MyMouseListener());
			selections[i] = false;
		}
		
		replaceButton = new JButton();
		replaceButton.setText("Replace");
		panel.add(replaceButton);
		replaceButton.setBounds(BUTTON_LEFT, BUTTON_TOP, 100, 30);
		replaceButton.addActionListener(this);
		
		restartButton = new JButton();
		restartButton.setText("Restart");
		panel.add(restartButton);
		restartButton.setBounds(BUTTON_LEFT, BUTTON_TOP + BUTTON_HEIGHT,  100,  30);;
		restartButton.addActionListener(this);
		
		statusMsg = new JLabel(
		board.getDeckSize() + "undealt cards remain.");
		panel.add(statusMsg);
		statusMsg.setBounds(LABEL_LEFT, LABEL_TOP, 250, 30);
		
		winMsg = new JLabel();
		winMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT, 200, 30);
		winMsg.setFont(new Font("SansSerif", Font.BOLD, 25));;
		winMsg.setForeground(Color.GREEN);
		winMsg.setText("You win!");
		panel.add(winMsg);
		winMsg.setVisible(false);
		
		lossMsg = new JLabel();
		lossMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT,  200, 30);
		lossMsg.setFont(new Font("SanSerif", Font.BOLD, 25));
		lossMsg.setForeground(Color.RED);
		lossMsg.setText("Sorry, you lose.");
		panel.add(lossMsg);
		lossMsg.setVisible(false);
		
		totalsMsg = new JLabel("You've won " + totalWins + " out of " +totalGames + "games.");
		totalsMsg.setBounds(LABEL_LEFT, LABEL_TOP + 2 * LABEL_HEIGHT, 250, 30);
		panel.add(totalsMsg);
		
		if(!board.anotherPlayIsPossible()) {
			signalLoss();
		}		
		pack();
		getContentPane().add(panel);
		getRootPane().setDefaultButton(replaceButton);
		panel.setVisible(true);
	}
	
	//Deal w/ user clicking on anything other than a button or card
	private void signalError() {
		Toolkit t = panel.getToolkit();
		t.beep();
	}
	
	//Returns the image that corresponds to the input card
	private String imageFileName(Card c, boolean selected) {
		String str = "cards/";
		if(c == null) {
			return "cards/back1.GIF";
		}
		str += c.getRank() + c.getSuit();
		if(selected) {
			str += "S";
		}
		return str + ".GIF";
	}
	
	//Respond to a button click of either the replace || restart button
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(replaceButton)) {
			
			//Get selected cards
			ArrayList<Integer> selection = new ArrayList<Integer>();
			for(int i=0; i<board.getSize(); i++) {
				if(selections[i]) {
					selection.add(new Integer(i));
				}
			}
			
			//Check that the replacement is legal
			if(!board.isLegal(selection)) {
				signalError();
				return;
			}		
			for(int i=0; i<board.getSize(); i++) {
				selections[i] = false;
			}
			
			//Replace
			board.replaceSelected(selection);
			if(board.isEmpty()) {
				signalWin();
			} else if(!board.anotherPlayIsPossible()) {
				signalLoss();
			}
			repaint();
		} else if(e.getSource().equals(restartButton)) {
			board.newGame();
			getRootPane().setDefaultButton(replaceButton);
			winMsg.setVisible(false);
			lossMsg.setVisible(false);
			if(!board.anotherPlayIsPossible()) {
				signalLoss();
				lossMsg.setVisible(true);
			}
			for(int i=0; i<selections.length; i++) {
				selections[i] = false;
			}
			repaint();
		} else {
			signalError();
			return;
		}
	}
	
	//Display win
	private void signalWin() {
		getRootPane().setDefaultButton(restartButton);
		winMsg.setVisible(true);
		totalWins++;
		totalGames++;
	}
	
	//Display loss
	private void signalLoss() {
		getRootPane().setDefaultButton(restartButton);
		lossMsg.setVisible(true);
		totalGames++;
	}
	
	private class MyMouseListener implements MouseListener {
		
		//Handles a mouse click on a card by toggling its 'selected' property
		public void mouseClicked(MouseEvent e) {
			for(int i=0; i<board.getSize(); i++) {
				if(e.getSource().equals(displayCards[i]) && board.cardAt(i) != null) {
					selections[i] = !selections[i];
					repaint();
					return;
				}
			}
			signalError();
		}
		
		//Ignore a mouse exited event, a mouse released event, a mouse entered event, or a mouse pressed event
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		
		
	}
}
