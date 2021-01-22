/*

The power set of a set is the set of all its subsets. 
Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, 
it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

*/

import java.util.List;
import java.util.ArrayList;

public class Day_37_GeneratePowerSet{
	public static void main(String[] args) {
		System.out.println(solve(java.util.Arrays.asList(1, 2, 3)));
	}

	// Time O(n * 2^n)
	// Space O(n * 2^n)
	private static List<List<Integer>> solve(List<Integer> set){
		List<List<Integer>> ans = new ArrayList<>();
		if(set == null || set.size() == 0)
			return ans;
		
		helper(set, 0, new ArrayList<>(), ans);

		return ans;
	}

	private static void helper(List<Integer> set, int pos, List<Integer> res, List<List<Integer>> ans){
		for(int i=pos;i<set.size();i++){
			res.add(set.get(i));
			helper(set, i+1, res, ans);
			res.remove(res.size()-1);
		}

		ans.add(new ArrayList<>(res));
	}
}