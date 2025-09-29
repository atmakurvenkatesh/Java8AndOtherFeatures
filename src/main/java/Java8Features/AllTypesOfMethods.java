package Java8Features;

/*
The order of code execution in a Java class is as follows.
 - Static variables are initialized.
 - Static blocks are executed.
 - When Constructor is called, default block will be executed if any
 - Constructor is executed.
 - Instance variables are initialized.
 - Instance blocks are executed.
 - Static methods can be called without creating an instance.
*/
public class AllTypesOfMethods {
	public static void main(String[] args) {
		AllMethods.staticMethod();
		AllMethods a = new AllMethods();
		a.instancemethod();
	}
}

class AllMethods {

	{ // Default block
		System.out.println("INSIDE DEFAULT BLOCK");
	}

	static { // static block
		System.out.println("INSIDE STATIC BLOCK");
	}

	static void staticMethod() { // static block
		System.out.println("INSIDE STATIC METHOD");
	}

	AllMethods() {
		System.out.println("INSIDE CONSTRUCTOR");
	}

	public void instancemethod() {
		System.out.println("Inside Instance Method");
	}

}
