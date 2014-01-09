package chaper9;
import java.util.*;
public class Q9_6PrintAllParenses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printAllPairs(10).size());

	}
	static void pirntAllPairs(int n) {
		
	}
	static Set<String> printAllPairs(int n) {
		HashSet<String>[] M = (HashSet<String>[])new HashSet[n + 1];
		for(int i = 0; i < M.length; i++) {
			M[i] = new HashSet<>();
		}
		M[0].add("");
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= i - 1; j++) {
//				if(M[j].size() == 0) {
//					StringBuilder sb = new StringBuilder("()");
//					for(String s2: M[i - 1 -j]) {
//						sb.append(s2);
//						M[i].add(sb.toString());
//					}
//				}
//				else {
					for(String s1: M[j]) {
//						if(M[i - 1 -j].size() == 0) {
//							sb.insert(0, '(');
//							sb.append(')');
//							M[i].add(sb.toString());
//						}
//						else {
							for(String s2: M[i - 1 -j]) {

								StringBuilder sb = new StringBuilder();
								sb.append('(');
								sb.append(s1);
								sb.append(')');
								sb.append(s2);
								M[i].add(sb.toString());
							}
						
					}
				
			}
		}

		return M[n];
	}
	static void parenthesis(int n, String s, boolean isChain) {
		if(n == 0) {
			System.out.println();
			
		}
	}
}
