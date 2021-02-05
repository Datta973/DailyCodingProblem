public class Day_49_MaximumSubarraySum{
	public static void main(String[] args) {
		System.out.println(solve(new int[]{34, -50, 42, 14, -5, 86}));
		System.out.println(solve(new int[]{-5, -1, -8, -9}));
	}

	private static int solve(int[] nums){
		int ans = 0;
		int sum = 0;

		for(int x : nums){
			sum += x;

			if(sum <= 0){
				sum = 0;
			}

			ans = Math.max(ans, sum);
		}

		return ans;
	}
}