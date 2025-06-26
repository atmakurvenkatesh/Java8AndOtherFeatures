package OtherFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample2 {
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(4, 6, 2, 6, 8, 21, 5, 86, 24, 1, 55);

		// different ways to sort
		Collections.sort(l1);
		l1.sort(Comparator.naturalOrder());
		l1.sort(Comparator.reverseOrder());
		l1.sort((a, b) -> a - b);
		l1.sort((a, b) -> Integer.compare(a, b));
		l1.sort(Integer::compareTo);
		l1.sort(Integer::compare);
		l1.sort(Comparator.comparingInt(i -> i));

		List<String> l2 = new ArrayList<>(Arrays.asList("rihbbaiy", "rebvat", "lodsgb", "gewal", "ashf", "grwsgi"));

		l2.sort(Comparator.naturalOrder());
		l2.sort(String.CASE_INSENSITIVE_ORDER);
		l2.sort(String::compareTo);
		l2.sort(String::compareToIgnoreCase);

		// sort by length
		l2.sort((s1, s2) -> s1.length() - s2.length());
		l2.sort(Comparator.comparingInt(s -> s.length()));

		// sort by length and then alphabetical
		l2.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
		l2.forEach(System.out::println);
	}
}
