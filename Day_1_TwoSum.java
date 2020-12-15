/*

Problem Statement : 
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

*/

import java.util.*;
public class Day_1_TwoSum{
    public static void main(String[] args){
        System.out.println(twoSum(new int[]{10, 15, 3, 7}, 17)); // returns true as 10+7=17
    }
    
    // for input size n -> time : O(n), space : O(n)
    private static boolean twoSum(int[] nums, int k){
        int n = nums.length;
        
        // if only one element exists then you can never find a pair
        if(n <= 1){
            return false;
        }
        
        // HashSet : finds an element's existence in O(1) time
        Set<Integer> set = new HashSet<>();
        
        // one pass and Time-complexity : O(n)
        for(int x : nums){
            // finds in O(1) time
            // we are looking for a pair that add upto k. 
            // meaning pair (x,y) -> x+y = k -> then y = k-x
            // so if we know y exists then we found the pair (x,y) as x+y = k
            if(set.contains(k-x)){
                return true;
            }
            
            // inserts in O(1) time
            set.add(x);
        }
        
        return false;
    }
}