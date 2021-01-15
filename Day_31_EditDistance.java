/*

The edit distance between two strings refers to the minimum number of character 
insertions, deletions, and substitutions required to change one string to the other. 
For example, the edit distance between “kitten” and “sitting” is three: 
substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

*/

public class Day_31_EditDistance{
	public static void main(String[] args) {
		System.out.println(solve("kitten","sitting"));
	}

	// Time O(m * n)
	// Space O(m * n)
	private static int solve(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];

		for(int i=0;i<=m;i++)
			dp[i][0] = i;

		for(int j=0;j<=n;j++)
			dp[0][j] = j; 

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(1+dp[i-1][j-1], Math.min(1+dp[i-1][j], 1+dp[i][j-1]));
				}
			}
		}

		return dp[m][n];
	}
}