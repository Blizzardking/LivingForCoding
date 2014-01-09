package puzzle;
import java.util.*;
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,6,7,8,5,4};
		int sum = 17;
		System.out.println(threeSum(arr, sum));
	}
	static boolean twoSum(int[] arr, int sum) {
		HashSet<Integer> ht = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			int j =  sum - arr[i];
			if(ht.contains(j)) {
				System.out.println(arr[i] + " " + j);
				return true;
			}
			if(!ht.contains(arr[i])) {
				ht.add(arr[i]);
			}
		}
		return false;
	}
	static boolean threeSum(int[] arr, int sum) {
		for(int i = 0; i < arr.length; i++) {
			if(twoSum(arr, i, sum - arr[i])) {
				return true;
			}
		}
		return false;
	}
	static boolean twoSum(int[] arr, int index, int sum) {
		HashSet<Integer> ht = new HashSet<Integer>();
		for(int i = index + 1; i < arr.length; i++) {
			int j =  sum - arr[i];
			if(ht.contains(j)) {
				System.out.println(arr[index] + " " + arr[i] + " " + j);
				return true;
			}
			if(!ht.contains(arr[i])) {
				ht.add(arr[i]);
			}
		}
		return false;
	}
}
