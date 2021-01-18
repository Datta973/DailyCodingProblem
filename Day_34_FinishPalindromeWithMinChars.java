/*

Given a string, find the palindrome that can be made by inserting the fewest number of characters 
as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, 
return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", 
since we can add three letters to it (which is the smallest amount to make a palindrome). 
There are seven other palindromes that can be made from "race" by adding three letters, 
but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".
*/

public class Day_34_FinishPalindromeWithMinChars{
	public static void main(String[] args) {
		System.out.println(solve("race"));
		System.out.println(solve("google"));
	}

	private static String solve(String s){
		return helper(s.toCharArray(), 0, s.length()-1, new String[s.length()+1][s.length()+1]);
	}


	// Time O(n*n)
	// Space O(n*n)
	private static String helper(char[] s, int i, int j, String[][] dp){
        if(i > j)
            return "";
        if(i == j)
        	return s[i]+"";

        if(dp[i][j] != null)
        	return dp[i][j];

        if(s[i] == s[j])
            return dp[i][j] = s[i]+helper(s, i+1, j-1,dp)+s[j];
        
        String left = s[i]+ helper(s, i+1, j,dp) +s[i], right = s[j]+ helper(s, i, j-1,dp) +s[j];

        if(left.length() == right.length())
        	return dp[i][j] = s[i] <= s[j] ? left : right;

        return dp[i][j] = left.length() < right.length() ? left : right;
    }
}