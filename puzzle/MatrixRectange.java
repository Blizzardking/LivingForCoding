package puzzle;
import java.util.*;
public class MatrixRectange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = 
				{{0,0,0,1,1},
				{0,0,1,1,1},
				{0,1,0,1,1},
				{0,0,0,1,1}};
		System.out.println(maximalRectangle(matrix));

	}
	public static int maximalRectangle(int[][] matrix) {
		if (matrix.length == 0)
			return 0;

		// initialize the height that starts from each row and extends in a
		// bottom-up fashion
		// note that the # of columns is one larger because an extra 0 needs to
		// be appended for the given largest rectangle in histogram algorithm
		int[][] height = new int[matrix.length][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					height[i][j] = 0;
				} else {
					if (i == 0)
						height[i][j] = 1;
					else
						// height[i-1][j] will be 0 if matrix[i-1][j] = 0
						height[i][j] = height[i - 1][j] + 1;
				}
			}
		}

		// calculate the largest rectangle in each histogram
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			maxArea = Math.max(maxArea, largestRectangleinHistogram(height[i]));
		}
		return maxArea;
	}

	private static int largestRectangleinHistogram(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, height[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}
}
