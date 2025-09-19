package OtherFeatures.DesignPatterns.Structural;

// Composite Design Pattern
public class CompositePattern {
	public static void main(String[] args) {
		// Example usage of the Composite pattern
		Component leaf1 = new Leaf("Leaf 1");
		Component leaf2 = new Leaf("Leaf 2");
		Composite composite = new Composite("Composite 1");

		composite.add(leaf1);
		composite.add(leaf2);

		composite.operation();
	}

	interface Component {
		void operation();
	}

	static class Leaf implements Component {
		private String name;

		public Leaf(String name) {
			this.name = name;
		}

		@Override
		public void operation() {
			System.out.println("Leaf: " + name);
		}
	}

	static class Composite implements Component {
		private String name;
		private java.util.List<Component> children = new java.util.ArrayList<>();

		public Composite(String name) {
			this.name = name;
		}

		public void add(Component component) {
			children.add(component);
		}

		public void remove(Component component) {
			children.remove(component);
		}

		@Override
		public void operation() {
			System.out.println("Composite: " + name);
			for (Component child : children) {
				child.operation();
			}
		}

	}

}
