package OtherFeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	int age;
	String name;

	public ComparatorExample(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ComparatorExample [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {

		ComparatorExample o1 = new ComparatorExample(51, "bbb");
		ComparatorExample o2 = new ComparatorExample(37, "aaa");
		ComparatorExample o3 = new ComparatorExample(45, "ccc");
		List<ComparatorExample> l = new ArrayList<ComparatorExample>() {
			{
				add(o1);
				add(o2);
				add(o3);
			}
		};
		Collections.sort(l, new AgeComparator());
		l.forEach(System.out::println);
		System.out.println();
		Collections.sort(l, new NameComparator());
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
