package chapter1;
import java.util.*;
public class Permutate {
	public static void main(String[] args) {
		String s1 = "abcdefgg";
		String s2 = "ggdcebaf";
		System.out.println(permutate(s1,s2));
	}
	
	static boolean permutate(String str1, String str2) {
		Set<Character> set = new HashSet<Character>();
		if(str1.length() != str2.length())
			return false;
		for (int i = 0; i < str1.length(); i++) {
			set.add(str1.charAt(i));
		}
		for(int i = 0; i < str2.length(); i++) {
			if(!set.remove(str2.charAt(i)))
				return false;
		}
		if(!set.isEmpty())
			return false;
		else 
			return true;
	}
	static boolean permutate2(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		else
			return sort(str1).equals(sort(str2));
	}
	static String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}