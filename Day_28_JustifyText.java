/*

Write an algorithm to justify text. Given a sequence of words and an integer line length k, 
return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. 
There should be at least one space between each word. 
Pad extra spaces when necessary so that each line has exactly length k.
Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting 
from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words 
["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, 
you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly

*/

import java.util.List;
import java.util.ArrayList;

public class Day_28_JustifyText{
	public static void main(String[] args) {
		List<String> result = solve(new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"}, 16);
		for(String res : result){
			System.out.println("\""+res+"\"");
		}
	}

	/**
	* Time O(n)
	* Space O(n)
	* 	- where n is the total length of characters
	*
	* Note : The algorithm assumes that : 1 <= words[i].length <= k
	**/
	private static List<String> solve(String[] words, int k){
		List<String> ans = new ArrayList<>();
		int i = 0;

		while(i < words.length){
			int index = getLastPossibleIndex(words, i, k);
			int numWords = index-i;
			StringBuilder[] sbs = new StringBuilder[numWords+1];
			
			int numChars = 0;
			for(int j=0;j<sbs.length;j++){
				sbs[j] = new StringBuilder(words[i+j]);
				numChars += sbs[j].length();
			}

			if(sbs.length == 1){
				while(sbs[0].length() < k)
					sbs[0].append(" ");
			}else{
				int spaces = (k-numChars) / numWords;
				for(int j=0;j<sbs.length-1;j++){
					for(int l=0;l<spaces;l++)
						sbs[j].append(" ");
				}

				int extraSpaces = (k-numChars) % numWords;
				for(int j=0;j<extraSpaces;j++){
					sbs[j].append(" ");
				}
			}

			StringBuilder res = new StringBuilder();
			for(StringBuilder sb : sbs)
				res.append(sb);

			ans.add(res.toString());

			i = index+1;
		}

		return ans;
	}

	private static int getLastPossibleIndex(String[] words, int startIndex, int k){
		int numChars = 0;

		for(int i=startIndex;i<words.length;i++){
			int numWords = i-startIndex;
			numChars += words[i].length();

			if(numWords == 0)
				continue;

			if(numChars >= k || ((k - numChars) / numWords == 0))
				return i-1;
		}

		return words.length-1;
	}
}