/*

We can determine how "out of order" an array A is by counting the number of inversions it has. 
Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. 
That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. 
The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). 
The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

*/

public class Day_44_NumberOfInversionsInAnArray{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{1, 2, 3, 4, 5}));
		System.out.println(solve(new int[]{2, 4, 1, 3, 5}));
		System.out.println(solve(new int[]{5, 4, 3, 2, 1}));
		System.out.println(solve(new int[]{9, 3, 6, 1, 8, 5, 2, 4}));
	}

	// Time O(n*logn)
	// Space O(n)
	private static int solve(int[] nums){
		if(nums.length == 0)
			return 0;

		int ans = 0;
		BST tree = new BST(nums[0]);

		for(int i=1;i<nums.length;i++){
			ans += tree.search(tree, nums[i]);
			tree.add(nums[i]);
		}

		return ans;
	}

	static class BST{
		int val, children;
		BST left, right;

		public BST(int val){
			this.val = val;
		}

		// Time O(logn)
		public void add(int val){
			if(val < this.val){
				if(this.left == null)
					this.left = new BST(val);
				else
					this.left.add(val);
			}else{
				if(this.right == null)
					this.right = new BST(val);
				else
					this.right.add(val);
			}

			children++;
		}

		// Time O(logn)
		private int search(BST root, int val){
			if(root == null)
				return 0;

			return val < root.val 
				? search(root.left, val) + 1 + (root.right == null ? 0 : 1 + root.right.children) 
				: search(root.right, val);
		}
	}
}