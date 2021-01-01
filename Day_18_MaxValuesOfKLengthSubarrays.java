/*

Problem statement : 

Given an array of integers and a number k, where 1 <= k <= length of the array, 
compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)

Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. 
You can simply print them out as you compute them.

*/

import java.util.ArrayDeque;

public class Day_18_MaxValuesOfKLengthSubarrays{
	public static void main(String[] args) {
		System.out.println(java.util.Arrays.toString(solve(new int[]{10, 5, 2, 7, 8, 7}, 3)));
	}

	// Time O(n)
	// Space O(k) 	
	private static int[] solve(int[] nums, int k){
		int n = nums.length;
		
		if (n == 0 || k == 0) {
			return new int[0];
		}
		
		int[] ans = new int[n-k+1];
		
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		
		for(int i=0;i<n;i++){
		    
			if(dq.size() > 0 && dq.peek() <= i-k){
				dq.poll();
			}

			while(dq.size() > 0 && nums[dq.peekLast()] < nums[i]){
				dq.pollLast();
			}

			dq.add(i);

			if(i >= k - 1){
				ans[i-k+1] = nums[dq.peek()];
			}
		}
		
		return ans;
	}
}
