package OtherFeatures.DesignPatterns.Creational;

public class AbstractFactoryPattern {
	public static void main(String[] args) {
		// Example usage of the Abstract Factory pattern
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		Shape1 circle = shapeFactory.getShape("CIRCLE");
		circle.draw();

		Shape1 square = shapeFactory.getShape("SQUARE");
		square.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		Color red = colorFactory.getColor("RED");
		red.fill();

		Color blue = colorFactory.getColor("BLUE");
		blue.fill();
	}
}

// Abstract Factory interface
interface AbstractFactory {

	Shape1 getShape(String shapeType);

	Color getColor(String colorType);
}

// Shape interface
interface Shape1 {
	void draw();
}

// Color interface
interface Color {
	void fill();
}

// Concrete Shape classes
class Circle1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}
}

class Square1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("Drawing a Square");
	}
}

class Rectangle1 implements Shape1 {
	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle");
	}
}

// Concrete Color classes
class Red implements Color {
	@Override
	public void fill() {
		System.out.println("Filling with Red color");
	}
}

class Blue implements Color {
	@Override
	public void fill() {
		System.out.println("Filling with Blue color");
	}
}

class Green implements Color {
	@Override
	public void fill() {
		System.out.println("Filling with Green color");
	}
}

// Factory for creating Shape objects
class ShapeFactory1 implements AbstractFactory {
	@Override
	public Shape1 getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle1();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square1();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle1();
		}
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		return null; // Not applicable for ShapeFactory
	}
}

// Factory for creating Color objects
class ColorFactory implements AbstractFactory {
	@Override
	public Shape1 getShape(String shapeType) {
		return null; // Not applicable for ColorFactory
	}

	@Override
	public Color getColor(String colorType) {
		if (colorType == null) {
			return null;
		}
		if (colorType.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (colorType.equalsIgnoreCase("BLUE")) {
			return new Blue();
		} else if (colorType.equalsIgnoreCase("GREEN")) {
			return new Green();
		}
		return null;
	}
}

// Factory producer to get the appropriate factory
class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory1();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}
