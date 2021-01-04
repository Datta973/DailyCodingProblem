/*

Problem statement :

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

*/

public class Day_20_IntersectionPointOfLinkedLists{
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}

		public ListNode(int val, ListNode next){
			this(val);
			this.next = next;
		}

		public String toString(){
			return "ListNode[val:"+this.val+"]";
		}
	}

	public static void main(String[] args) {
		ListNode common = new ListNode(8, new ListNode(10));
		ListNode left = new ListNode(3, new ListNode(7, common));
		ListNode right = new ListNode(99, new ListNode(1, common));
		
		System.out.println(solve(left, right));
	}

	// Time O(M + N)
	// Space O(1)
	private static ListNode solve(ListNode left, ListNode right){
		if(left == null || right == null)
			return null;

		ListNode curr = left;
		int leftLength = 0;
		while(curr != null){
			leftLength++;
			curr = curr.next;
		}

		curr = right;
		int rightLength = 0;
		while(curr != null){
			rightLength++;
			curr = curr.next;
		}

		int c = leftLength - rightLength;
		if(c >= 0)
			while(c-->0)
				left = left.next;
		else
			while(c++<0)
				right = right.next;

		while(left != null){
			if(left == right)
				return left;

			left = left.next;
			right = right.next;
		}

		return null;
	}
}