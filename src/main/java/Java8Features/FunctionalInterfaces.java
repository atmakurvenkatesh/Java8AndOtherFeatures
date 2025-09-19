package Java8Features;

import java.util.function.*;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		// Consumer
		Consumer<String> consumer = s -> System.out.println("Consumed: " + s);
		consumer.accept("Hello Consumer");

		// BiConsumer
		BiConsumer<Integer, String> biconsumer = (k, v) -> System.out.println("BiConsumer Consumed: " + k + ":" + v);
		biconsumer.accept(123, "value");

		// Supplier
		Supplier<Double> supplier = () -> Math.random();
		System.out.println("Supplied: " + supplier.get());

		// Predicate
		Predicate<Integer> isEven = n -> n % 2 == 0;
		System.out.println("Is 10 even? " + isEven.test(10));
		System.out.println("Is 7 even? " + isEven.test(7));

		// Function
		Function<String, Integer> length = s -> s.length();
		System.out.println("Length of 'Lambda': " + length.apply("Lambda"));

		// BiFunction
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println("Sum: " + add.apply(5, 7));

		// UnaryOperator
		UnaryOperator<Integer> square = n -> n * n;
		System.out.println("Square of 6: " + square.apply(6));

		// BinaryOperator
		BinaryOperator<Integer> multiply = (a, b) -> a * b;
		System.out.println("Multiply 3 * 4: " + multiply.apply(3, 4));
	}
}
