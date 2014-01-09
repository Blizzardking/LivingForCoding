package puzzle;
import java.awt.Point;
import java.util.*;

public class LineAndPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		PriorityQueue<Distance> p = new PriorityQueue<>(10);
		Distance[] dists = new Distance[100];
		Point origin = new Point(0, 0);
		for(int i = 0; i< 100; i++) {
			p.offer(new Distance(origin, new Point(i, i)));
		}
		//Arrays.sort(dists);
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 6);
		Point p3 = new Point(2, 1.5);
		Line line1 = new Line(p1, p2);
		Line line2 = new Line(p1, p3);
		
		Hashtable<Line, Integer> table = new Hashtable<>();
		System.out.println(line1.hashCode());
		System.out.println(line2.hashCode());
		table.put(line1, 1);
		table.put(line2, 2);
		System.out.println(line1.equals(line2));
		System.out.println(table.entrySet());
	}
	
	static class Point {
		double x;
		double y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	static class Line {
		Double slope;
		Double intercept;
		public Line(Point p1, Point p2) {
			if(p1.x != p2.x) {
				slope = (p2.y - p1.y) / (p1.x - p2.x);
				intercept = slope * (-p1.x) + p1.y;
			}
			else {
				slope = Double.MAX_VALUE;
				intercept = p1.x;
			}
		}
		@Override
		public int hashCode() {
			return slope.hashCode() + intercept.hashCode();
		}
		@Override
		public boolean equals(Object l) {
			if(l==this) return true;
			if(l==null || !(l instanceof Line)) 
				return false;
			boolean a = this.slope.doubleValue() == ((Line)l).slope.doubleValue();
			boolean b = this.intercept.doubleValue() == ((Line)l).intercept.doubleValue();
			return a&&b;
		}
		public String toString() {
			return "y = " + slope + "x + " + intercept;
		}
	}
	
	static class Distance implements Comparable<Distance> {
		Point p1;
		Point p2;
		public Distance(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
		public double getDist() {
			return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
					+ (p1.y - p2.y ) * (p1.y - p2.y ) );
		}
		public int compareTo(Distance d) {
			return (int)(d.getDist()-this.getDist());
		}
		public String toString() {
			return p2.toString();
		}
	}
}
