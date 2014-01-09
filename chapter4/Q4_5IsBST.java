package chapter4;

public class Q4_5IsBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'0', '1', '0', '3', '4', '5'};
		TreeNode t = Q4_3BuildBST.buildBST(arr); 
		System.out.print(isBST(t));
	}
	static boolean isBST(TreeNode r) {
		if( null == r) 
			return true;
		return isBST(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	static boolean isBST(TreeNode r, int min, int max) {
		if (null == r) 
			return true;
		if(r.data < min || r.data > max)
			return false;
		return isBST(r.left, min, r.data) && isBST(r.right, r.data, max);
		
	}

}
