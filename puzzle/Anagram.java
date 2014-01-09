package puzzle;
import java.util.*;
public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abddee";
		String s2 = "debade";
		Character c  = 'd';
		int[] a= {1,2,3};
		int[] b = {1,2,3};
		System.out.println(a.hashCode());
		System.out.println(a);
		System.out.println(isAnagram(s1, s2));
		String[] str = {"abc", "cba", "bbc", "ccd", "cdc", "c", "bca"};
		System.out.println(getAllAnagrams(str));
	}
	static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		Hashtable<Character, Integer> table = new Hashtable<>();
		for (int i = 0; i < a.length(); i++ ) {
			char c = a.charAt(i);
			if(!table.containsKey(c)) {
				table.put(c, 1);
			}
			else {
				table.put(c, table.get(c) + 1);
			}
		}
		for (int j = 0; j < b.length(); j++) {
			char c = b.charAt(j);
			if(!table.containsKey(c)) 
				return false;
			int value = table.get(c);
			value--;
			if(value == 0) {
				table.remove(c);
			}
			else {
				table.put(c, value);
			}
		}
		if(!table.isEmpty()) 
			return false;
		return true;
	}
	static Collection<LinkedList<String>> getAllAnagrams(String[] arr) {
		HashMap<ArrayList<Character>, LinkedList<String>> hm = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			ArrayList<Character> al = toCharacterArray(arr[i]);
			Collections.sort(al);
			LinkedList<String> value = hm.get(al);
			if(value == null) {
				value = new LinkedList<String>();
				hm.put(al, value);
			}
			
			value.add(arr[i]);
			
		}
		
		return hm.values();
	}

	static ArrayList<Character> toCharacterArray(String s) {
		if (s == null) {
			return null;
		}
		ArrayList<Character> al = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			al.add(new Character(s.charAt(i)));
		}

		return al;
	}
}
