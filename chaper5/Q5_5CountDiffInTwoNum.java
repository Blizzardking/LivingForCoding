package chaper5;

public class Q5_5CountDiffInTwoNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0b10101010;
		int b = 0b1101010101;
		System.out.println(count(a,b));
	}
	static int count(int a, int b) {
		int c = a ^ b;
		int count = 0;
		for(; c != 0 ; c = c & c - 1) {
			count++;
		}
		return count;
	}
}
