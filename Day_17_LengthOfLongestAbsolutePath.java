/*

Problem statement : 

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.

*/

import java.util.List;
import java.util.Stack;
import java.util.HashMap;

public class Day_17_LengthOfLongestAbsolutePath{
	public static void main(String[] args) {
		System.out.println(
			solve(
				"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
			)
		);

		System.out.println(
			solve(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
			)
		);
	}


	// Time O(N) - where N is the length of input string
	// Space O(M) - where M is the max number of tab spaces in a line
	private static int solve(String s){
		if(s.length() == 0)
			return 0;

		List<String> lines = java.util.Arrays.asList(s.split("\n"));
		int ans = 0;

		HashMap<Integer,Integer> map = new HashMap<>();

		for(String newLine : lines){
			int i=0;

			while(i<newLine.length() && newLine.charAt(i) == '\t')
				i++;

			boolean file = false;
			if(newLine.substring(i,newLine.length()).contains(".")){
				file = true;
			}

			int level = i;
			int newLength = newLine.length() - i;

			if(level > 0)
				newLength = map.get(level-1) + 1 + newLength;

			map.put(level, newLength);

			if(file)
				ans = Math.max(ans, newLength);
		}

		return ans;
	}
}