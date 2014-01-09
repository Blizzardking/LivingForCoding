package puzzle;

public class Symmetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char a = '\u007e';
		String s = "ÊÇ";
		byte[] b = s.getBytes();
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
		TreeNode t = new TreeNode();
		t.left = new TreeNode();
		t.right = new TreeNode();
		t.left.left = new TreeNode();
		t.left.right = new TreeNode();
		t.left.left.left = new TreeNode();
		t.right.left = new TreeNode();
		t.right.right = new TreeNode();
		t.right.right = new TreeNode();
		System.out.println(isSym(t));
	}
	static boolean isSym(TreeNode t) {
		if(null == t) return true;
		return isSym(t.left, t.right);
	}
	static boolean isSym(TreeNode l, TreeNode r)  {
		if (null == l)
			return null == r;
		if (null == r) 
			return null == l;
		if(!isSym(l.left, r.right)) {
			return false;
		}
		if(!isSym(l.right, r.left))	{
			return false;
		}
		return true;	
	}

}
