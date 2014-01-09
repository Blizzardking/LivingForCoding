package chaper9;
import java.util.*;

public class Q9_4PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < 3; i++) {
			set.add(i);
		}
		System.out.println(getSubSets(set));
	}
	static Set<Set<Integer>> getSubSets(Set<Integer> set1) {
		Set<Set<Integer>> set2 = new HashSet<>();
		set2.add(new HashSet<Integer>());
		for(Integer i: set1) {
			//Set<Set<Integer>> set3 = new HashSet<>(set2);
			Set<Set<Integer>> set3 = deepCopy(set2);
			for(Set<Integer> set: set3) {
				set.add(i);
				set2.add(set);
			}
		}
		return set2;
	}
	static Set<Set<Integer>> getSubSets2(Set<Integer> set1) {
		Set<Set<Integer>> set2 = new HashSet<>();
		set2.add(new HashSet<Integer>());
		Set<Set<Integer>> set3 = null;
		for(Integer i: set1) {
			set3 = new HashSet<Set<Integer>>();
			for(Set<Integer> set: set2) {
				Set<Integer> temp = new HashSet<>();
				for(Integer j: set)
					temp.add(j);
				temp.add(i);
				set3.add(temp);
			}
			set2.addAll(set3);
		}
		return set2;
	}
	static Set<Set<Integer>> deepCopy(Set<Set<Integer>> set1) {
		Set<Set<Integer>> set3 = new HashSet<>();
		for(Set<Integer> set: set1) {
			Set<Integer> s = new HashSet<Integer>();
			for(Integer i: set) {
				s.add(i);
			}
			set3.add(s);
		}
		return set3;
	}
}
