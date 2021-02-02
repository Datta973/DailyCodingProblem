/*

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, 
implement a function rand7() that returns an integer from 1 to 7 (inclusive).

*/
public class Day_45_ImplementRand7UsingRand5{
	public static void main(String[] args) {
		for(int i=0;i<30;i++)
			System.out.println(solve());
	}

	/*
	
	Rejection sampling

	  |	1	2	3	4	5
	---------------------
	1 |	1	2	3	4	5
	
	2 |	6	7	1	2	3

	3 |	4	5	6	7	1

	4 |	2	3	4	5	6

	5 |	7	*	*	*	*

	*/

	// Time - average : O(1), worst : O(inf)
	// Space O(1) 
	private static int solve(){
		int ans = 22;

		do
			ans = (rand5()-1) * 5 + rand5();
		while(ans > 21);

		return (ans % 7) + 1;
	}

	private static int rand5(){
		return (int)(Math.random() * 5) + 1;
	}
}