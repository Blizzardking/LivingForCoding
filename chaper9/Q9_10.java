package chaper9;
import java.util.*;
public class Q9_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box[] bs = {new Box(1,1,3), new Box(2,3,4), new Box(3, 5, 3), new Box(5,6,7), new Box(7,8,9)};
		printMax(bs);

	}
	static void printMax(Box[] boxes) {
		int maxHeight = 0;
		String s = "";
		ArrayList<Box> maxStack = null;
		HashMap<Box, ArrayList<Box>> hm = new HashMap<Box, ArrayList<Box>>();
		for(int i = 0; i< boxes.length; i++){
			ArrayList<Box> st = getMaxStack(boxes, hm, boxes[i]);
			if(height(st) > maxHeight) 
				maxStack = st;
		}
		System.out.println(maxStack);
	}
	static ArrayList<Box> getMaxStack(Box[] boxes, 
			HashMap<Box, ArrayList<Box>> table, Box bottom) {
		if(bottom != null && table.containsKey(bottom)) {
			return table.get(bottom);
		}
		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for(int i = 0; i < boxes.length; i++) {
			ArrayList<Box> stack = null;
			if(boxes[i].canOnTopOf(bottom)) {
				stack = getMaxStack(boxes, table, boxes[i]);
			}
			int newHeight = height(stack);
			if(maxHeight < newHeight) {
				maxHeight = newHeight;
				maxStack = stack;
			}
		}
		if(null == maxStack) 
			maxStack = new ArrayList<Box>();
		if(null != bottom) {
			maxStack.add(0, bottom);
			table.put(bottom, maxStack);
		}
		return (ArrayList<Box>)maxStack.clone();
		
	}
	static int height(ArrayList<Box> stack) {
		int height = 0;
		if(null == stack) 
			return 0;
		for(Box b: stack) {
			height += b.height;
		}
		return height;
	}

}
class Box {
	int width;
	int height;
	int depth;
	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
	public boolean canOnTopOf(Box b) {
		return width < b.width && height < b.height && depth < b.depth;
	}
	
	public String toString() {
		return "(" + width + ", " + height + ", " + depth + ")"; 
	}
}