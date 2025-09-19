package Java8Features;

/*
The order of code execution in a Java class is as follows.
1.Static variables are initialized.
2.Static blocks are executed.
3.Constructor is executed.
4.Instance variables are initialized.
5.Instance blocks are executed.
6.Static methods can be called without creating an instance.
*/
public class AllTypesOfMethods {
	public static void main(String[] args) {
		AllMethods.staticMethod();
		AllMethods a = new AllMethods();
		a.instantmethod();
	}
}

class AllMethods {

	static { // static block
		System.out.println("INSIDE STATIC BLOCK");
	}

	static void staticMethod() { // static block
		System.out.println("INSIDE STATIC METHOD");
	}

	AllMethods() {
		System.out.println("INSIDE CONSTRUCTOR");
	}

	public void instantmethod() {
		System.out.println("Inside Instant Method");
	}

}
