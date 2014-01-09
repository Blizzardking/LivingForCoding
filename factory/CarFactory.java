package factory;
import java.util.*;
public class CarFactory implements Factory {

	private Product buildCar() {
		System.out.println("Have build a car");
		
		return new Car();
		

	}
	
	@Override
	public Product build() {
		// TODO Auto-generated method stub
		return buildCar();
	}

}
