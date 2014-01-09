package puzzle;

public class Q9FindMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {5,6,7,0,2,3};
		System.out.print(findMin(arr));
	}
	static int findMin(int[] arr) {
		return findMin(arr, 0, arr.length - 1);
	}
	static int findMin(int[] arr, int low, int high) {
		if(high <= low) {
			return low + 1;
		}
		int mid = (high + low) / 2;
		if(arr[mid] > arr[low])
			return findMin(arr, mid, high);
		else
			return findMin(arr, low, mid - 1);
		
	}	
}
