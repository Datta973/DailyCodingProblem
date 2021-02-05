/*

Given a array of numbers representing the stock prices of a company in chronological order, 
write a function that calculates the maximum profit you could have made from buying and selling 
that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, 
since you could buy the stock at 5 dollars and sell it at 10 dollars.

*/

public class Day_47_MaximumProfitWithStocks{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{9, 11, 8, 5, 7, 10}));
	}

	// Time O(n)
	// Space O(1)
	private static int solve(int[] nums){
		if(nums.length == 0)
			return 0;

		int ans = 0;
		int min = nums[0];

		for(int x : nums){
			if(x > min)
				ans = Math.max(ans, x-min);
			else
				min = x;
		}

		return ans;
	}
}