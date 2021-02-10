/*

Implement a queue using two stacks. 
Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: 
enqueue, which inserts an element into the queue, and 
dequeue, which removes it.

*/

import java.util.Stack;

public class Day_53_ImplementQueueUsingStacks{
	public static void main(String[] args) {
		Queue<Integer> q = new Queue();
		int[] nums = new int[]{1, 2, 3, 4, 5};

		for(int x : nums){
			q.enqueue(x);
		}

		while(q.size() > 0){
			System.out.println(q.dequeue());
		}
	}

	static class Queue<T>{
		Stack<T> A = new Stack<T>();
		Stack<T> B = new Stack<T>();

		// Time O(1)
		public void enqueue(T val){
			A.push(val);
		}

		// Amortized O(1)
		public T dequeue(){
			if(size() == 0){
				throw new RuntimeException("Can't perform dequeue operation on an empty queue");
			}
			
			if(B.size() == 0){
				while(A.size() > 0){
					B.push(A.pop());
				}
			}

			return B.pop();
		}

		public int size(){
			return A.size() + B.size();
		}
	}
}