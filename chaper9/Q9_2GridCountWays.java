package chaper9;

public class Q9_2GridCountWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(0, 0, 5, 5));
	}
	static int countWays(int x1, int y1, int x2, int y2) {
		int width = x2 - x1;
		int height = y2 - y1;
		int n1 = factorial( width + height);
		int n2 = factorial( width );
		int n3 = factorial( height );
		return n1 / (n2 * n3);
	}
	static int[] F = new int[1000];
	static int factorial(int n) {
		if (F[n]!=0) return F[n];
	    int fact = 1; // this  will be the result
	    for (int i = 1; i <= n; i++) {
	    	fact *= i;
	    	F[i] = fact;
	    }
	    return fact;
	}

}
