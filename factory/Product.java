package factory;


public class Product {
	public String name;
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		Product[] items = new Product[2];
		Factory[] facts = new Factory[2];
		facts[0] = new CarFactory();
		facts[1] = new PlaneFactory();
		
		items[0] = facts[0].build();
		items[1] = facts[1].build();
		
		System.out.println(items[0].getName());
		System.out.println(items[1].getName());
	}
}
