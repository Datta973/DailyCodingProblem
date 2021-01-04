/*

Problem statement : 

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*/

import java.util.TreeMap;

public class Day_21_MinNumberOfRoomsForGivenIntervals{
	public static void main(String[] args) {
		System.out.println(solve(new int[][]{{30, 75}, {0, 50}, {60, 150}})); // outputs 2
		System.out.println(solve(new int[][]{{0, 10}, {3, 11}, {5, 12}, {8, 15}, {17, 25}, {18, 24}, {19, 23}, {20, 22}, {21, 30}})); // outputs 5
	}

	// Time O(N*logN)
	// Space O(N)
	private static int solve(int[][] intervals){
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		for(int[] in : intervals){
			treeMap.put(in[0], treeMap.getOrDefault(in[0], 0)+1);
			treeMap.put(in[1]+1, treeMap.getOrDefault(in[1]+1, 0)-1);
		}

		int ans = 0;
		int sum = 0;

		for(int key : treeMap.keySet()){
			sum += treeMap.get(key);
			ans = Math.max(ans, sum);
		}

		return ans;
	}
}