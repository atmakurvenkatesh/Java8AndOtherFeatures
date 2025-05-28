package OtherFeatures;

/*
 * Marker interface is an empty interface (no field or methods). 
 * Examples of marker interface are Serializable, Cloneable and Remote interface. 
 * All these interfaces are empty interfaces. It is used to "mark" java classes so that objects of these classes may get certain capability.
*/

public class CloneableExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(20, "GeeksForGeeks");

		// cloning 'a' and holding
		// new cloned object reference in b

		// down-casting as clone() return type is Object
		A b = (A) a.clone();
		b.i = 50;
		System.out.println(a.i);
		System.out.println(a.s);

		System.out.println(b.i);
		System.out.println(b.s);
	}
}

class A implements Cloneable {
	int i;
	String s;

	// A class constructor
	public A(int i, String s) {
		this.i = i;
		this.s = s;
	}

	// Overriding clone() method by simply calling Object class clone() method.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}