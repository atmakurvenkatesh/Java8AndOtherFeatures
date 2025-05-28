package OtherFeatures;

import java.util.LinkedList;
import java.util.Vector;

public class VariableArgs {

	public static void main(String[] args) {

//		VariableArgsClass.printElements("sdf", "gr", "grgk", "rehgi");

		VariableArgsClassGeneric1<String> s = new VariableArgsClassGeneric1<>();
		s.printElements("sdf", "gr", "grgk", "rehgi");
	}
}

class VariableArgsClass {
	static void printElements(String... elements) {
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			System.out.println(elements[i]);
		}
	}
}

class VariableArgsClassGeneric1<E> {
	void printElements(E... elements) {
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			System.out.println(elements[i]);
		}
	}
}