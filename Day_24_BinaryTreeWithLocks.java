/*

Problem statement : 

Implement locking in a binary tree. A binary tree node can be locked or unlocked 
only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, 
it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, 
it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. 
You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. 
Each method should run in O(h), where h is the height of the tree.

*/

public class Day_24_BinaryTreeWithLocks{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(
			new TreeNode(
				new TreeNode(),
				new TreeNode(
					new TreeNode(),
					null
				)
			),
			new TreeNode(
				new TreeNode(),
				null
			)
		);
	}

	static class TreeNode{
		boolean locked, leftLock, rightLock;
		TreeNode parent, left, right;

		public TreeNode(){}

		public TreeNode(TreeNode left, TreeNode right){
			this.left = left;
			this.right = right;
			if(left != null){
				left.parent = this;
			}
			if(right != null){
				right.parent = this;
			}
		}

		// O(h)
		public boolean is_valid(){
			boolean ancestorsLock = false;
			TreeNode curr = this.parent;
			while(curr != null && !ancestorsLock){
				ancestorsLock = ancestorsLock || curr.locked;
				curr = curr.parent;
			}
			return !this.leftLock && !this.rightLock && !ancestorsLock;
		}

		// O(1)
		public boolean is_locked(){
			return this.locked; 
		}

		// O(h)
		public boolean lock(){
			if(this.locked)
				return true;

			if(is_valid()){
				if(!this.leftLock && !this.rightLock){
					TreeNode curr = this;
					while(curr.parent != null && !curr.locked){
						if(curr.parent.left == this)
							curr.parent.leftLock = true;
						else
							curr.parent.rightLock = true;

						curr = curr.parent;
					}
				}

				return this.locked = true;
			}

			return false;
		}

		// O(h)
		public boolean unlock(){
			if(!this.locked)
				return true;

			if(is_valid()){
				this.locked = false;

				if(!this.leftLock && !this.rightLock){
					TreeNode curr = this;
					while(curr.parent != null && !curr.locked){
						if(curr.parent.left == this)
							curr.parent.leftLock = false;
						else
							curr.parent.rightLock = false;

						curr = curr.parent;
					}
				}

				return true;
			}

			return false;
		}
	}
}