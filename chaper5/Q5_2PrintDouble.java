package chaper5;

public class Q5_2PrintDouble {
	static int count = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		double d = 0.875;
		printBinary2(d);
		
	}
	static void printBinary(double d) {
		assert ( d > 0 && d < 1 ) : "bad number: " + d;
		System.out.print("0.");
		d *= 2;
		printBinaryHelper(d);
		
	}
	
	static void printBinaryHelper(double d) {
		if(d <= 0) 
			return;
		else if (count == 31)
			System.out.println("Error");
		else {
			count++;
			if (d >= 1) {
				System.out.print("1");
				d--;
				d *= 2;
				printBinaryHelper(d);
			}
			else {
				System.out.print("0");
				d *= 2;
				printBinaryHelper(d);
			}
		}
	}
	static void printBinary2(double d) {
		StringBuilder sb = new StringBuilder();
		d*=2;
		sb.append(".");
		int c = 2;
		while(d > 0) {
			
			if (d >= 1) {
				sb.append("1");
				d--;
			}
			else {
				sb.append("0");
			}
			d *= 2;
			c++;
			
			if(c == 31) 
				break;
		}
		if(c == 31) 
			System.out.println("Error");
		else
			System.out.println(sb);
	}
	
}
