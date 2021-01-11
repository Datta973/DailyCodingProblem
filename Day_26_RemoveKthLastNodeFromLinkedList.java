/*

Given a singly linked list and an integer k, remove the kth last element from the list. 
k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

*/

public class Day_26_RemoveKthLastNodeFromLinkedList{
	public static void main(String[] args) {
		ListNode head = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
		System.out.println(solve(head, 2));

		head = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
		System.out.println(solve(head, 4));
	}


	// Time O(n)
	// Space O(1)
	private static ListNode solve(ListNode head, int k){
		ListNode dummy = new ListNode(0, head);
		ListNode prev = dummy;
		ListNode curr = head;

		for(int i=0;i<k;i++,curr = curr.next);

		for(;curr != null; prev = prev.next, curr = curr.next);

		prev.next = prev.next.next;

		return dummy.next;
	}

	static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val, ListNode next){
			this.val = val;
			this.next = next;
		}

		public String toString(){
			StringBuilder sb = new StringBuilder();

			for(ListNode curr = this; curr != null; curr = curr.next)
				sb.append(curr.val).append("->");
			
			sb.append("null");

			return sb.toString();
		}
	}
}