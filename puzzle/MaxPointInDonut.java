package puzzle;

public class MaxPointInDonut {

}
class Donut {
	
}
class Point {
	Double x;
	Double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return x.hashCode() + y.hashCode();
	}
}
