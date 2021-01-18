/*

Suppose you are given a table of currency exchange rates, represented as a 2D array.
Determine whether there is a possible arbitrage: that is, 
whether there is some sequence of trades you can make, starting with some amount A of any currency, 
so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.

*/
public class Day_32_CurrencyExchange{
	public static void main(String[] args) {
		System.out.println(solve(
				new double[][]{
					{1.0, 0.83},
					{1/0.83, 1.0}
				}
			)
		);

		System.out.println(solve(
				new double[][]{
					{1.0,	0.83,	103.74,	7.53},
					{1.21,	1.0,	125.31,	9.10},
					{0.0096,0.0080,	1.0,	0.073},
					{0.13,	0.11,	13.77,	1.0}
				}
			)
		);
	}

	// Time O(n^3)
	// Space O(n^2)
	private static boolean solve(double[][] nums){
		int n = nums.length;
		double[][] dp = new double[n][n];

		for(int i=0;i<n;i++)
			System.arraycopy(nums[i], 0, dp[i], 0, n);

		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					dp[i][j] = Math.max(dp[i][j], dp[i][k]*dp[k][j]);
				}
			}
		}

		for(int i=0;i<n;i++){
			if(dp[i][i] > nums[i][i])
				return true;
		}

		return false;
	}
}