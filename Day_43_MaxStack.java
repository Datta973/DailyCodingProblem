/*

Implement a stack that has the following methods:

	push(val), which pushes an element onto the stack

	pop(), which pops off and returns the topmost element of the stack. 
	If there are no elements in the stack, then it should throw an error or return null.

	max(), which returns the maximum value in the stack currently. 
	If there are no elements in the stack, then it should throw an error or return null.

Each method should run in constant time.

*/

import java.util.Stack;

public class Day_43_MaxStack{
	public static void main(String[] args) {
		solve(java.util.Arrays.asList(1, 7, 3, 2, 4, 8).iterator(), new String[]{
			"push", "push", "max", "pop", "max", "push", "push", "max", "push", "max", "pop", "push", "max", "pop", "max" ,"pop", "max"
		});
	}

	private static void solve(java.util.Iterator<Integer> stream, String[] commands){
		MaxStack ms = new MaxStack(); 
		for(String comm : commands){
			if(comm.equals("push")){
				int x = stream.next();
				ms.push(x);
				System.out.println("pushed : " + x);
			}else if(comm.equals("pop")){
				System.out.println("popped : " + ms.pop());
			}else{
				System.out.println("maximum : " + ms.max());
			}
		}
	}

	// Space O(n)
	static class MaxStack{
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> max = new Stack<>();

		// Time O(1)
		public void push(int val){
			stack.push(val);
			if(max.size() == 0 || max.peek() <= val){
				max.push(val);
			}
		}

		// Time O(1)
		public Integer pop(){
			if(stack.size() == 0)
				return null;

			int x = stack.pop();
			if(max.size() > 0 && max.peek() == x)
				max.pop();

			return x;
		}

		// Time O(1)
		public Integer max(){
			return max.size() > 0 ? max.peek() : null;
		}
	}
}