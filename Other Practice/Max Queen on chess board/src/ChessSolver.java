/*
 * Board.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Get the maximum number of queens that can be placed in the given chess board
 */

/**
 * CLASS : To hold the Position in the matrix
 */
class Position {
	// Data Declaration
	int row, column;

	private int board_size;

	/*
	 * CLASS CONSTRUCTOR instantiate the position in matrix
	 * 
	 * @param current_row current row in the matrix
	 * 
	 * @param current_column current column in the matrix
	 * 
	 * @param board_size size of the board
	 */
	Position(int current_column, int current_row, int board_size) {
		row = current_row;
		column = current_column;
		this.board_size = board_size;
	}

	/**
	 * METHOD : next_position Provides the next position in the matrix with
	 * respect to the current position
	 */
	void next_position() {
		// Increment column,if column size exceeds board_size
		if (row + 1 >= board_size) {
			row = 0;
			column++;
		} else {
			row++;
		}

	}

	/**
	 * METHOD : previous_position Provides the next position in the matrix with
	 * respect to current position
	 */
	void previous_position() {
		if (row - 1 < 0) {
			column--;
			row = board_size - 1;
		} else {
			row--;
		}
	}
}

/**
 * CLASS : Chess_board This class will hold the chess board and the operations
 * to be performed on the chess board
 */
class Chess_board {
	private boolean[][] board, board_line_mat;
	int queen_count, max_queen, board_size = 0;

	/**
	 * CONSTRUCTOR Instantiate a 2-D for the specified length to replicate the
	 * chess board and define lines on the board
	 * 
	 * @param size
	 *            size/length of the chess board
	 */
	Chess_board(int size) {
		board_size = size;
		board = new boolean[size][size];
		board_line_mat = new boolean[(2 * size) + 1][(2 * size) + 1];
	}

	/**
	 * 
	 * METHOD : add_queen This method will check if a queen can be placed at the
	 * position such that the lines specified on the board are not crossed over
	 * and all queen are safe If queen is safe for placement then the queen is
	 * placed else the next position is checked for the placement of the queen
	 * 
	 * @param i
	 *            column where the queen is to be placed
	 * @param j
	 *            row where the queen is to be placed
	 */
	void add_queen(int i, int j) {
		// While the parser remains in bounds of the chess board size
		while (i <= board_size - 1) {
			{
				// Check if the queen is free of any threat at the specified
				// position

				if (!(check_if_queen_is_present(i, j))) {
					add_queen_pos(i, j); // queen can be placed here
					queen_count++; // Increment the queen count

					Position pos = new Position(i, j, board_size);
					pos.next_position();
					i = pos.column;
					j = pos.row;
					if(queen_count==12)
					{
						queen_count =12;
					}
					
					add_queen(i, j); // Add the next queen
					if (queen_count > max_queen) // Get the count of queens placed
						max_queen = queen_count;

					// Get previous position of i,j
					// in order to remove the queen from the previous
					// location
					// as a part of the back track queen
					pos.previous_position();
					remove_queen_pos(pos.column, pos.row);
					queen_count--;

				} else {
					// Get the next position
					Position pos = new Position(i, j, board_size);
					pos.next_position();
					i = pos.column;
					j = pos.row;
				}
			}
		}
	}

