/*

Problem statement : 

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

*/

public class Day_4_FirstMissingPositiveInteger{
    public static void main(String[] args){
        System.out.println(solve(new int[]{3, 4, -1, 1}));
    }
    
    // Time O(n) = iterating n elements + atmost n swaps => O(2*n) = O(n)
    // Space O(1)
    private static int solve(int[] nums){
        int n = nums.length;
        
        // swap until the current position is either non-positive
        // or is in it's right place
        // atmost n swaps overall
        for(int i=0;i<n;i++){
            int x = nums[i];
            while((x > 0 && x <= n) && x != nums[x-1]){
                int t = nums[x-1];
                nums[x-1] = x;
                x = nums[i] = t;
            }
        }
        
        // iterate through each element and if it
        // is not in it's correct spot then that element is missing
        for(int i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        
        
        // if every number is in correct spot then
        // definitely n+1 is the first missing positive 
        return n+1;
    }
}