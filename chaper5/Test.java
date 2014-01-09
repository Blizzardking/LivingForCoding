package chaper5;
import java.util.*;
enum E { A, B };

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0b00000000;
		int b= 0b11111111;
		Typetester t = new Typetester();
		t.printType(a|b);
		String s = "abc";
		Class c = E.A.getClass();
		String[] arr = {"A","D","B", "C"};
		List<String> A = Arrays.asList(arr);
		System.out.println(A);
		Collections.sort(A, new StringComparator());
		System.out.println(A);
		System.out.println(s.substring(1,0));
		
	}
	static class Typetester {
	    void printType(byte x) {
	        System.out.println(x + " is an byte");
	    }
	    void printType(int x) {
	        System.out.println(x + " is an int");
	    }
	    void printType(float x) {
	        System.out.println(x + " is an float");
	    }
	    void printType(double x) {
	        System.out.println(x + " is an double");
	    }
	    void printType(char x) {
	        System.out.println(x + " is an char");
	    }
	}
}
class StringComparator implements Comparator<String>
{
	@Override
    public int compare (String s1, String s2)
    {
		if(s1.equals(s2)) return 0;
        return s1.compareTo(s2) > 0 ? -1 : 1;
    }
}