	/**
	 * METHOD : check_if_queen_is_present
	 * 
	 * this method will check if a queen can be placed at position by comparing
	 * the boxes around to see if there is a queen that threatens the position [
	 * ] [ ] [ ] [ ] [X] [ ] [ ] [ ] [ ]
	 * 
	 * @param current_col
	 *            column to be checked for
	 * @param current_row
	 *            row to be checked for
	 */
	boolean check_if_queen_is_present(int col, int row) {
		if (check_queen_threat_top(col, row)) // Check Top edge
		{
			return true;
		} else {
			if (check_queen_threat_right(col, row)) // Check right edge
			{
				return true;
			} else {
				if (check_queen_threat_bottom(col, row)) // Check Bottom edge
				{
					return true;
				} else {
					if (check_queen_threat_left(col, row)) // Check left edge
					{
						return true;
					} else {
						if (check_queen_threat_diag_top_right(col, row))// Check
																		// top
																		// right
						{
							return true;
						} else {
							if (check_queen_threat_diag_right_bottom(col, row))// Check
																				// right
																				// bottom
							{
								return true;
							} else {
								if (check_queen_threat_diag_bottom_left(col,
										row))// Check bottom left
								{
									return true;
								} else {
									if (check_queen_threat_diag_left_top(col,
											row))// Check left_top
									{
										return true;
									} else {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	// ----------------------------------------------------------//
	/**
	 * METHOD : check_queen_threat_top Check if the queen has not threat from
	 * top or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_top(int col, int row) {

		boolean threat = false, wall_block = false;
		// Check the top edge of the chess square
		for (int j = row; j < board_size && wall_block == false; j++) {
			// /Check if queen is present at this position
			if (board[col][j] == true) {
				threat = true;
				return threat;
			}
			wall_block = top_edge(col, j);
		}
		return threat;
	}

	/**
	 * check if there is a line on the top edge of the chess square
	 * 
	 * @param col
	 *            column
	 * @param row
	 *            row
	 * @return boolean line present or not
	 */
	boolean top_edge(int col, int row) {
		if (board_line_mat[(2 * col) + 1][((2 * row) + 1) + 1] == true) {
			return true; // Line present
		} else {
			return false; // Line not present
		}
	}

	/**
	 * METHOD : check_queen_threat_bottom Check if the queen has not threat from
	 * bootm or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_bottom(int col, int row) {
		boolean threat = false, wall_block = false;
		// Check the top edge of the chess square
		for (int j = row; j >= 0 && wall_block == false; j--) {
			// /Check if queen is present at this position
			if (board[col][j] == true) {
				threat = true;
				return threat;
			}
			wall_block = bottom_edge(col, j);
		}
		return threat;
	}

	/**
	 * check if there is a line on the bottom edge of the chess square
	 * 
	 * @param col
	 *            column
	 * @param row
	 *            row
	 * @return boolean line present or not
	 */
	boolean bottom_edge(int col, int row) {
		if (board_line_mat[(2 * col) + 1][((2 * row) + 1) - 1] == true) {
			return true; // Line present
		} else {
			return false; // Line not present
		}
	}

	/**
	 * METHOD : check_queen_threat_left Check if the queen has not threat from
	 * left or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_left(int col, int row) {

		boolean threat = false, wall_block = false;
		// Check the top edge of the chess square
		for (int i = col; i >= 0 && wall_block == false; i--) {
			// /Check if queen is present at this position
			if (board[i][row] == true) {
				threat = true;
				return threat;
			}
			wall_block = left_edge(i, row);
		}
		return threat;
	}

	/**
	 * check if there is a line on the left edge of the chess square
	 * 
	 * @param col
	 *            column
	 * @param row
	 *            row
	 * @return boolean line present or not
	 */
	boolean left_edge(int col, int row) {
		if (board_line_mat[((2 * col) + 1) - 1][((2 * row) + 1)] == true) {
			return true; // Line present
		} else {
			return false; // Line not present
		}
	}

	/**
	 * METHOD : check_queen_threat_right Check if the queen has not threat from
	 * right or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_right(int col, int row) {

		boolean threat = false, wall_block = false;
		// Check the top edge of the chess square
		for (int i = col; i < board_size && wall_block == false; i++) {
			// /Check if queen is present at this position
			if (board[i][row] == true) {
				threat = true;
				return threat;
			}
			wall_block = right_edge(i, row);
		}
		return threat;
	}

	/**
	 * check if there is a line on the right edge of the chess square
	 * 
	 * @param col
	 *            column
	 * @param row
	 *            row
	 * @return boolean line present or not
	 */
	boolean right_edge(int col, int row) {
		if (board_line_mat[((2 * col) + 1) + 1][((2 * row) + 1)] == true) {
			return true; // Line present
		} else {
			return false; // Line not present
		}
	}

	/**
	 * METHOD : check_queen_threat_diag_top_right Check if the queen has not
	 * threat from top or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_diag_top_right(int col, int row) {

		boolean threat = false, wall_block = false;

		// Check the top edge of the chess square
		for (int i = col, j = row; (i < board_size && j < board_size)
				&& wall_block == false; i++, j++) {
			// /Check if queen is present at this position
			if (board[i][j] == true) {
				threat = true;
				return threat;
			}
			if (i < board_size - 1 && j < board_size - 1) {
				wall_block = (top_edge(i, j) == true)
						&& (bottom_edge(i + 1, j + 1) == true);
				if (wall_block == false)
					wall_block = (right_edge(i, j) == true)
							&& (left_edge(i + 1, j + 1) == true);
				if (wall_block == false) {
					wall_block = (top_edge(i, j) && right_edge(i, j));
					if (wall_block == false) {
						wall_block = (bottom_edge(i + 1, j + 1) && left_edge(
								i + 1, j + 1));
					}
				}
			}
		}
		return threat;
	}

	/**
	 * METHOD : check_queen_threat_diag_right_bottom Check if the queen has not
	 * threat from top or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_diag_right_bottom(int col, int row) {
		boolean threat = false, wall_block = false;
		;

		// Check the top edge of the chess square
		for (int i = col, j = row; (i < board_size  && j >= 0)
				&& wall_block == false; i++, j--) {
			// /Check if queen is present at this position
			if (board[i][j] == true) {
				threat = true;
				return threat;
			}
			if (i < board_size - 1 && j > 0) {
				if ((bottom_edge(i, j) == true)
						&& (top_edge(i + 1, j - 1) == true))
					wall_block = true;
				if (wall_block == false) {
					if ((right_edge(i, j) == true)
							&& (left_edge(i + 1, j - 1) == true))
						wall_block = true;
					if (wall_block == false) {
						wall_block = (bottom_edge(i, j) && right_edge(i, j));
						if (wall_block == false) {
							wall_block = (top_edge(i + 1, j - 1) && left_edge(
									i + 1, j - 1));
						}
					}
				}

			}
			
		}
		return threat;
	}

	/**
	 * METHOD : check_queen_threat_diag_bottom_left Check if the queen has not
	 * threat from top or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_diag_bottom_left(int col, int row) {
		boolean threat = false, wall_block = false;
		;

		// Check the top edge of the chess square
		for (int i = col, j = row; (i >= 0 && j >= 0) && wall_block == false; i--, j--) {
			// /Check if queen is present at this position
			if (board[i][j] == true) {
				threat = true;
				return threat;
			}
			if (i > 0 && j > 0) {
				wall_block = (bottom_edge(i, j) == true)
						&& (top_edge(i - 1, j - 1) == true);
				if (wall_block == false) {
					wall_block = (left_edge(i, j) == true)
							&& (right_edge(i - 1, j - 1) == true);
					if (wall_block == false) {
						wall_block = (bottom_edge(i, j) && left_edge(i, j));
						if (wall_block == false) {
							wall_block = (top_edge(i - 1, j - 1) && right_edge(
									i - 1, j - 1));
						}
					}
				}
			}
			
		}
		return threat;
	}

	/**
	 * METHOD : check_queen_threat_diag_left_top Check if the queen has not
	 * threat from top or not
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 * @return boolean Threat or not
	 */

	boolean check_queen_threat_diag_left_top(int col, int row) {
		boolean threat = false, wall_block = false;
		// Check the top edge of the chess square
		for (int i = col, j = row; (i >= 0 && j < board_size)
				&& wall_block == false; i--, j++) {
			// /Check if queen is present at this position
			if (board[i][j] == true) {
				threat = true;
				return threat;
			}
			if ((i > 0 && j < board_size - 1)) {
				wall_block = (top_edge(i, j) == true)
						&& (bottom_edge(i - 1, j + 1) == true);
				if (wall_block == false) {
					wall_block = (left_edge(i, j) == true)
							&& (right_edge(i - 1, j + 1) == true);
					if (wall_block == false) {

						wall_block = (top_edge(i, j) && left_edge(i, j));
						if (wall_block == false) {
							wall_block = (bottom_edge(i - 1, j + 1) && right_edge(
									i - 1, j + 1));
						}
					}
				}
			}
			
		}
		return threat;
	}

	// --------------------------------------------------------------//

	/**
	 * METHOD : add_queen_pos Adds queen to the specified position on the chess
	 * board
	 * 
	 * @param i
	 *            row where queen is to placed
	 * @param j
	 *            column where the queen is to placed
	 */
	void add_queen_pos(int i, int j) {
		board[i][j] = true;
	}

	/**
	 * METHOD : rmoeive_queen_pos Removes queen from the specified position on
	 * chess board
	 * 
	 * @param i
	 *            row where queen is to be removed
	 * @param j
	 *            column where the queen is to be removed
	 */
	void remove_queen_pos(int i, int j) {
		board[i][j] = false;
	}

	/**
	 * METHOD : display_max_queens Print Max queens till now
	 */
	void display_max_queens() {
		System.out.println(" Max queens for a chess board of size : "
				+ board_size + " is : " + this.max_queen);
	}

	/**
	 * METHOD : To place a line
	 */
	void add_line(int col, int row) {
		board_line_mat[col][row] = true;

	}
}

/**
 * This class would assist us simulating a chess board & then determine the max
 * number of queens that can be placed on it
 * 
 */
public class ChessSolver {

	/**
	 * //public static void main //Starting point of the class
	 * 
	 * @param args
	 *            command line arguments
	 */

	public static void main(String[] args) {

		// Instantiate the Chess Board class
		Chess_board board = new Chess_board(8);

		// Add lines on the chess board
		board.add_line(0,1);
		board.add_line(12,1);
		board.add_line(1, 2);
		board.add_line(12,3 );
		board.add_line(2,1);
		board.add_line(5,4 );
		board.add_line(7,4 );
		board.add_line(9,4 );
		board.add_line(4,5 );
		board.add_line(11,6 );
		board.add_line(13, 6);
		board.add_line(15,6 );
		board.add_line(4, 7);
		board.add_line(10,7 );
		board.add_line(7,10 );
		board.add_line(9,10 );
		board.add_line(10,9 );
		board.add_line(11,10 );
		board.add_line(1,12 );
		board.add_line(3,12 );
		board.add_line(5,12 );
		board.add_line(8,11 );
		board.add_line(8,13 );
		board.add_line(12,13 );
		board.add_line(12,15 );

		
		
		// Compute the max number of queens that can be placed on the chess
		// board with the borders
		// be placed for the given chess board considering the lines on board
		board.add_queen(0, 0);
		// Display the max queens that can be placed for this configuration
		board.display_max_queens();
	}
}