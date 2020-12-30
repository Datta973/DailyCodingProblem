/*


Problem statement : 

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.

*/

import java.util.Random;

public class Day_16_LogLastNElements{
	public static void main(String[] args) {
		int N = 3;
		Logger logger = new Logger(N);
		int[] input = new int[]{1,2,3,4,5,6,7,8,9};
		Random rand = new Random();

		for(int i=0;i<9;i++){
			logger.record(input[i]);
			System.out.print("record("+input[i]+"); ");
			int index = rand.nextInt(Math.min(i+1, N)) + 1;
			System.out.println("get_last("+index+") = " + logger.get_last(index));
		}
	}

	// Time O(1) - All operations are performed in constant time
	// Space O(N)
	static class Logger{
		int lastIndex = -1, N;
		int[] mem;

		public Logger(int N){
			this.N = N;
			mem = new int[N];
		}

		public void record(int order_id){
			lastIndex = ++lastIndex % N;
			mem[lastIndex] = order_id;
		}

		public int get_last(int i){
			return mem[(N + lastIndex - (i-1)) % N];
		}
	}
}