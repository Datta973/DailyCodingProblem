/*

Suppose an arithmetic expression is given as a binary tree. 
Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5

You should return 45, as it is (3 + 2) * (4 + 5).

*/

public class Day_50_EvaluateAnExpressionTree{
	static abstract class Node{
		Node left, right;
	}

	static class OperatorNode extends Node{
		char val;

		public OperatorNode(char val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class ValueNode extends Node{
		int val;

		public ValueNode(int val){
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new OperatorNode('*', 
			new OperatorNode('+', 
				new ValueNode(3), new ValueNode(2)), 
			new OperatorNode('+', 
				new ValueNode(4), new ValueNode(5))
		);

		System.out.println(solve(root));
	}

	// Time O(n)
	// Space O(1)
	private static int solve(Node root){
		if(root == null)
			return 0;

		if(root.left == null && root.right == null)
			return ((ValueNode)root).val;

		int left = solve(root.left);
		int right = solve(root.right);
		
		switch(((OperatorNode)root).val){
			case '+' : return left+right;
			case '-' : return left-right;
			case '*' : return left*right;
			case '/' : return left/right;
		}

		return 0;
	}
}