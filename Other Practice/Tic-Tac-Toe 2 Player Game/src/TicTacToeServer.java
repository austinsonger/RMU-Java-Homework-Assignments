/**
 * TicTacToeServer.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Server PLayer 1 for Tic Tac toe
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
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Game Server to Host PLAYER 1
 * 
 * @author sdudhani
 * 
 */
class GameServer {

	ServerSocket GameServerSocket;
	int port = 4242;
	Socket GameServer;
	PrintWriter out;
	BufferedReader in;
	boolean servermove = true;
	int playerno = 1;
	int turn = 1;
	boolean gameOver;

	GameServer(int port) {
		/**
		 * Initialize the Server
		 */
		initServer();
		/**
		 * Connect to Player 2
		 */
		if (connect_players(port)) {
			/*
			 * Create the UI for the Tic Tac Toe THe actionlistners of the
			 * Buttons would write on out
			 */
			GUI gui = new GUI();
		}
	}

	/**
	 * Connect to player
	 * 
	 * @param port
	 * @return
	 */
	boolean connect_players(int port) {
		// Initiate the server connection
		System.out.println("Wating for the 2nd player to connect");

		try {
			GameServer = GameServerSocket.accept();
			/*
			 * out => output stream 
			 * in <=input stream
			 */
			out = new PrintWriter(GameServer.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					GameServer.getInputStream()));
			return true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Instantiate the server using port
	 */
	void initServer() {
		try {
			GameServerSocket = new ServerSocket(port);
			System.out.println("Listening on port: "
					+ GameServerSocket.getLocalPort());
			System.out.println("First Player Connected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Make a server via port : " + port);
			e.printStackTrace();
		}
	}

	/*
	 * Close the server
	 * & buffered reader
	 */
	void closeServer() {
		try {
			GameServerSocket.close();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to close server");
			e.printStackTrace();
		}
	}

	/**
	 * Class to define the SWING framework for TIC TAC TOE
	 */
	/**************************************************************************/
	class GUI extends JFrame {
		private static final String TITLE = "Tic Tac Toe PLAYER 1";
		private static final int WIDTH = 450;
		private static final int HEIGHT = 600;
		private Container content;
		private JLabel result;
		JLabel status;
		private JButton[] cells;
		private JButton exitButton;
		private CellButtonHandler[] cellHandlers;
		private ExitButtonHandler exitHandler;
		/*
		 * PLAYER 1 is defualted to O/noughts
		 */
		private boolean noughts = true; // Set noughts to player 1
		/*
		 * Flag to determine if the game is over
		 */
		private boolean gameOver;

		/*
		 * Constructor
		 */
		public GUI() {
			//Define the configuration of SWING frame
			setTitle(TITLE);
			setSize(WIDTH, HEIGHT);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			// Get content pane
			content = getContentPane();
			content.setBackground(Color.blue.darker());

			// Set layout
			content.setLayout(new GridLayout(4, 3));

			// Create cells and handlers
			cells = new JButton[9];
			cellHandlers = new CellButtonHandler[9];
			for (int i = 0; i < 9; i++) {
				char ch = (char) ('0' + i);
				cells[i] = new JButton("" + ch);
				cellHandlers[i] = new CellButtonHandler();
				cells[i].addActionListener(cellHandlers[i]);
			}

			/*
			 * Creat the EXIT and status messgae lables
			 */
			exitButton = new JButton("EXIT");
			exitHandler = new ExitButtonHandler();
			exitButton.addActionListener(exitHandler);

			status = new JLabel("Player 1", SwingConstants.CENTER);
			status.setForeground(Color.white);

			// Create result label
			result = new JLabel("Noughts", SwingConstants.CENTER);
			result.setForeground(Color.white);

			// Add elements to the grid content pane
			for (int i = 0; i < 9; i++) {
				content.add(cells[i]);
			}
			content.add(status);
			content.add(result);
			content.add(exitButton);
			init();
		}
/*
 * Initialize the SWING panel
 */
		public void init() {
			// Initialize booleans
			noughts = true;
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
		 * Compare the winning conditions and check if the game is complete
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
					// Ignore the already moved spots
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
							pressed.setText("O");
							if (checkWinner()) {
								// End of game
								gameOver = true;
								// Display winner message
								result.setText("Player 1 wins");
								return;
							}
							out.println(text);
							// Wait for a move from player 2
//							status.setText("Waiting for player 2 to make move");
							rline = in.readLine();
/*							while (rline == null) {
								turn = 2;
								status.setText("Waiting for player 2 to make move");
								System.out
										.println("Waiting for player 2 to make move");
								rline = in.readLine();
							}
*/							Thread.sleep(100);

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
						turn = 1;
						JButton updatebutton = cells[Integer.parseInt(rline)];
						updatebutton.setText("X");
//						status.setText("Player 1 move");

						// text
						pressed.setText("O");
					} else {
						// For player 2
						try {
							/*
							 * Send the number of the button clicked and wait
							 * for a move from other player to proceed ahead
							 */
							out.println(text);
							pressed.setText("X");
							// Check winner
							if (checkWinner()) {
								// End of game
								gameOver = true;
								// Display winner message
								if (noughts) {
									result.setText("Player 1 wins!!");
								} else {
									result.setText("Player 2 wins");
								}
								return;
							}
							// Wait for a move from player 2
//							status.setText("Waiting for player 1 to make move");
							rline = in.readLine();
							while (rline == null) {
//								status.setText("Waiting for player 1 to make move");
								System.out
										.println("Waiting for player 1 to make move");
								Thread.sleep(1000);
								rline = in.readLine();
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
						JButton updatebutton = cells[Integer.parseInt(rline)];
						updatebutton.setText("O");
//						status.setText("Player 2 move");
					}

					// Check winner
					if (checkWinner()) {
						// End of game
						gameOver = true;
						// Display winner message
						result.setText("Player 2 wins");
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
				System.exit(0);
			}
		}

	}

	/*************************************************************************/
}

/**
 * 
 * @author sdudhani
 * 
 */
public class TicTacToeServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameServer player1 = new GameServer(1);
	}

}
