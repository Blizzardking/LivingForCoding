package puzzle;

public class Divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		int b = 20;
		System.out.print(divide(a, b));

	}
	static int divide(int a, int b) {
		int shift = 0;
		while((a<<shift)< b) {
			shift++;
		}
		return divide(a << shift, b, shift);
	}
	static int divide(int a, int b, int i) {
		if(i < 0) {
			return 0;
		}
		if(a <= b) {
			return (1<<i) + divide(a>>1, b - a, i - 1);
		}
		else {
			return divide(a>>1, b, i - 1);
		}
	}
	
}
