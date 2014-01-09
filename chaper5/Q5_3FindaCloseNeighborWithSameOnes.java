package chaper5;

public class Q5_3FindaCloseNeighborWithSameOnes {
	
	static int setBit(int num, int p) {
		return num | (1 << p);
	}
	static int clearBit(int num, int p) {
		return num & (~(1 << p));
		
	}
	static boolean getBit(int num, int p) {
		return ((num & (1 << p)) != 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0b01;
		System.out.println(Integer.toBinaryString(findNextBig(x)));
		int y = 0b1101100101111;
		System.out.println(Integer.toBinaryString(findNextSmall(y)));
		
	}
	static int findNextBig(int num) {
		if(num == -1 || num == 0)
			System.err.println("No next bigger!");
		int m = num;
		int p1 = 0;
		while(!getBit(m, p1)) 
			p1++;
		int p0 = p1 ;
		while(getBit(m, p0)) 
			p0++;
		if(p0 == 32) {
			System.out.println("No next smallest"); // 111110000;
			System.exit(-1);
		}
		m = setBit(m, p0);
		m = clearBit(m, p0 - 1);
		m = shiftR(m, p1, p0 -2);
		return m;
	}
	static int shiftR(int num, int i, int j) {
		if(j < i)
			return num;
		int length = j - i + 1;
		int mask1 = (1 << length) - 1;
		
		int mask2 = ~((1 << (j+1)) - 1);
		return (num & mask2) | mask1;
	}
	
	static int findNextSmall(int num) {
		if(num == 0 | num == -1) {
			System.err.println("No next Smallest!");
			System.exit(-1);
		}
		int n = num;
		if(!getBit(n,0)){
			int p1 = 0;
			while(!getBit(n, p1)) {
				p1++;
			}
			n = clearBit(n, p1);
			n = setBit(n, p1 -1);
		}
		else {
			int p3 = 0;
			while(getBit(n, p3)) {
				p3++;
			}
			int p0 = p3;
			while(!getBit(n, p0)) {
				p0++;
			}
			if(p0 == 32) {
				System.out.println("No next smallest"); // 000011111;
				System.exit(-1);
			}
			n = clearBit(n, p0);
			n = setBit(n, p0 -1);
			n = shiftL(n, p3 - 1, p0 - 2);
			
		}
		return n;
	}
	/*
	 * shift bit[0...i]  to bit[j-i...j];
	 */
	static int shiftL(int num, int i, int j) {
		if(i >= j)
			return num;
		int mask1 = ~((1 << j + 1) - 1);
		int temp1 = (1 << i + 1) - 1;
		return (num & mask1) | (temp1 << (j - i));
	}
}
