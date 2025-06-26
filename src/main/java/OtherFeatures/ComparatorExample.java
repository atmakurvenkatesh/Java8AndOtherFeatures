package OtherFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

	int age;
	String name;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public ComparatorExample(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Object [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {

		ComparatorExample o1 = new ComparatorExample(51, "bbb");
		ComparatorExample o2 = new ComparatorExample(37, "ddd");
		ComparatorExample o3 = new ComparatorExample(45, "ccc");
		ComparatorExample o4 = new ComparatorExample(37, "aaa");

		ArrayList<ComparatorExample> l = new ArrayList<>(Arrays.asList(o1, o2, o3, o4));

		Collections.sort(l, new AgeComparator());
		l.forEach(System.out::println);
		System.out.println();
		Collections.sort(l, new NameComparator());
		l.forEach(System.out::println);
		System.out.println();

		// Comparator using in lambda
		Collections.sort(l, (obj1, obj2) -> obj1.age - obj2.age);
		Collections.sort(l, (obj1, obj2) -> obj1.name.compareTo(obj2.name));

		// Comparator using in lambda
		l.sort(Comparator.comparingInt(obj -> obj.age));
		l.sort(Comparator.comparing(ComparatorExample::getName));

		// reverse a list
		l.sort(Comparator.comparingInt(ComparatorExample::getAge).reversed());

		ComparatorExample o5 = new ComparatorExample(37, "bbb");
		l.add(o5);

		// nested sorting
		l.sort(Comparator.comparingInt(ComparatorExample::getAge).thenComparing(ComparatorExample::getName));
		l.forEach(System.out::println);

	}

}

class AgeComparator implements Comparator<ComparatorExample> {

	@Override
	public int compare(ComparatorExample o1, ComparatorExample o2) {
		if (o1.age == o2.age) {
			return 0;
		} else if (o1.age > o2.age) {
			return 1;
		} else {
			return -1;
		}
	}
}

class NameComparator implements Comparator<ComparatorExample> {

	@Override
	public int compare(ComparatorExample o1, ComparatorExample o2) {
		return o1.name.compareTo(o2.name);
	}
}
