/*

Conway's Game of Life takes place on an infinite two-dimensional board of square cells. 
Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with 
a starting list of live cell coordinates and the number of steps it should run for. 
Once initialized, it should print out the board state at each step. 
Since it's an infinite board, print out only the relevant coordinates, i.e. 
from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).

*/

public class Day_39_GameOfLife{
	public static void main(String[] args) {
		solve(new char[][]{
			{'.','*','.'}, 
			{'.','.','*'}, 
			{'*','*','*'}, 
			{'.','.','.'}
		}, 5);		
	}

	// Time O(m*n*s)
	// Space O(m*n)
	// - where m is rows, n is columns and s is steps
	private static void solve(char[][] board, int steps){
		char[][] state = new char[board.length][board[0].length];
		print(board, 0);

		for(int i=0;i<steps;i++){
			nextStep(board, state);
			print(state, i+1);

			char[][] t = board;
			board = state;
			state = t;
		}
	}

	private static void print(char[][] state, int i){
		System.out.println("Step #"+i+":");
		for(char[] row : state)
			System.out.println(java.util.Arrays.toString(row));
		System.out.println();
	}

	private static void nextStep(char[][] board, char[][] ans){
		int m = board.length;
		int n = board[0].length;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int score = 0;
				boolean t = i-1 >= 0,r = j+1 < n,d = i+1 < m,l = j-1 >= 0;

				score += l ? toBinary(board[i][j-1]) : 0;
				score += r ? toBinary(board[i][j+1]) : 0;

				if(t){
				    score += toBinary(board[i-1][j]);
				    score += l ? toBinary(board[i-1][j-1]) : 0;
				    score += r ? toBinary(board[i-1][j+1]) : 0;
				}

				if(d){
				    score += toBinary(board[i+1][j]);
				    score += l ? toBinary(board[i+1][j-1]) : 0;
				    score += r ? toBinary(board[i+1][j+1]) : 0;
				}

				ans[i][j] = score < 2 ? '.' : (score == 2 ? board[i][j] : (score == 3 ? '*' : '.' ));
			}
		}
	}

	private static int toBinary(char ch){
		return ch == '*' ? 1 : 0;
	}
}
