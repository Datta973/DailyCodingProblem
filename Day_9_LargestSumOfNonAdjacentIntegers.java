/*

Problem statement : 

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?

*/
public class Day_9_LargestSumOfNonAdjacentIntegers{
    public static void main(String[] args){
        System.out.println(solve(new int[]{2, 4, 6, 2, 5})); // outputs 13
        System.out.println(solve(new int[]{5, 1, 1, 5})); // outputs 10
        System.out.println(solve(new int[]{5, 20, 15, -2, 18})); // outputs 38
        System.out.println(solve(new int[]{4, 1, 6, 3, 2})); // outputs 12
    }
    
    // Time O(n), Space O(1)
    private static int solve(int[] nums){
        int ans = 0, near = 0, far = 0;
        
        for(int x : nums){
            int t = near;
            
            if(x > 0)
                near = x + far;
            
            far = Math.max(t, far);
        }
        
        return Math.max(near, far);
    }
}