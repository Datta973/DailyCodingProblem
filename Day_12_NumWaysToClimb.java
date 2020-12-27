/*

Problem statement : 

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

*/

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