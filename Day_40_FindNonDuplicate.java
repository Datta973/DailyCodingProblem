/*

Given an array of integers where every integer occurs three times except for one integer, 
which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

*/

public class Day_40_FindNonDuplicate{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{6, 1, 3, 3, 3, 6, 6}));
		System.out.println(solve(new int[]{13, 19, 13, 13}));
		System.out.println(solve(new int[]{1,2,3,4,5,1,2,4,5,1,2,4,5}));
	}

	// Time O(32*n) = O(n)
	// Space O(1)
	private static int solve(int[] nums){
		int ans = 0;

		for(int i=0;i<32;i++){
			int count = 0;
			for(int x : nums){
				int b = ((x >> i) & 1);
				if(b == 1)
					count = ++count % 3;
			}

			if(count != 0)
				ans |= 1 << i;
		} 

		return ans;
	}
}