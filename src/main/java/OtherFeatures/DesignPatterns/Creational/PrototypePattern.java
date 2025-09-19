package OtherFeatures.DesignPatterns.Creational;

// prototype pattern is a creational design pattern that allows cloning of objects
public class PrototypePattern {
	public static void main(String[] args) {
		// Example usage of the Prototype pattern
		ConcretePrototype prototype = new ConcretePrototype("Original");
		ConcretePrototype clone = (ConcretePrototype) prototype.clone();

		System.out.println("Original: " + prototype.getName());
		System.out.println("Clone: " + clone.getName());

		// Modifying the clone
		clone.setName("Modified Clone");
		System.out.println("After modification:");
		System.out.println("Original: " + prototype.getName());
		System.out.println("Clone: " + clone.getName());
	}

	// Prototype interface
	interface Prototype {
		Prototype clone();
	}

	// Concrete prototype class
	static class ConcretePrototype implements Prototype {
		private String name;

		public ConcretePrototype(String name) {
			this.name = name;
		}

		@Override
		public Prototype clone() {
			return new ConcretePrototype(this.name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
