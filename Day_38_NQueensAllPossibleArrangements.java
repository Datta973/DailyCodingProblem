/*

You have an N by N board. Write a function that, given N, returns the number of possible arrangements 
of the board where N queens can be placed on the board without threatening each other, 
i.e. no two queens share the same row, column, or diagonal.

*/

public class Day_38_NQueensAllPossibleArrangements{
	public static void main(String[] args) {
		int N = 8;
		System.out.println(solve(N));
	}

	private static int solve(int N){
		int[] used = new int[N];
		java.util.Arrays.fill(used, -1);
		return helper(used, 0);
	}

	// Time O(n!)
	// Space O(n)
	private static int helper(int[] used, int row){
		if(row >= used.length)
			return 1;

		int ans = 0;

		for(int j=0;j<used.length;j++){
			if(used[j] != -1 || isDangerous(used, row, j))
				continue;

			used[j] = row;

			ans += helper(used, row+1);

			used[j] = -1;
		}

		return ans;
	}

	private static boolean isDangerous(int[] used, int row, int col){
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(used[j] == i)
				return true;
		}

		for(int i=row,j=col;i>=0 && j<used.length;i--,j++){
			if(used[j] == i)
				return true;
		}

		return false;
	}
}