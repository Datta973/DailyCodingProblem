/*

Given a list of integers S and a target number k, 
write a function that returns a subset of S that adds up to k. 
If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

*/

import java.util.List;

public class Day_42_FindSubsetThatAddsUptoK{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{12, 1, 61, 5, 9, 2}, 24));
	}

	private static List<Integer> solve(int[] nums, int k){
		List<Integer> ans = new java.util.ArrayList<>();
		return helper(nums, 0, k, new Boolean[nums.length+1][k+1], ans) ? ans : null;
	}

	// Time O(n * k)
	// Space O(n * k)
	private static boolean helper(int[] nums, int i, int k, Boolean[][] dp, List<Integer> ans){
		if(k <= 0 || i >= nums.length)
			return k == 0;

		if(dp[i][k] != null)
			return dp[i][k];

		ans.add(nums[i]);
		if(helper(nums, i+1, k-nums[i], dp, ans))
			return dp[i][k] = true;
		ans.remove(ans.size()-1);

		return dp[i][k] = helper(nums, i+1, k, dp, ans);
	} 
}