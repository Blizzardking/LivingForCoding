package puzzle;

public class TraverseBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(2);
		t.left = new TreeNode(1);
		t.right = new TreeNode(3);
		t.right.right = new TreeNode(4);
		TreeNode p = t.right.right;
		traverse(t);
		while (null != p) {
			System.out.println(p.data);
			p = p.left;
		}
	}
	
	static Wrapper traverse(TreeNode t) {
		if( null == t) {
			return new Wrapper(null, null);
		}
		if( null == t.left && null == t.right) {
			return new Wrapper(t, t);
		}
		Wrapper left = traverse(t.left);
		Wrapper right = traverse(t.right);
		if(left.max != null && right.min !=null) {
			left.max.right = t;
			right.min.left = t;
			return new Wrapper(left.min, right.max);
		}
		else if(left.max == null && right.min !=null) {
			right.min.left = t;
			return new Wrapper(t, right.max);
		}
		else{
			left.max.right = t;
			return new Wrapper(left.min, t);
		}
	}
	
	static class Wrapper {
		TreeNode min;
		TreeNode max;
		public Wrapper(TreeNode l, TreeNode r) {
			min = l;
			max = r;
		}
	}

}
