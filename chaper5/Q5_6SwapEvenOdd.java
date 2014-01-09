package chaper5;

public class Q5_6SwapEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0b1010101101;
		int b = swap(a);
		System.out.println(Integer.toBinaryString(b));
	}
	static int swap(int a) {
		return ((a & 0xAAAAAAAA) >> 1) | ((a & 0x55555555) << 1);
	}
}	
