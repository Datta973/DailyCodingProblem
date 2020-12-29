/*

Problem statement : 

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
Hint: The basic equation of a circle is x2 + y2 = r2.

*/

import java.util.Random;

public class Day_14_EstimatePI{
	public static void main(String[] args) {
		System.out.println(solve());
	}

	// Time O(10^6) - accuracy for upto 3 decimal places required 10^6 samplings and also most of the sampling were repetitive
	// Space is O(r) - where r is the radius taken into consideration. Radius 65 works perfectly for simulation
	// if you divide circle area by square area having a radius r and side length r respectively then you can do
	// (PI * r^2) / (r^2) = PI
	// Using Monte Carlo method you can derive PI with just random samplings
	private static double solve(){
		int r = 65;
		double circleArea = 0.0;
		double squareArea = 0.0;

		Random rand = new Random();
		boolean[][] used = new boolean[4*r+1][4*r+1];

		for(long i=0;i<1000000;i++){
			int randX = random(rand, 2*r);
			int randY = random(rand, 2*r);
			
			if(used[randX+2*r][randY+2*r]){
				continue;
			}

			if(pointInsideCircle(r, randX, randY)){
				circleArea++;
			}
			if(pointInsideSquare(r, randX, randY)){
				squareArea++;
			}

			used[randX+2*r][randY+2*r] = true;
		}

		System.out.println("Expected - circle area : "+ (Math.PI * r * r) + ", square area : " + (r * r));
		System.out.println("Derived - circle area : " + circleArea + ", square area : " + squareArea);
		System.out.print("PI = " + circleArea + " / " + squareArea + " = ");

		return circleArea / squareArea;
	}

	// gives a random integer from [-n, n]
	private static int random(Random rand, int n){
		return n - rand.nextInt(2*n + 1);
	}

	// tells whether a point is inside a circle or not
	private static boolean pointInsideCircle(int r, int x, int y){
		int d = r*r - (x*x + y*y);
		return d >= 0;
	}

	// tells whether a point is inside a square or not
	private static boolean pointInsideSquare(int s, int x, int y){
		return Math.abs(x) <= s/2.0 && Math.abs(y) <= s/2.0;
	}
}