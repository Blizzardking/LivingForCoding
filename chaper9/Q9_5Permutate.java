package chaper9;
import java.util.*;
public class Q9_5Permutate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		System.out.print(computePermute(s).size());
	}
	static Set<String> computePermute(String s1) {
		if(0 == s1.length()) 
			return new HashSet<>();
		char start = s1.charAt(0);
		Set<String> set1 = computePermute(s1.substring(1));
		if(set1.isEmpty()) {
			set1.add(new String(start + ""));
			return set1;
		}
		Set<String> newSet = new HashSet<>();
		for(String s: set1) {
			
			for(int i = 0; i < s.length(); i++) {
				StringBuilder newString = new StringBuilder(s);
				newString.insert(i, start);
				newSet.add(newString.toString());
			}
			StringBuilder newString = new StringBuilder(s);
			newString.append(start);
			newSet.add(newString.toString());
		}
		return newSet;
	}
}
