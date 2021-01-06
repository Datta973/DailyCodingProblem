/*

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall.
Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to 
reach the end coordinate from the start. If there is no possible path, then return null. 
You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]

and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to 
reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

*/

public class Day_23_MinStepsFromSrcToDest{
	public static void main(String[] args) {
		System.out.println(solve(new boolean[][]{
					{false, false, false, false},
					{true , true , false, true },
					{false, false, false, false},
					{false, false, false, false}
				}, new int[]{3, 0}, new int[]{0, 0}
			)
		);

		System.out.println(
			solve(
				new boolean[][]{
					{false, true, false, false, false, false, true, false, false, false },
	                {false, true, false, true, false, false, false, true, false, false },
	                {false, false, false, true, false, false, true, false, true, false },
	                {true, true, true, true, false, true, true, true, true, false },
	                {false, false, false, true, false, false, false, true, false, true },
	                {false, true, false, false, false, false, true, false, true, true },
	                {false, true, true, true, true, true, true, true, true, false },
	                {false, true, false, false, false, false, true, false, false, false },
	                {false, false, true, true, true, true, false, true, true, false }
				}, new int[]{0, 0}, new int[]{3, 4}
			)
		);
	}

	// Time O(M*N)
	// Space O(M*N)
	// Breadth First Search - Shortest path
	private static int solve(boolean[][] grid, int[] start, int[] end){
		java.util.Queue<int[]> q = new java.util.LinkedList<>();
		q.add(start);

		int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int ans = 0;

		while(q.size() > 0){
			int size = q.size();

			for(int i=0;i<size;i++){
				int[] u = q.poll();

				if(u[0] == end[0] && u[1] == end[1]){
					return ans;
				}

				if(visited[u[0]][u[1]]){
					continue;
				}

				visited[u[0]][u[1]] = true;

				for(int[] d : dir){
					int x = u[0] + d[0];
					int y = u[1] + d[1];

					if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length && !grid[x][y])
						q.add(new int[]{x, y});
				}
			}

			ans++;
		}

		return ans;
	}
}