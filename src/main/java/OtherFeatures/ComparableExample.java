package OtherFeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparableExample implements Comparable<ComparableExample> {

	int age;
	String name;
	String location;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public ComparableExample(int age, String name, String location) {
		super();
		this.age = age;
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "ComparableExample [age=" + age + ", name=" + name + ", location=" + location + "]";
	}

	@Override
	public int compareTo(ComparableExample o) {
		if (this.age == o.age) {
			return 0;
		} else if (this.age > o.age) {
			return 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		ComparableExample o1 = new ComparableExample(51, "aaa", "hyd");
		ComparableExample o2 = new ComparableExample(37, "bbb", "bng");
		ComparableExample o3 = new ComparableExample(45, "ccc", "hyd");
		ComparableExample o4 = new ComparableExample(21, "ddd", "bng");
		List<ComparableExample> l = new ArrayList<ComparableExample>() {
			{
				add(o1);
				add(o2);
				add(o3);
				add(o4);
			}
		};
//		Collections.sort(l);
//		l.forEach(System.out::println);

		System.out.println();

		l.stream().sorted(Comparator.comparing(ComparableExample::getLocation).reversed()).forEach(System.out::println);

//		Map<String, List<ComparableExample>> resultSet = l.stream().collect(
//				groupingBy(ComparableExample::getLocation, mapping(Function.identity(), collectingAndThen(toList(),
//						e -> e.stream().sorted(Comparator.comparingInt(Student::getId)).collect(toList())))));

	}

}
