/*

Compute the running median of a sequence of numbers. That is, given a stream of numbers, 
print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

	2
	1.5
	2
	3.5
	2
	2
	2

*/

import java.util.PriorityQueue;

public class Day_33_RunningMedian{
	public static void main(String[] args) {
		solve(java.util.Arrays.asList(2, 1, 5, 7, 2, 0, 5).iterator());	
	}

	// Time O(n*logn)
	// Space O(n)
	private static void solve(java.util.Iterator<Integer> it){
		PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> q = new PriorityQueue<>();

		while(it.hasNext()){
			int x = it.next();
			p.add(x);

			if(p.size() != q.size()){
				q.add(p.poll());
				System.out.println(q.peek());
			}else{
				p.add(q.poll());
				q.add(p.poll());
				System.out.println((p.peek() + q.peek())/2.0);
			}
		}
	}
}