/*

You are given an array of non-negative integers that represents a two-dimensional elevation map 
where each element is unit-width wall and the integer is the height. 
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, 
and 3 in the fourth index (we cannot hold 5 since it would run off to the left), 
so we can trap 8 units of water.

*/

public class Day_30_TrappingRainWater{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{2, 1, 2}));
		System.out.println(solve(new int[]{3, 0, 1, 3, 0, 5}));
	}

	// Time O(n)
	// Space O(1)
	private static int solve(int[] nums){
		int n = nums.length;

		if(n < 2)
			return 0;

		int ans = 0;
		int left = 0, right = n-1;
		int min = Math.min(nums[left], nums[right]);
		
		while(left < right){
			if(nums[left] <= min){
				ans += min - nums[left++];
				continue;
			}

			if(nums[right] <= min){
				ans += min - nums[right--];
				continue;
			}

			if(nums[left] > min){
				if(nums[left] < nums[right]){
					min = nums[left++];
				}else{
					min = nums[right--];
				}
			}

			if(nums[right] > min){
				if(nums[left] < nums[right]){
					min = nums[left++];
				}else{
					min = nums[right--];
				}
			}
		}

		return ans;
	}
}