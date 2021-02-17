/*

Given an undirected graph represented as an adjacency matrix and an integer k, 
write a function to determine whether each vertex in the graph can be colored such that 
no two adjacent vertices share the same color using at most k colors.

*/

public class Day_56_GraphColoring{
	public static void main(String[] args) {
		int k = 3;
		System.out.println(solve(new int[][]{
					{ 0, 1, 0, 0, 0, 0, 0, 0 }, 
					{ 1, 0, 0, 1, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 1, 1, 0, 0, 1 }, 
					{ 0, 1, 1, 0, 1, 0, 0, 0 }, 
					{ 0, 0, 1, 1, 0, 1, 0, 0 }, 
					{ 0, 0, 0, 0, 1, 0, 1, 0 }, 
					{ 0, 0, 0, 0, 0, 1, 0, 0 }, 
					{ 0, 0, 1, 0, 0, 0, 0, 0 }
				}, k
			)
		);
	}

	private static boolean solve(int[][] adjMat, int k){
		return helper(0, 0, adjMat, new boolean[adjMat.length], new int[adjMat.length], k);
	}

	// Time O( (k*n)^n )
	// Space O( n )
	private static boolean helper(int u, int prevColor, int[][] adjMat, boolean[] used, int[] color, int k){
		if(used[u])
			return color[u] != prevColor;

		used[u] = true;

		colorLoop:
		for(int i=1;i<=k;i++){
			color[u] = i;
			for(int j=0;j<adjMat[u].length;j++){
				if(adjMat[u][j] == 0)
					continue;

				if(!helper(j, i, adjMat, used, color, k)){
					continue colorLoop;
				}
			}

			return true;
		}

		return used[u] = false;
	}
}