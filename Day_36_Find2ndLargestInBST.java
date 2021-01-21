/*

Given the root to a binary search tree, find the second largest node in the tree.

*/

public class Day_36_Find2ndLargestInBST{
	static class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right){
			this(val);
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7,	
							new TreeNode(3, 
								new TreeNode(1), 
								new TreeNode(6)
							), 
							new TreeNode(10, 
								new TreeNode(8),
								null
							)
						);

		System.out.println(solve(root));
	}

	private static Integer solve(TreeNode root){
		return helper(root, null, null);
	}


	// Time = O(logn) = O(h), where n is number of nodes & h is height of the tree
	// Space O(1)
	private static Integer helper(TreeNode root, Integer first, Integer second){
		if(root == null){
			return second;
		}

		if(first == null){
			first = root.val;
		}else{
			if(root.val > first){
				second = first;
				first = root.val;
			}else if(root.val < first && (second == null || root.val > second)){
				second = root.val;
			}
		}

		return root.right != null ? helper(root.right, first, second) : helper(root.left, first, second);
	}
}