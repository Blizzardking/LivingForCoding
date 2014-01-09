package chaper5;
import java.util.*;
public class Q5_7FindMissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitInteger i = new BitInteger(32);
		BitInteger[] arr = {new BitInteger(0), new BitInteger(1), new BitInteger(2),
				new BitInteger(4),new BitInteger(5),new BitInteger(6),new BitInteger(3)};
		System.out.println(findMissingElement(arr));

	}
	static int findMissingElement(BitInteger[] A) {
		int[] bits = new int[BitInteger.INTEGER_SIZE];
		int m, n, j = 0;
		BitInteger[] B = new BitInteger[(A.length) / 2 + 1];
		BitInteger[] C = new BitInteger[(A.length) / 2 + 1];
		int newLength = A.length;
		do {
			m = 0;
			n = 0;
			for(int i = 0; i < newLength; i++){
				if(A[i].fetch(j) == 0) {
					B[m++] = A[i];
				}
				else {
					C[n++] = A[i];
				}
			}
			if(m > n) {
				A = Arrays.copyOf(C, n);
				newLength = n;
				bits[j++] = 1;
			}
			else {
				A = Arrays.copyOf(B, m);
				newLength = m;
				bits[j++] = 0;
			}
			if (j == BitInteger.INTEGER_SIZE) {
				return getNum(bits);
			}
		} while (true);
	}

	static public int getNum(int [] bits) {
		int number = 0;
		for (int j = bits.length - 1; j >= 0; j--){
			number = number | bits[j];
			if (j > 0) {
				number = number << 1;
			}
		}
		return number;
	}
}
class BitInteger {
	public static int INTEGER_SIZE = 32;
	private boolean[] bits;
	public BitInteger() {
		bits = new boolean[INTEGER_SIZE];
	}
	/* Creates a number equal to given value. Takes time proportional 
	 * to INTEGER_SIZE. */
	public BitInteger(int value){
		bits = new boolean[INTEGER_SIZE];
		for (int j = 0; j < INTEGER_SIZE; j++){
			if (((value >> j) & 1) == 1) 
				bits[j] = true;
			else 
				bits[j] = false;
		}
	}
	
	/** Returns k-th least-significant bit. */ 
	public int fetch(int k){
		if (bits[k])
			return 1;
		else 
			return 0;
	}
	
	/** Sets k-th least-significant bit. */
	public void set(int k, int bitValue){
		if (bitValue == 0 ) 
			bits[k] = false;
		else 
			bits[k] = true;
	}
	
	/** Sets k-th least-significant bit. */
	public void set(int k, char bitValue){
		if (bitValue == '0' ) 
			bits[k] = false;
		else 
			bits[k] = true;
	}
	
	/** Sets k-th least-significant bit. */
	public void set(int k, boolean bitValue){
		bits[k] = bitValue;
	}	
	
	public void swapValues(BitInteger number) {
		for (int i = 0; i < INTEGER_SIZE; i++) {
			int temp = number.fetch(i);
			number.set(i, this.fetch(i));
			this.set(i, temp);
		}
	}
		
	public int toInt() {
		int number = 0;
		for (int j = INTEGER_SIZE - 1; j >= 0; j--){
			number = number | fetch(j);
			if (j > 0) {
				number = number << 1;
			}
		}
		return number;
	}
	
	public String toString() {
		int number = 0;
		for (int j = INTEGER_SIZE - 1; j >= 0; j--){
			number = number | fetch(j);
			if (j > 0) {
				number = number << 1;
			}
		}
		return String.valueOf(number);
	}
}

