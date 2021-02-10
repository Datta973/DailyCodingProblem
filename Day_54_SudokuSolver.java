/*

Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. 
The objective is to fill the grid with the constraint that 
every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.

Implement an efficient sudoku solver.

*/

public class Day_54_SudokuSolver{
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};

		solve(board);
		for(char[] row : board)
			System.out.println(java.util.Arrays.toString(row));
	}

	// Time O(9 ^ B) where B is the number of blank cells
	// Space O(9 * 10)  
	private static void solve(char[][] board){
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][] block = new boolean[9][10];

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == '.')
					continue;

				int val = board[i][j] - '0';
				row[i][val] = col[j][val] = block[getBlockIndex(i, j)][val] = true;
			}
		}

		helper(board, 0, 0, row, col, block);
	}

	private static boolean helper(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] block){
		if(i >= board.length)
			return true;

		if(j >= board[0].length)
			return helper(board, i+1, 0, row, col, block);

		if(board[i][j] != '.')
			return helper(board, i, j+1, row, col, block);

		for(int k=1;k<=9;k++){
			if(row[i][k] || col[j][k] || block[getBlockIndex(i, j)][k])
				continue;

			row[i][k] = col[j][k] = block[getBlockIndex(i, j)][k] = true;
			board[i][j] = (char)(k + '0');

			if(helper(board, i, j+1, row, col, block))
				return true;

			board[i][j] = '.';
			row[i][k] = col[j][k] = block[getBlockIndex(i, j)][k] = false;
		}

		return false;
	}

	private static int getBlockIndex(int i, int j){
		return (i/3)*3 + (j/3);
	}
}