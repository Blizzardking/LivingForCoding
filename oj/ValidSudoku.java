package puzzle;

public class ValidSudoku {
	public static void main(String[] args) {
		char[][] board = {{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'},
		};
		System.out.println(isValidSudoku(board));
	}
	
	static boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && !isValid(board, i, j)) {
					return false;
				}
			}
		return true;

	}

	static boolean isValid(char[][] board, int row, int column) {
		for (int i = 0; i < board.length; i++) {
			if (i != row && board[row][column] == board[i][column])
				return false;
		}
		for (int j = 0; j < board[0].length; j++) {
			if (j != column && board[row][column] == board[row][j])
				return false;
		}
		for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++)
			for (int j = 3 * (column / 3); j < 3 * (column / 3) + 3; j++)
				if (i != row && j != column
						&& board[i][j] == board[row][column])
					return false;
		return true;
	}
	
}
