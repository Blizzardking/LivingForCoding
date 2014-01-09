package factory;

public class Singleton {
	private static Singleton _instance = null;
	int data; 
	
	private Singleton() {
		data = 1;
	}
	
	public static Singleton Instance() {
		if(null == _instance) {
			_instance = new Singleton();
		}
		
		return _instance;
	}
}
