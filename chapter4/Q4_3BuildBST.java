package chapter4;

public class Q4_3BuildBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'0', '1', '2', '3', '4', '5'};
		TreeNode t = buildBST(arr);
		preOrder(t);
	}
	static void preOrder(TreeNode r) {
		if (null == r) {
			return;
		}
		preOrder(r.left);
		System.out.print(r.data + " ");
		preOrder(r.right);
	}
	static TreeNode buildBST(char[] arr) {
		return buildBST(arr, 0, arr.length - 1);
	}
	static TreeNode buildBST(char[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = buildBST(arr, start, mid - 1);
		n.right = buildBST(arr, mid + 1, end);
		return n;
	}

}
