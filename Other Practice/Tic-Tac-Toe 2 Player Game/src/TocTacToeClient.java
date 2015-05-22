/**
 * TocTacToeClient.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Client PLayer 2 for Tic Tac toe
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class GameClient {

	String hostName = "129.21.124.186";
	int port = 4242;
	Socket GameClient;
	PrintWriter out;
	BufferedReader in;
	boolean clientmove = false;
	int playerno = 2;
	int turn = 1;
	boolean gameOver;

	GameClient(int port) {
/**
 * Initialte the connection with the server
 */
		if (connect_to_server(port)) {
			/*
			 * Create the UI for the Tic Tac Toe THe actionlistners of the
			 * Buttons would write on out
			 */
			GUI gui = new GUI();
/*
 * The server will perform the first move so wait for it
 */
			String rline;
			try {
//				gui.status.setText("Waiting for player 1 to make move");
				rline = in.readLine();
				while (rline == null) {
//					gui.status.setText("Waiting for player 1 to make move");
					System.out.println("Waiting for player 1 to make move");
					Thread.sleep(1000);
					rline = in.readLine();
				}
				/*
				 * Update the move by other player
				 */
				JButton updatebutton = gui.cells[Integer.parseInt(rline)];
				updatebutton.setText("O");
//				turn = 2;
//				gui.status.setText("Player 2 move");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

/*
 * Conect to the server
 */
	boolean connect_to_server(int port) {
		try {
			if (initClient()) {// CLient connected to the server
				out = new PrintWriter(GameClient.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
						GameClient.getInputStream()));
				return true;
			} else {
				System.out
						.println("Initilize the server and then try connecting client again");
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Instantiate the client using port
	 */
	boolean initClient() {
		try {
			GameClient = new Socket(hostName, port);
			System.out.println("Second Player Connected");
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Make a Client via port : " + port);
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Close the client
	 */
	void closeServer() {
		try {
			GameClient.close();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to close server");
			e.printStackTrace();
		}
	}

/*
 * Class for the TIC TAC TOE GUI
 */
	/**************************************************************************/
	class GUI extends JFrame {
		private static final String TITLE = "Tic Tac Toe PLAYER 2";
		private static final int WIDTH = 450;
		private static final int HEIGHT = 600;
		private Container content;
		private JLabel result;
		JLabel status;
		JButton[] cells;
		private JButton exitButton;
		private CellButtonHandler[] cellHandlers;
		private ExitButtonHandler exitHandler;
		/*
		 * Set Crosses for Player 2 by default
		 */
		private boolean noughts = false; // Set Crosses to player 2
		/*
		 * Flag to determine the completion of the game
		 */
		private boolean gameOver;

		public GUI() {

			// Necessary initialization code
			setTitle(TITLE);
			setSize(WIDTH, HEIGHT);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			// Get content pane
			content = getContentPane();
			content.setBackground(Color.blue.darker());

			// Set layout
			content.setLayout(new GridLayout(4, 3));

			/*
			 * Buttons for the board
			 */
			cells = new JButton[9];
			cellHandlers = new CellButtonHandler[9];
			for (int i = 0; i < 9; i++) {
				char ch = (char) ('0' + i);
				cells[i] = new JButton("" + ch);
				cellHandlers[i] = new CellButtonHandler();
				cells[i].addActionListener(cellHandlers[i]);
			}

			// Create init and exit buttons and handlers
			exitButton = new JButton("EXIT");
			exitHandler = new ExitButtonHandler();
			exitButton.addActionListener(exitHandler);

			status = new JLabel("Player 1 ", SwingConstants.CENTER);
			status.setForeground(Color.white);

			// Create result label
			result = new JLabel("Crosses", SwingConstants.CENTER);
			result.setForeground(Color.white);

			// Add elements to the grid content pane
			for (int i = 0; i < 9; i++) {
				content.add(cells[i]);
			}
			content.add(status);
			content.add(result);
			content.add(exitButton);
			/*
			 * Initialize
			 */
			init();
		}

		public void init() {
			// Initialize booleans
			noughts = false;
			gameOver = false;

			// Initialize text in buttons
			for (int i = 0; i < 9; i++) {
				char ch = (char) ('0' + i);
				cells[i].setText("" + ch);
			}

			// Initialize result label
			result.setText("Noughts");

			setVisible(true);
		}

		/*
		 * Check for the winner
		 */
		public boolean checkWinner() {
			if (cells[0].getText().equals(cells[1].getText())
					&& cells[1].getText().equals(cells[2].getText())) {
				return true;
			} else if (cells[3].getText().equals(cells[4].getText())
					&& cells[4].getText().equals(cells[5].getText())) {
				return true;
			} else if (cells[6].getText().equals(cells[7].getText())
					&& cells[7].getText().equals(cells[8].getText())) {
				return true;
			} else if (cells[0].getText().equals(cells[3].getText())
					&& cells[3].getText().equals(cells[6].getText())) {
				return true;
			} else if (cells[1].getText().equals(cells[4].getText())
					&& cells[4].getText().equals(cells[7].getText())) {
				return true;
			} else if (cells[2].getText().equals(cells[5].getText())
					&& cells[5].getText().equals(cells[8].getText())) {
				return true;
			} else if (cells[0].getText().equals(cells[4].getText())
					&& cells[4].getText().equals(cells[8].getText())) {
				return true;
			} else if (cells[2].getText().equals(cells[4].getText())
					&& cells[4].getText().equals(cells[6].getText())) {
				return true;
			} else {
				return false;
			}
		}

		private class CellButtonHandler implements ActionListener {

			/*
			 * Check if the turn is f (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				String rline = null;
				{
					// If game over, ignore
					if (gameOver) {
						return;
					}

					// Get button pressed
					JButton pressed = (JButton) (e.getSource());

					// Get text of button
					String text = pressed.getText();

					// If noughts or crosses, ignore
					if (text.equals("O") || text.equals("X")) {
						return;
					}

					if (noughts) {
						// For player 1
						try {
							/*
							 * Send the number of the button clicked and wait
							 * for a move from other player to proceed ahead
							 */
							System.out.println("BUtton Pressed 1 ");
							out.println(text);
							pressed.setText("O");
							// Wait for a move from player 2
							rline = in.readLine();
							while (rline == null) {
//								status.setText("Waiting for player 2 to make move");
								System.out
										.println("Waiting for player 2 to make move");
								Thread.sleep(1000);
								rline = in.readLine();
								System.out.println(rline);
							}

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						/*
						 * Move is recieved from the second player Get the
						 * button number and update the text of the user
						 */
						System.out.println("MOvegot " + rline);
						JButton updatebutton = cells[Integer.parseInt(rline)];
						updatebutton.setText("X");
//						status.setText("Player 1 move");

						// text
					} else {
						// For player 2
						try {
							/*
							 * Send the number of the button clicked and wait
							 * for a move from other player to proceed ahead
							 */
							pressed.setText("X");
							out.println(text);
							if (checkWinner()) {
								// End of game
								gameOver = true;
								// Display winner message
								result.setText("Player 2 wins");
								return;
							}
							// Wait for a move from player 2
//							status.setText("Waiting for player 1 to make move");
							rline = in.readLine();
							Thread.sleep(100);
/*							while (rline == null) {
								status.setText("Waiting for player 1 to make move");
								System.out
										.println("Waiting for player 1 to make move");
								rline = in.readLine();
							}
*/
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						/*
						 * Move is recieved from the second player Get the
						 * button number and update the text of the user
						 */
						JButton updatebutton = cells[Integer.parseInt(rline)];
						updatebutton.setText("O");
//						status.setText("Player 2 move");
					}

					if (checkWinner()) {
						// End of game
						gameOver = true;
						// Display winner message
						result.setText("Player 1 wins");
						return;
					}

				}
			}
		}

		private class ExitButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Close the server connection and exit
				 */
				closeServer();
				System.out.println("Exit");
				System.exit(0);
			}
		}

	}

	/*************************************************************************/

}

public class TocTacToeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameClient game = new GameClient(0);
	}

}
