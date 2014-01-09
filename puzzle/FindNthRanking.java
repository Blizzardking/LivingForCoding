package puzzle;

public class FindNthRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = {1,2}; 
		int a2[] = {3,4};
		System.out.println(findNth(a1, a2, 2));
	}
	static int findNth(int[] a, int[] b, int n) {
		return findNth(a, 0, a.length -1, b, 0, b.length - 1, n );
	}
	static int findNth(int[] a, int low1, int high1, int[] b, int low2, int high2, int n) {

		int mid1 = (low1 + high1)/2;
		int mid2 = (low2 + high2)/2;
		if(n == 1) {
			return a[mid1] < b[mid2] ? a[mid1]: b[mid2];
		}
		int N = high1 - low1 + 1;
		//if()
		if(a[mid1] < b[mid2]) {
			if( N%2 == 0) 
				mid1++;
			return findNth(a, mid1, high1, b, low2, mid2, (n + 1)/2 );
		}
		else {
			if( N%2 == 0)
				mid2++;
			return findNth(a, low1, mid1, b, mid2, high2, (n + 1)/2);
		}
	}
}
