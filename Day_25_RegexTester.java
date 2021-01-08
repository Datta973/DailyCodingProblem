/*

Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and 
returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray",
your function should return true. 
The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. 
The same regular expression on the string "chats" should return false.

*/
public class Day_25_RegexTester{
	public static void main(String[] args) {
		System.out.println(solve("ra.", "ray"));
		System.out.println(solve("raymond", "ray"));
		System.out.println(solve(".*at", "chat"));
		System.out.println(solve(".*at", "chats"));
	}

	private static boolean solve(String regex, String s){
		return helper(regex.toCharArray(), 0, s.toCharArray(), 0, new Boolean[regex.length()+1][s.length()+1]);
	}


	// Time O(M * N)
	// Space O(M * N)
	private static boolean helper(char[] s1, int i,char[] s2, int j, Boolean[][] dp){
		if(i >= s1.length)
			return j >= s2.length;

		if(dp[i][j] != null)
			return dp[i][j];

		boolean asterisk = i+1 < s1.length && s1[i+1] == '*';

		if(j >= s2.length)
			return dp[i][j] = asterisk && helper(s1, i+2, s2, j, dp);

		if(s1[i] == s2[j] || s1[i] == '.')
			return dp[i][j] = (asterisk && (helper(s1, i+2, s2, j, dp) || helper(s1, i, s2, j+1, dp))) ||
								helper(s1, i+1, s2, j+1, dp);  

		return dp[i][j] = asterisk && helper(s1, i+2, s2, j, dp);
	}
}