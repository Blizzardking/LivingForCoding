package chaper9;
import java.util.*;
public class Q9_9EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board =  new int[8][8]; 
		Set<String> s = new HashSet<String>();
		check2(board, 0, s);
		System.out.println(s.size());
		
	}
	static Set<String> set = new HashSet<String>();
	static int[] columns = new int[8];
	static boolean check(int[][] board, int i) {
		if(i == 8){
			for(int j = 0; j < columns.length; j++) {
				System.out.print(columns[j] + " ");
			}
			System.out.println();
			return true;
		}
		for(int j= 0; j < 8; j++) {
			board[i][j] = 1;
			columns[i] = j;
			if(isValid(board, i, j) && check(board, i + 1))
				continue;
			board[i][j] = 0;
		}
		return false;
	}
	static void check2(int[][] board, int i, Set<String> set) {
		if(i == 8){
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int k = 0; k < columns.length; k++) {
				sb.append("(" + k + ", " + columns[k] + ") ");
			}
			sb.append("]");
			set.add(sb.toString());
			return;
		}
		for(int j= 0; j < 8; j++) {
			board[i][j] = 1;
			columns[i] = j;
			if(isValid(board, i, j))
				check2(board, i + 1, set);
			board[i][j] = 0;
		}
	}
	static boolean isValid(int[][] board, int x, int y) {
		//boolean flag = true;
		int m = y - 1, n = y + 1;
		for(int i = x - 1; i >= 0; i--) {
			if(board[i][y] == 1)
				return false;
			if(m >= 0 && board[i][m] == 1) {
				return false;
			}
			if(n < 8 && board[i][n] == 1) {
				return false;
			}
			m--;
			n++;
		}
		return true;
	}

}
