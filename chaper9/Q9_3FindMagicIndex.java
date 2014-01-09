package chaper9;

public class Q9_3FindMagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-7, -4, 0, 1, 3, 5, 7};
		System.out.print(findMagicIndex(arr));

	}
	static int findMagicIndex(int[] A) {
		return findMagicIndex(A, 0, A.length -1);
	}
	//O(n)/O(lgn); -1 means no magic index exists;
	static int findMagicIndex(int[] A, int low, int high) {
		if(high < low) {
			return -1;
		}
		int mid = (low + high) / 2;
		if(A[mid] == mid)
			return mid;
		else if (A[mid] > mid) {
			return findMagicIndex(A, low, mid - 1);
		}
		else
			return findMagicIndex(A, mid + 1, high);
	}

}
