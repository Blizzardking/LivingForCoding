package chapter1;
import java.util.*;
public class IsUnique1_1 {
	public static void main(String[] args ) {
		String s ="bcdefg";
		System.out.println(isUniqueChars(s));
		
	}	
	public static boolean isUniqueChars(String str) {
		if(str.length() > 256)
			return false;
		BitSet bs = new BitSet(256);
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(bs.get(val)) return false;
			bs.set(val);
		}
		return true;
		
	}
}
