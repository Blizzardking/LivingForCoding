package puzzle;
import java.util.*;
public class FindLongestIncreasingSequence {
	public static void main(String[] args) {
		char[] arr = {'1', '7', '8', '8', '4', '5', '2', '6'};
		//ShuffleArray(arr);
		System.out.println(Arrays.toString(arr));
		//System.out.println(findLIS(arr));
		printLIS2(arr);
		
	}
	//O(n*lgn)
	static void printLIS2(char[] arr) {
//		 		L = 0
//				 for i = 1, 2, ... n:
//				    binary search for the largest positive j ¡Ü L
//				      such that X[M[j]] < X[i] (or set j = 0 if no such value exists)
//				    P[i] = M[j]
//				    if j == L or X[i] < X[M[j+1]]:
//				       M[j+1] = i
//				       L = max(L, j+1)
		int sz = 1;
		int len = arr.length;
		//end element of smaller list is smaller than end elements of larger lists.
		char[] c = new char[len];
		//int[] p = new int[len];
		int[] dp = new int[len];
		c[1] = arr[0]; /*at this point, the minimum value of the last element of the size 1 increasing sequence must be array[0]*/
		dp[0] = 1;
		for( int i = 1; i < len; i++ ) {
		   if( arr[i] < c[1] ) {
		      c[1] = arr[i]; 
		      dp[i] = 1;
		   }
		   else if( arr[i] > c[sz] ) {
		      c[sz+1] = arr[i];
		      dp[i] = sz + 1;
		      sz++;
		   }
		   else {
		      int k = binarySearch( c, sz, arr[i] ); 
		      c[k] = arr[i];
		      dp[i] = k;
		   }
		}
		System.out.println(Arrays.toString(c));
		System.out.println(sz);

	}
	public static int binarySearch(char[] c, int len, int p) {
		int start = 1;
		int end = len;
		int mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if(c[mid] == p) {
				return mid;
			}
			else if(c[mid] > p) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return mid + 1;
	}
	//O(n2)
	static List<Character> findLIS(char[] arr) {
		int n = arr.length;
		char[] b = Arrays.copyOf(arr, n);
		Arrays.sort(b);
		int [][] s = new int[n + 1][n + 1];
		char [][] direct = new char[n + 1][n + 1];
		for( int i = 1; i < n + 1; i++) 
			for( int j = 1; j < n + 1; j++)  {
				if( arr[j - 1] == b[i - 1]) {
					s[i][j] = s[i - 1][j - 1] + 1;
					direct[i][j] = 'q';
				}
				else if(s[i - 1][j] > s[i][j - 1]) {
					s[i][j] = s[i - 1][j];
					direct[i][j] = 'w';
				}
				else {
					s[i][j] = s[i][j - 1];
					direct[i][j] = 'a';	
				}
			}
		int i = n;
		int j = n;
		List<Character> list = new LinkedList<>();
		while(i > 0 && j >0) {
			switch(direct[i][j]) {
				case 'q': 
					i--;
					j--;
					list.add(0, arr[j]);
					break;
				case 'w':
					i--;
					break;
				case 'a':
					j--;
					break;
				default: System.err.println("Error:");
					
			}
		}
		return list;
		
	}
	static private void ShuffleArray(char[] array)
	{
	    int index;
	    char temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}

}
