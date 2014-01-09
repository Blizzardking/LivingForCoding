package chaper5;

public class Q5_1InsertMToN {
	static int clearBits1(int num, int i) {
		int mask = (1 << (i + 1)) -1;
		return num & mask; 
	}
	
	static int updateBits1(int num, int v, int i, int j) {
		int mask = ( -1 << (j + 1)) | ~(-1 << i);
		return (num & mask) | (v << i);
	}
	
	static int insert(int N, int M, int i, int j){
		int temp = M;
		int lengthM = 0;
		while(temp > 0) {
			temp >>=1;
			lengthM++;
		}
		if(lengthM > j - i + 1) {
			System.err.println("Error!");
			System.exit(-1);
			
		}
		int end = i + lengthM - 1;
		return update(N, M, i, end);
	}
	static int update(int N, int M, int i, int j) {
//		int mask1 = (1 << i) -1;
//		System.out.println(Integer.toBinaryString(mask1));
//		int mask2 = ~((1 << (j+1)) -1);
//		System.out.println(Integer.toBinaryString(mask2));
		int mask = ((1 << i) - 1) | ~((1 << (j+1)) -1);
		int temp1 = mask & N;
		System.out.println(Integer.toBinaryString(mask));
		int temp2 = M << i;
		
		return temp1 | temp2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0b1000001111101100110110;
		int v = 0b10011;
		System.out.println(Integer.toBinaryString(updateBits1(num, v, 2, 6)));
	}

}
