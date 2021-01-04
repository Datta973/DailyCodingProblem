/*

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
return the minimum cost which achieves this goal.

*/

public class Day_19_PaintNHousesWithKColors{
	public static void main(String[] args) {
		System.out.println(solve(new int[][]{
					{17,2,17},
					{16,16,5},
					{14,3,19}
				}
			)
		); // outputs 10
	}


	// Time O(N*K*K)
	// Space O(K)
	private static int solve(int[][] nums){
		int N = nums.length;
		if(N == 0)
			return 0;
		
		int K = nums[0].length;
		int[] dp = new int[K];
		int[] mem = new int[K];

		for(int i=N-1;i>=0;i--){
			for(int j=0;j<K;j++){
				dp[j] = Integer.MAX_VALUE;

				for(int k=0;k<K;k++){
					if(j != k){
						dp[j] = Math.min(dp[j], nums[i][j] + mem[k]);
					}
				}
			}

			System.arraycopy(dp, 0, mem, 0, K);
		}

		int ans = Integer.MAX_VALUE;
		for(int x : dp)
			ans = Math.min(ans, x);

		return ans;
	}
}