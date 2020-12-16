/*

Problem Statement : 
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import java.util.*;
public class Day_2_ProductOfAllExceptSelf{
    public static void main(String[] args){
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 4, 5})));
    }
    
    // Time : O(n), Space : O(n)
    // Assumption : Total product fits in Integer size. (INT_MIN <= Total Product <= INT_MAX)
    // Also clears Follow-up. No division is used.
    private static int[] solve(int[] nums){
        int n = nums.length;
        
        int[] ans = new int[n];
        int[] leftPrefix = new int[n+1]; // will store product prefixes from left to right 
        int[] rightPrefix = new int[n+1]; // will store product prefixes from right to left
        
        leftPrefix[0] = rightPrefix[n] = 1;
        
        for(int i=0;i<n;i++){
            // current product = previous * current num
            leftPrefix[i+1] = leftPrefix[i] * nums[i]; 
            rightPrefix[n-i-1] = rightPrefix[n-i] * nums[n-i-1];
        }
        
        // now all we have to do is : left[i-1] * right[i+1]
        for(int i=0;i<n;i++){
            ans[i] = leftPrefix[i] * rightPrefix[i+1];
        }
        
        return ans;
    }
}