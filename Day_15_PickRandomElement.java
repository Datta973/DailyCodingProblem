/*

Problem statement : 

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

*/

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Day_15_PickRandomElement{
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		for(int i=0;i<10;i++){
			System.out.println(solve(input.iterator()));
		}
	}


	// Time O(n) - where n is the number of elements in the stream
	// Space O(1) - no extra space is used
	// Probability of picking an element is = 1 / n
	private static int solve(Iterator<Integer> stream){
		Random rand = new Random();
		int index = 0, ans = 0;

		while(stream.hasNext()){
			int num = stream.next();
			if(rand.nextInt(index+1) == index){
				ans = num;
			}
			
			index++;
		}

		return ans;
	}
}