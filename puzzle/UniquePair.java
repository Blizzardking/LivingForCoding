package puzzle;
import java.util.*;
public class UniquePair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1,3};
		System.out.println(findDistinctPair(arr));
	}
	// include (x, y) and (y, x), x != y
	static Set<Pair> findDistinctPair(int [] arr) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Pair> resultSet = new HashSet<Pair>();
		for(int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		LinkedList<Integer> list = new LinkedList<Integer>(set);
		for(Integer i: set)
			for(Integer j: set) {
				if(i != j) {
					Pair p1 = new Pair(i,j);
					resultSet.add(p1);
				}
			}
		
		return resultSet;
	}
	//include(x, y) but not (y, x), x != y;
	static Set<Pair> findDistinctPair2(int [] arr) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Pair> resultSet = new HashSet<Pair>();
		for(int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		LinkedList<Integer> list = new LinkedList<Integer>(set);
		for(int i = 0; i < list.size(); i++) 
			for(int j = i; j < list.size(); j++) {
				int x = list.get(i);
				int y = list.get(j);
				if(x != y) {
					Pair p1 = new Pair(x, y);
					resultSet.add(p1);
				}
			}
		return resultSet;
	}
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean equals(Pair p) {
			return this.x == p.x && this.y == p.y;
		}
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

}
