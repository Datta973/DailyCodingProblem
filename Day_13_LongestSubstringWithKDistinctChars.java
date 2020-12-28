/*

Problem statement : 

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

*/

public class Day_13_LongestSubstringWithKDistinctChars{
	public static void main(String[] args) {
		System.out.println(solve("abcba", 2)); // outputs bcb
		System.out.println(solve("aabbcdaa", 2)); // outputs aabb
		System.out.println(solve("abcbdd", 3)); // outputs bcbdd
	}

	// Time O(n) - each character is visited atmost 2 times. So O(2*n) = O(n)
	// Space O(1)
	// Sliding window technique
	private static String solve(String s, int k){
		String ans = "";
		int n = s.length();

		if(n == 0 || k <= 0){
			return ans;
		}

		
		int count=0, index=0, len=0;
		int[] freq = new int[26];

		for(int i=0,j=0;j<n;j++){
			if(freq[s.charAt(j)-'a']++ == 0){
				count++;
			}

			while(count > k){
				if(--freq[s.charAt(i++)-'a'] == 0){
					count--;
				}
			}

			if(j-i+1 > len){
				index = i;
				len = j-i+1;
			}
		}

		return s.substring(index, index+len);
	}
}