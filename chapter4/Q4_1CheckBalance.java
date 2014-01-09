package chapter4;

public class Q4_1CheckBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	static boolean isBalanced(TreeNode t) {
		if(checkBalance(t) == -1) 
			return false;
		else 
			return true;
	}
	static int checkBalance(TreeNode t) {
		if (null == t) {
			return 0;
		}
		int leftHeight = checkBalance(t.left);
		if(leftHeight < 0)
			return -1;
		int rightHeight = checkBalance(t.right);
		if(rightHeight < 0 ||Math.abs(leftHeight - rightHeight) >1) {
			return -1;
		}
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
}
