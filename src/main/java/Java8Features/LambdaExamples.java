package Java8Features;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class LambdaExamples {

	public static void main(String[] args) {

		// 1. No Parameters
		Runnable r = () -> System.out.println("Hello, Lambda!");
		r.run();

		// 2. Single Parameter
		Consumer<String> printer = (String s) -> System.out.println("Printer1: " + s);
		Consumer<String> printer2 = (var s) -> System.out.println("Printer2: " + s);
		Consumer<String> printer3 = s -> System.out.println("Printer3: " + s);
		printer.accept("Hi");
		printer2.accept("Hello");
		printer3.accept("Welcome");

		// 3. Multiple Parameters
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println("Add: " + add.apply(5, 7));

		// 4. Block Body (multiple statements)
		BinaryOperator<Integer> multiplyAndLog = (a, b) -> {
			int result = a * b;
			System.out.println("Multiply result: " + result);
			return result;
		};
		multiplyAndLog.apply(3, 4);

		// 5. Using Lambdas with Collections
		List<String> names = Arrays.asList("Charlie", "Bob", "Alice");

		// forEach
		System.out.println("forEach with lambda:");
		names.forEach(name -> System.out.println(name));

		// sort
		names.sort((a, b) -> a.compareTo(b));
		System.out.println("Sorted: " + names);

		// 6. Method Reference
		System.out.println("Method reference for printing:");
		names.forEach(System.out::println);

		// 7. Streams API
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println("Squares: " + squares);
	}
}
