/*

Given a string of round, curly, and square open and closing brackets, 
return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.

*/

public class Day_27_CheckForVariedBracketsBalancing{
	public static void main(String[] args) {
		System.out.println(solve("([])[]({})")); // true
		System.out.println(solve("([)]")); // false
		System.out.println(solve("((()")); // false
	}

	/**
	* Time O(n)
	* Space O(n)
	**/
	private static boolean solve(String s){
		java.util.Stack<Character> stack = new java.util.Stack<>();

		for(char bracket : s.toCharArray()){
			if(isClosedBracket(bracket)){
				if(stack.size() == 0 || stack.peek() != toOpenBracket(bracket))
					return false;
				
				stack.pop();
			}else{
				stack.push(bracket);
			}
		}

		return stack.size() == 0;
	}

	// Time O(1)
	private static boolean isClosedBracket(char bracket){
		return bracket == ')' || bracket == ']' || bracket == '}';
	}

	// Time O(1)
	private static char toOpenBracket(char closedBracket){
		return closedBracket == ')' ? '(' : (closedBracket == ']' ? '[' : '{');
	}
}