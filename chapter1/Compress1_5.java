package chapter1;

public class Compress1_5 {
	public static void main(String[] args) {
		String s = "aabbbccaaa";
		System.out.println(compress(s));
	}
	
	public static String compress(String str) {
		StringBuffer sb = new StringBuffer();
		int L = 1;
		int j = 0;
		while(j < str.length()) {
			sb.append(str.charAt(j));
			L = 1;
			while(j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1 )) { // Found the length of character str[j]
				L++;
				j++;
			}
			sb.append(L);
			j++;
		}
		if(sb.length() >= str.length())
			return str;
		else
			return sb.toString();
	}
}
