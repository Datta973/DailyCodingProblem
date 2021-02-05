/*

Given a string, find the longest palindromic contiguous substring. 
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". 
The longest palindromic substring of "bananas" is "anana".

*/

public class Day_46_LongestPalindromicSubstring{
	public static void main(String[] args) {
		System.out.println(solve("aabcdcb"));
		System.out.println(solve("bananas"));
		System.out.println(solve("racecar"));
	}

	// Time O(n * n)
	// Space O(n * n)
	private static String solve(String s){
		if(s == null || s.length() == 0)
			return null;
		
		int[] indices = helper(s.toCharArray());
		return s.substring(indices[0], indices[1]+1);
	}

	private static int[] helper(char[] s){
		int n = s.length;
		boolean[][] dp = new boolean[n+1][n+1];

		for(int i=0;i<n;i++)
			dp[i][i] = true;
		
		for(int i=0;i<n-1;i++)
			dp[i][i+1] = (s[i] == s[i+1]);

		int start = 0, end = 0;

		for(int k=2;k<n;k++){
			for(int i=0, j=i+k;j<n;i++,j++){
				dp[i][j] = (s[i] == s[j] && dp[i+1][j-1]);

				if(dp[i][j] && (j-i > end - start)){
					start = i;
					end = j;
				}
			}
		}	

		return new int[]{start, end};
	}

}