/*

Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, 
write a function that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.

*/

import java.util.Random;

public class Day_51_ShuffleADeckOfCards{
	public static void main(String[] args) {
		int n = 52;
		int[] cards = new int[n];
		for(int i=0;i<n;i++)
			cards[i] = i+1;
		
		solve(cards, new Random());
		System.out.println(java.util.Arrays.toString(cards));
	}

	// Time O(n)
	// Space O(1)
	private static void solve(int[] nums, Random rand){
		for(int i=nums.length-1;i>0;i--){
			swap(nums, rand.nextInt(i+1), i);
		}
	}

	private static void swap(int[] nums, int i, int j){
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}