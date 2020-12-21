/*

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

*/
public class Day_7_DecodeWays{
    public static void main(String[] args){
        System.out.println(solve("111")); // outputs 3
    }    
    
    private static int solve(String s){
        return helper(s, 0, new Integer[s.length()+1]);
    }
    
    // Time O(n) with Memoization
    // Space O(n)
    private static int helper(String s, int i, Integer[] dp){
        int n = s.length();
        
        // recursion break points
        if(dp[i] != null)
            return dp[i];
        if(i >= n)
            return 1;
        if(s.charAt(i) == '0')
            return 0;
        if(i == n-1)
            return 1;
        
        // memoize the result
        // go to i+1 and i+2
        // because of memoization time reduces from O(2^n) to O(n)
        return dp[i] = helper(s,i+1,dp) + 
                       ((s.charAt(i) > '2' || (s.charAt(i) == '2' && s.charAt(i+1) > '6')) ? 0 : 1) *
                       helper(s,i+2,dp);
    }
}