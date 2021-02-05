/*

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g

*/

public class Day_48_TreeFromPreorderAndInorder{
	
	static class TreeNode{
		char val;
		TreeNode left, right;

		public TreeNode(char val){
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode ans = solve(
			new char[]{'a', 'b', 'd', 'e', 'c', 'f', 'g'},
		 	new char[]{'d', 'b', 'e', 'a', 'f', 'c', 'g'}
		);
	}

	// Time O(n)
	// Space O(n)
	private static TreeNode solve(char[] preorder, char[] inorder){
		int[] map = new int[26];

		for(int i=0;i<inorder.length;i++)
			map[inorder[i]-'a'] = i;
		
		return helper(preorder, inorder, 0, inorder.length-1, new int[1], map);
	}

	private static TreeNode helper(char[] preorder, char[] inorder, int start, int end, int[] index, int[] map){
		if(start > end)
			return null;
		
		char rootVal = preorder[index[0]++];
		int rootIndex = map[rootVal-'a'];

		TreeNode root = new TreeNode(rootVal);
		root.left = helper(preorder, inorder, start, rootIndex-1, index, map);
		root.right = helper(preorder, inorder, rootIndex+1, end, index, map);

		return root;
	}
}