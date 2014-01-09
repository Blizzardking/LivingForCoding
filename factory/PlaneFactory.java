package factory;


public class PlaneFactory implements Factory {

	private Product buildPlane() {
		System.out.println("Have build a plane");
		return new Plane();
	}
	
	@Override
	public Product build() {
		// TODO Auto-generated method stub
		return buildPlane();
	}

}
