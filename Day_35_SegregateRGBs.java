/*

Given an array of strictly the characters 'R', 'G', and 'B', 
segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. 
You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], 
it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

*/

public class Day_35_SegregateRGBs{
	public static void main(String[] args) {
		char[] arr = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
		solve(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}

	private static void solve(char[] arr){
		int n = arr.length;
		int left = 0, right = n-1;

		for(int i=0;i<=right;i++){
			if(arr[i] == 'R')
				swap(arr, left++, i);
			else if(arr[i] == 'B')
				swap(arr, i--, right--);
		}
	}

	private static void swap(char[] arr, int i, int j){
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}