package oj;
import java.util.*;
public class RPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"0", "3", "/"};
		System.out.println(evalRPN(tokens));
	}

	static int evalRPN(String[] tokens) {
		Stack<Integer> result = new Stack<Integer>();
		HashSet<String> operators = new HashSet<String>();
		operators.add("+");
		
		for (int i = 0; i < tokens.length; i++) {
			if (!operators.contains(tokens[i])) {
				result.push(Integer.valueOf(tokens[i]));
			} else {
				int operand1 = result.pop();
				int operand2 = result.pop();
				int res = 0;
				char op = tokens[i].charAt(0);
				switch (op) {
				case '+':
					res = operand2 + operand1;
					break;
				case '-':
					res = operand2 - operand1;
					break;
				case '*':
					res = operand2 * operand1;
					break;
				case '/':
					res = operand2 / operand1;
					break;
				default:
					System.err.println("Error");
				}
				result.push(res);
			}
		}
		int finalResult = result.pop();
		// if(!result.isEmpty()) {
		// throw new Exception("Invalid Expression");
		// }
		return finalResult;
	}

}
