package Java8Features;
import java.util.Collections;
import java.util.Comparator;

public class LambdaFunctions {

//	In Java lambda expression, if there is only one statement, you may or may not use return keyword. 
//	You must use return keyword when lambda expression contains multiple statements.

	public static void main(String[] args) {
		Calculator sum = (a, b) -> {
			return a + b;
		};

		Calculator sub = (a, b) -> {
			return a - b;
		};

		Calculator mul = (a, b) -> {
			return a * b;
		};

		Calculator div = (a, b) -> {
			return a / b;
		};

		System.out.println(sum.calculate(12, 5));
		System.out.println(sub.calculate(12, 5));
		System.out.println(mul.calculate(12, 5));
		System.out.println(div.calculate(12, 5));

	}
}

interface Calculator {
	int calculate(int a, int b);
}