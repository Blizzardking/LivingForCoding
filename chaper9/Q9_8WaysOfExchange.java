package chaper9;

public class Q9_8WaysOfExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {1, 5, 10, 25};
		int n = 1000;
		System.out.println(ways(n, c));
	}
	static int ways(int n, int[] c) {
		int [][] M = new int[n + 1][c.length + 1];
		for(int j = 0; j <= c.length; j++) {
			M[0][j] = 1;
		}
		for(int i = 1; i <= n; i++) {
			M[i][0] = 0;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= c.length; j++) {
				if(i < c[j - 1]) 
					M[i][j] = M[i][j-1];
				else
					M[i][j] = M[i - c[j - 1]][j] + M[i][j-1];
			}
		}
		return M[n][c.length];
	}
}
