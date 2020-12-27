public class Day_12_NumWaysToClimb{
	public static void main(String[] args) {
		System.out.println(solve(4, new int[]{1, 2})); // outputs 5
		System.out.println(solve(6, new int[]{1, 3, 5})); // outputs 8
	}

	// Time O(N * M) where M = length of steps
	// Space O(N)
	// dynamic programming - bottom up
	private static int solve(int N, int[] steps){

		if(N == 0 || steps.length == 0){
			return 0;
		}

		int[] dp = new int[N+1];
		dp[0] = 1;

		for(int i=1;i<=N;i++){
			for(int j=0;j<steps.length;j++){
				if(i - steps[j] >= 0){
					dp[i] += dp[i - steps[j]];
				}
			}
		}

		return dp[N];
	}
}