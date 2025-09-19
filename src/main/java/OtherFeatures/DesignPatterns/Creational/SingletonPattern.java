package OtherFeatures.DesignPatterns.Creational;

public class SingletonPattern {
	public static void main(String[] args) {
		// Example usage of the Singleton pattern
		Singleton singletonInstance = Singleton.getInstance();
		singletonInstance.showMessage();
	}
}

class Singleton {
	private static Singleton instance;

	private Singleton() {
		// private constructor to prevent instantiation
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello from the Singleton instance!");
	}
}
