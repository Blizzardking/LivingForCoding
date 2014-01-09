package puzzle;

import java.util.Arrays;

public class FindMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,32322,403, 3,283927,2329,23,329,12,404,3839,900};
		System.out.println(findMedian(arr));
		Arrays.sort(arr);
		System.out.print(arr.length + " " + Arrays.toString(arr));
	}
	static double findMedian(int[] arr) {
		int n = arr.length;
		if(n % 2 == 1) {
			return (double)find(arr, 0, n-1, n/2);
		}
		else {
			int a = find(arr, 0, n-1, n/2);
			int b = find(arr, 0, n-1, n/2 - 1);
			return (double)(a + b)/2;
			
		}
	}
	static int find(int[] arr, int low, int high, int rank) {
//		int pivot = getRandom(low, high);
//		swap(arr, low, pivot);
		int k = partition2(arr, low, high);
		if(rank == k) {
			return arr[k];
		}
		else if(rank < k) {
			return find(arr, low, k - 1, rank);
		}
		else {
			return find(arr, k + 1, high, rank);
		}
	}
	static int partition(int[] arr, int low, int high) {
		int pivot = getRandom(low, high);
		swap(arr, low, pivot);
		int x = arr[low];
		int i = low + 1;
		int j = low + 1;
		while(j <= high) {
			if(arr[j] > x) {
				j++;
			}
			else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
		swap(arr, low, i - 1);
		return i - 1;
		
	}

	static int partition2(int[] arr, int low, int high) {
		if (high <= low) {
			return low;
		}
		int x = arr[low];
		int i = low;
		int j = high;
		while (true) {
			while (i <= j && arr[i] <= x)
				i++;
			while (i <= j && arr[j] > x)
				j--;
			if (i < j)
				swap(arr, i, j);
			else
				break;
		}
		swap(arr, i - 1, low);
		return i - 1;
	}

	static int getRandom(int i, int j) {
		return (int)((j - i + 1) * Math.random()) + i;
	}
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
