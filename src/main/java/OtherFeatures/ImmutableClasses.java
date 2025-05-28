package OtherFeatures;

public class ImmutableClasses {
	public static void main(String[] args) {
		ImmutableClassExample cls = new ImmutableClassExample("creating a immutable class");
		System.out.println(cls.getVal());
	}
}

// https://www.geeksforgeeks.org/create-immutable-class-java/
// 1.The class must be declared as final so that child classes can’t be created.
// 2.Data members in the class must be declared private so that direct access is not allowed.
// 3.Data members in the class must be declared as final so that we can’t change the value of it after object creation.
// 4.A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
// 5.Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
final class ImmutableClassExample {

	private final String val;

	public ImmutableClassExample(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

	// Note that there should not be any setters
}
