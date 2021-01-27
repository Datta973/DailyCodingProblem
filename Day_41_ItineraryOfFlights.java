/*

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. 
If there are multiple possible itineraries, return the lexicographically smallest one. 
All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] 
and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', 
you should return null

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', 
you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] 
is also a valid itinerary. However, the first one is lexicographically smaller.

*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Day_41_ItineraryOfFlights{
	public static void main(String[] args) {
		System.out.println(solve(java.util.Arrays.asList(new String[]{"SFO", "HKO"}, new String[]{"YYZ", "SFO"}, new String[]{"YUL", "YYZ"}, new String[]{"HKO", "ORD"}), "YUL"));
		System.out.println(solve(java.util.Arrays.asList(new String[]{"SFO", "COM"}, new String[]{"COM", "YYZ"}), "COM"));
		System.out.println(solve(java.util.Arrays.asList(new String[]{"A", "B"}, new String[]{"A", "C"}, new String[]{"B", "C"}, new String[]{"C", "A"}), "A"));
	}

	// Time O(n * logn)
	// Space O(n)
	// 	- where n is the number of flights
	private static List<String> solve(List<String[]> flights, String src){
		Map<String, PriorityQueue<String>> map = new java.util.HashMap<>();

		for(String[] f : flights){
			map.computeIfAbsent(f[0], a->new PriorityQueue<>()).add(f[1]);
		}

		LinkedList<String> ans = new LinkedList<>();
		helper(src, map, ans);

		return ans.size() == flights.size() + 1 ? ans : null;
	}

	private static void helper(String curr, Map<String,PriorityQueue<String>> map, LinkedList<String> ans){

		PriorityQueue<String> q = map.get(curr);

		if(q != null){
			while(!q.isEmpty()){
				helper(q.poll(),map,ans);
			}
		}

		ans.addFirst(curr);
	}
}