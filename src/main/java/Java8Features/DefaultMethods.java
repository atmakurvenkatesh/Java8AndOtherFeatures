package Java8Features;

/*-
https://www.javatpoint.com/java-default-methods

1.Java provides a facility to create default methods inside the interface. These methods are non-abstract methods.
2.You can also define static methods inside the interface. Static methods are used to define utility methods.

Abstract Class vs Java 8 Interface
-------------------------------------
After having default and static methods inside the interface, we think about the need of abstract class in Java.
An interface and an abstract class is almost similar except that you can create constructor in the abstract class whereas you can't do this in interface.

1) Default methods can be overridden in implementing class, while static cannot.
2) Static method belongs only to Interface class, so you can only invoke static method on Interface class, not on class implementing this Interface.
3) Both class and interface can have static methods with same names, and neither overrides other!

*/

interface DefaultMethodsInterface {

	void abstractMethod(String msg);

	// Default method
	default void defaultMethod() {
		System.out.println("This is a default method in the interface.");
	}

	// Static method in interface
	static void staticMethod() {
		System.out.println("This is a static method in the interface.");
	}
}

public class DefaultMethods implements DefaultMethodsInterface {
	// Implement abstract method
	@Override
	public void abstractMethod(String msg) {
		System.out.println("Message: " + msg);
	}

	// Override default method (optional)
	@Override
	public void defaultMethod() {
		System.out.println("Overridden default method in class.");
	}

	// can't be overridden method
	static void staticMethod() {
		System.out.println("This is a static method in the class.");
	}

	public static void main(String[] args) {
		DefaultMethods demo = new DefaultMethods();

		// Call abstract method
		demo.abstractMethod("Hello Interface");

		// Call default method
		demo.defaultMethod();

		// call static method of a class
		demo.staticMethod();

		// Call static method from interface
		DefaultMethodsInterface.staticMethod();
	}
}
