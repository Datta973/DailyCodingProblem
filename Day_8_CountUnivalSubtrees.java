/*

Problem statement :

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1


Solution complexity : Time O(n), Space O(1) ignoring call stack space

*/
public class Day_8_CountUnivalSubtrees{
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
    public static void main(String[] args){
        System.out.println(
                            solve(
                            new TreeNode(0, new TreeNode(1), 
                                            new TreeNode(0, new TreeNode(1, new TreeNode(1), new TreeNode(1)), 
                                                            new TreeNode(0)
                                                        )
                                        )
                                 )
                          ); // outputs 5
    }
    
    private static int solve(TreeNode root){
        return Math.abs(helper(root));
    }
    
    private static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left < 0 || right < 0){
            return -(Math.abs(left)+Math.abs(right));
        }
        
        int leftVal = root.left != null ? root.left.val : root.val;
        int rightVal = root.right != null ? root.right.val : root.val;
        
        return root.val == leftVal && root.val == rightVal ? 1 + left + right : -(left + right);
    }
}