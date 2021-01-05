/*

Problem statement :

Given a dictionary of words and a string made up of those words (no spaces), 
return the original sentence in a list. If there is more than one possible reconstruction, return any of them. 
If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", 
you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

*/

import java.util.List;
import java.util.HashSet;

public class Day_22_ReconstructionOfSentenceFromWords{
	public static void main(String[] args) {
		System.out.println(solve(java.util.Arrays.asList("quick", "brown", "the", "fox"), "thequickbrownfox"));	
		System.out.println(solve(java.util.Arrays.asList("bed", "bath", "bedbath", "and", "beyond"), "bedbathandbeyond"));	
	}

	private static List solve(List<String> words, String sentence){
		List<String> ans = new java.util.ArrayList<>();
		return helper(sentence, 0, "", new HashSet<>(words), new boolean[sentence.length()+1], ans) ? ans : null;
	}	

	// Time : O(N^3)
	// Space : O(N)
	private static boolean helper(String s, int i, String res, HashSet<String> words, boolean[] visited, List<String> ans){
		if(i >= s.length()){
			return res.length() == 0;
		}

		res += s.charAt(i);

		if(words.contains(res) && !visited[i+1]){
			ans.add(res);

			if(helper(s, i+1, "", words, visited, ans))
				return true;
			visited[i+1] = true;

			ans.remove(ans.size()-1);
		}

		return helper(s, i+1, res, words, visited, ans);
	}
}