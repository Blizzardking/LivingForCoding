package puzzle;

import java.util.*;

public class PrimeByErotosthenses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrime2(1000000001));
	}
	static List<Integer> getPrime(int n) {
		boolean[] isPrime = new boolean[n+1];
		List<Integer> list = new ArrayList<Integer>();
		for(int k = 2; k < isPrime.length; k ++) {
			isPrime[k] = true;
		}
		int i = 2;
		while(i <= Math.sqrt(n)) {
			
			if(isPrime[i]){
				int j = i * i;
				while(j <= n) {
					isPrime[j] = false;
					j += i;
				}
			}
			i++;
		}	
		for(int k = 2; k < isPrime.length; k ++) {
			if(isPrime[k])
				list.add(k);
		}
		return list;
	}
	static List<Integer> getPrimes(int m, int n) {
		boolean[] isPrime = new boolean[n+1];
		List<Integer> list = new ArrayList<Integer>();
		for(int k = 2; k < isPrime.length; k ++) {
			isPrime[k] = true;
		}
		int i = 2;
		while(i <= Math.sqrt(n)) {
			
			if(isPrime[i]){
				int j = i * i;
				while(j <= n) {
					isPrime[j] = false;
					j += i;
				}
			}
			i++;
		}	
		for(int k = m; k < isPrime.length; k ++) {
			if(isPrime[k])
				list.add(k);
		}
		return list;
	}
	static int isP[] = new int[100];
	static boolean isPrime(int n) {
		if(isP[n] == 1) 
			return true;
		if(isP[n] == 2)
			return false;
		int i = 2;
		List<Integer> list = new LinkedList<Integer>();
		while(i <= Math.sqrt(n)) {
			if(isPrime(i))
				list.add(i);
			i++;
		}
		for(Integer j: list) {
			if(n%j == 0) {
				isP[n] = 2;
				return false;
			}
		}
		isP[n] = 1;
		return true;
	}
	static boolean isPrime2(int n) {
		int i = 2;
		while(i <= Math.sqrt(n)) {
			if(n%i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

}
